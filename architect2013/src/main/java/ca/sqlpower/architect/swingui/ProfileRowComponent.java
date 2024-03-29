/*
 * Copyright (c) 2008, SQL Power Group Inc.
 *
 * This file is part of Power*Architect.
 *
 * Power*Architect is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 3 of the License, or
 * (at your option) any later version.
 *
 * Power*Architect is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>. 
 */
package ca.sqlpower.architect.swingui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.LayoutManager2;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.InputEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.UIManager;

import org.apache.log4j.Logger;

import ca.sqlpower.architect.profile.ProfileManager;
import ca.sqlpower.architect.profile.ProfileManagerImpl;
import ca.sqlpower.architect.profile.TableProfileResult;
import ca.sqlpower.architect.profile.event.ProfileChangeEvent;
import ca.sqlpower.architect.profile.event.ProfileChangeListener;
import ca.sqlpower.architect.profile.event.ProfileResultEvent;
import ca.sqlpower.architect.profile.event.ProfileResultListener;
import ca.sqlpower.architect.swingui.dbtree.DBTreeCellRenderer;
import ca.sqlpower.architect.swingui.event.SelectionEvent;
import ca.sqlpower.architect.swingui.event.SelectionListener;
import ca.sqlpower.object.AbstractSPListener;
import ca.sqlpower.object.SPListener;
import ca.sqlpower.sqlobject.SQLTable;
import ca.sqlpower.swingui.ProgressWatcher;
import ca.sqlpower.swingui.SPSUtils;

/**
 * A component that displays the status and either rowcount or progressbar
 * for the given table profile. Typical use is as one Row in the
 * ca.sqlpower.architect.swingui.ProfileManagerView, but has
 * no dependencies thereon.
 */
public class ProfileRowComponent extends JPanel implements Selectable {

    private static final Logger logger = Logger.getLogger(ProfileRowComponent.class);

    private enum ComponentType {
        ICON,
        TABLE_NAME,
        CONNECTION_NAME,
        TABLE_INFO,
        PROGRESS_BAR, 
        RELOAD, 
        CANCEL,
        DELETE;
    }

    /** The icon for all the rows (shared) */
    private static ImageIcon tableIcon = DBTreeCellRenderer.TABLE_ICON;
    
    /** The Stop Sign icon for all the rows (shared) */
    private static ImageIcon stopIcon =
        SPSUtils.createIcon("stop", "Stop Profile", ArchitectSwingSessionContext.ICON_SIZE);
    
    /** The reload icon for all the rows (shared) */
    private static ImageIcon refreshIcon =
        SPSUtils.createIcon("arrow_refresh", "Re-Profile", ArchitectSwingSessionContext.ICON_SIZE);

    /** shared delete icon */
    private static ImageIcon deleteIcon =
        SPSUtils.createIcon("delete", "Delete Profile", ArchitectSwingSessionContext.ICON_SIZE);
    
    /**
     * The profile result that this component visualizes. This should be
     * considered the "model" of this component.
     */
    private final TableProfileResult result;

    /**
     * The profile manager that owns the result we're visualizing.
     */
    private final ProfileManager pm;

    /**
     * The label component for this profile result row.  Its contents
     * are originally set to bogus but plausible numbers just to have
     * a feel of how big the status label should be when creating the
     * dialog.
     */
    private final JLabel statusLabel =
        new JLabel(String.format(TableProfileResult.TOSTRING_FORMAT, 500, "Mar 9, 2007", 15000, 10, 10));

    private final JButton reProfileButton, cancelButton, deleteButton;

    /**
     * Performs the custom layout for this row.  The layout
     * changes drastically when the profile results switch states
     * between populating and populated or canceled.
     */
    private static class RowComponentLayout implements LayoutManager2 {
        private int xGap;
        private int yGap;
        private Component icon;
        private Component tableName;
        private Component connectionName;
        private Component tableInfo;
        private Component progressBar;
        private Component reload;
        private Component cancel;
        private Component delete;


        public RowComponentLayout(int xGap, int yGap) {
            logger.debug("RowComponentLayout constructed");
            this.xGap = xGap;
            this.yGap = yGap;
        }

        public void addLayoutComponent(Component comp, Object constraints) {
            ComponentType type = (ComponentType) constraints;

            switch (type) {
            case ICON:
                icon = comp;
                break;
            case TABLE_NAME:
                tableName = comp;
                break;
            case CONNECTION_NAME:
                connectionName = comp;
                break;
            case TABLE_INFO:
                tableInfo = comp;
                break;
            case PROGRESS_BAR:
                progressBar = comp;
                break;
            case RELOAD:
                reload = comp;
                break;
            case CANCEL:
                cancel = comp;
                break;
            case DELETE:
                delete = comp;
                break;
            default:
                throw new IllegalStateException("Unknown constraint given to RowCompnentLayout");
            }
        }

        public float getLayoutAlignmentX(Container target) {
            return 0;
        }

        public float getLayoutAlignmentY(Container target) {
            return 0;
        }

        public void invalidateLayout(Container target) {
        }

        public Dimension maximumLayoutSize(Container target) {
            return preferredLayoutSize(target);
        }

        public void addLayoutComponent(String name, Component comp) {
            addLayoutComponent(comp, name);
        }

        public void layoutContainer(Container parent) {
            logger.debug("layoutContainer called");
            JComponent p = (JComponent) parent;
            Insets inset = p.getBorder().getBorderInsets(p);
            final int height = parent.getHeight() + inset.top;
            final int width = parent.getWidth() + inset.left;
            final int stretchyPreferredWidth = width -
                inset.left -
                inset.right -
                4 * xGap -
                icon.getPreferredSize().width -
                // reload and delete buttons are same size
                2 * reload.getPreferredSize().width;

            if (icon != null) {
                Dimension preferredSize = icon.getPreferredSize();
                int x = inset.left;
                int y = height /2 - preferredSize.height/2; 
                icon.setBounds(x, y, preferredSize.width, preferredSize.height);
            }
            if (tableName != null) {
                int preferredWidth = (int) Math.min(stretchyPreferredWidth, tableName.getPreferredSize().width);
                Dimension preferredSize = new Dimension(preferredWidth,
                        tableName.getPreferredSize().height);
                int x = inset.left + icon.getPreferredSize().width + xGap;
                int y = height /2 - yGap/2 - preferredSize.height;
                tableName.setBounds(x, y, preferredSize.width, preferredSize.height);
            }
            if (connectionName != null) {
                Dimension preferredSize = new Dimension(stretchyPreferredWidth - tableName.getPreferredSize().width,
                        connectionName.getPreferredSize().height);
                int x = inset.left + icon.getPreferredSize().width + xGap + tableName.getPreferredSize().width + xGap;
                int y = height /2 - yGap/2 - preferredSize.height;
                connectionName.setBounds(x, y, preferredSize.width, preferredSize.height);
            }
            if (tableInfo != null) {
                Dimension preferredSize = new Dimension(stretchyPreferredWidth,
                        tableInfo.getPreferredSize().height);
                int x = inset.left + icon.getPreferredSize().width + xGap;
                int y = height/2 + yGap/2;
                tableInfo.setBounds(x, y, preferredSize.width, preferredSize.height);
            }
            if (progressBar != null) {
                Dimension preferredSize = new Dimension(stretchyPreferredWidth,
                        progressBar.getPreferredSize().height);
                int x = inset.left + icon.getPreferredSize().width + xGap;
                int y = height/2 + yGap/2;
                progressBar.setBounds(x, y, preferredSize.width, preferredSize.height);
            }
            if (delete != null) {
                Dimension preferredSize = delete.getPreferredSize();
                int x = width - inset.right - preferredSize.width;
                int y = height/2 - preferredSize.height/2;
                delete.setBounds(x, y, preferredSize.width, preferredSize.height);
            }
            if (cancel != null) {
                Dimension preferredSize = cancel.getPreferredSize();
                int x = width - inset.right - preferredSize.width;
                int y = height/2 - preferredSize.height/2;
                cancel.setBounds(x, y, preferredSize.width, preferredSize.height);
            }
            if (reload != null) {
                Dimension preferredSize = reload.getPreferredSize();
                int x = width - inset.right - cancel.getPreferredSize().width - xGap - preferredSize.width;
                int y = height/2 - preferredSize.height/2;
                reload.setBounds(x, y, preferredSize.width, preferredSize.height);
            }
        }

        public Dimension minimumLayoutSize(Container parent) {
            return new Dimension(icon.getMinimumSize().width +  
                    3 * xGap + 
                    Math.max(progressBar.getMinimumSize().width, 
                            tableName.getMinimumSize().width +
                            xGap + connectionName.getMinimumSize().width) +
                            // reload and delete buttons same size
                            2 * reload.getMinimumSize().width, 
                            tableName.getMinimumSize().height +
                            yGap + progressBar.getMinimumSize().height);
        }

        public Dimension preferredLayoutSize(Container parent) {
            JComponent p = (JComponent) parent;
            Insets inset = p.getBorder().getBorderInsets(p);
            int maxOfBarAndInfo = Math.max(progressBar.getPreferredSize().width,
                    tableInfo.getPreferredSize().width);
            return new Dimension(icon.getPreferredSize().width +
                    3 * xGap +
                    Math.max(maxOfBarAndInfo, tableName.getPreferredSize().width +
                    xGap + connectionName.getPreferredSize().width) +
                    // reload and delete buttons same size
                    2 * reload.getPreferredSize().width +
                    inset.left + inset.right,
                    tableName.getPreferredSize().height +
                    yGap + progressBar.getPreferredSize().height +
                    inset.top + inset.bottom);
        }

        public void removeLayoutComponent(Component comp) {
        }

    }

    private class ProfileRowMouseListener extends MouseAdapter {
        public void mouseClicked(MouseEvent evt) {
            Object obj = evt.getSource();
            if (evt.getButton() == MouseEvent.BUTTON1) {
                if (evt.getClickCount() == 2) {
                    showProfile(obj);
                } else if ((evt.getModifiersEx() & SPSUtils.MULTISELECT_MASK) != 0) {
                    setSelected(!selected, SelectionEvent.CTRL_MULTISELECT);
                } else if ((evt.getModifiersEx() & InputEvent.SHIFT_DOWN_MASK) != 0){
                    setSelected(true, SelectionEvent.SHIFT_MULTISELECT);
                }  else {
                    setSelected(true, SelectionEvent.SINGLE_SELECT);
                }
            }
        }
    }
    
    /**
     * This will show the profile for a specific table (the source) or
     * an exception if the profile failed.
     */
    private void showProfile(Object source) {
        if (getResult().getException() != null) {
            ASUtils.showExceptionDialogNoReport(
                    ProfileRowComponent.this,
                    "Profiling failed for table " + getResult().getProfiledObject(),
                    getResult().getException());
        } else if (getResult().getProgressMonitor().isFinished() && 
                        !getResult().getProgressMonitor().isCancelled() &&
                        !(source instanceof JButton)) {
            ProfileResultsViewer profileResultsViewer = 
                new ProfileResultsViewer((ProfileManagerImpl) pm);
            profileResultsViewer.clearScanList();
            profileResultsViewer.addTableProfileResultToScan(result);
            profileResultsViewer.addTableProfileResult(result);
            profileResultsViewer.getDialog().setVisible(true);
        }
    }
    
    /**
     * Listens for changes in the profile's state (started, cancelled, finished)
     * and makes the appropriate UI updates on this component.
     */
    private final ProfileResultListener profileResultListener = new ProfileResultListener() {
        public void profileCancelled(ProfileResultEvent event) {
            statusLabel.setVisible(true);
            statusLabel.setText("Cancelled");
            cancelButton.setVisible(false);
            deleteButton.setVisible(true);
            progressBar.setVisible(false);
            reProfileButton.setVisible(true);
        }

        public void profileFinished(ProfileResultEvent event) {
            reProfileButton.setVisible(true);
            cancelButton.setVisible(false);
            deleteButton.setVisible(true);
            statusLabel.setVisible(true);
            if (result.getException() == null) {
                if (result.getCreateStartTime() >= 0) {
                    statusLabel.setText(result.toString());
                    statusLabel.setForeground(null);
                } else {
                    statusLabel.setText("Waiting to be profiled...");
                    statusLabel.setForeground(null);
                }
            } else {
                statusLabel.setText("Failed: " + result.getException().getMessage());
                statusLabel.setForeground(Color.RED);
            }
            progressBar.setVisible(false);
            if(ProfileRowComponent.this.getParent() != null) {
                fireProfileChangedEvent();
            }
        }

        public void profileStarted(ProfileResultEvent event) {
            reProfileButton.setVisible(false);
            deleteButton.setVisible(false);
            statusLabel.setVisible(false);
            cancelButton.setVisible(true);
        }
    };
    
    /**
     * Listens for changes to the result's start time so it can set the status
     * label correctly when the profiler has started profiling.
     */
    private final SPListener profileStartedListener = new AbstractSPListener() {
        
        @Override
        public void propertyChanged(PropertyChangeEvent evt) {
            if (evt.getPropertyName().equals("createStartTime") && result.getException() == null) {
                if (result.getCreateStartTime() >= 0) {
                    statusLabel.setText(result.toString());
                    statusLabel.setForeground(null);
                } else {
                    statusLabel.setText("Waiting to be profiled...");
                    statusLabel.setForeground(null);
                }
            } else if (evt.getPropertyName().equals("exception")) {
                statusLabel.setText("Failed: " + result.getException().getMessage());
                statusLabel.setForeground(Color.RED);
            }
        }
    };

    /**
     * Creates a profile row component that visualizes the given profile
     * result and provides a user interface for stopping, restarting,
     * deleting, and viewing the profile result.
     * 
     * @param result The profile result object to visualize.  Note that
     * the result will not normally be populated by the time it is given
     * to this component, but it should have already been added to the
     * profile manager.
     * @param pm The profile manager that the result belongs to.  It
     * would be better if the result object exposed a parent pointer back
     * to its manager, so this constructor could just take the result arg.
     */
    public ProfileRowComponent(final TableProfileResult result, final ProfileManager pm) {
        super(new RowComponentLayout(5, 5));
        this.result = result;
        this.pm = pm;
        setBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4));
        setBackground(Color.WHITE);

        add(new JLabel(tableIcon), ComponentType.ICON);
        
        addFocusListener(new FocusListener() {
        
            public void focusLost(FocusEvent e) {
                setBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4));
                logger.debug("Focus lost on " + result.getProfiledObject().getName() + " bounds are " + getBounds());
            }
        
            public void focusGained(FocusEvent e) {
                setBorder(BorderFactory.createLineBorder(Color.BLACK));
                logger.debug("Focus gained on " + result.getProfiledObject().getName() + " bounds are " + getBounds());
            }
        });
        
        this.reProfileButton = new JButton(refreshIcon);
        reProfileButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                pm.asynchCreateProfiles(Collections.singletonList(result.getProfiledObject()));
            }
        });
        
        this.cancelButton = new JButton(stopIcon);
        cancelButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                result.getProgressMonitor().setCancelled(true);
                logger.debug("STOP");
            }
        });
        
        Action deleteAction = new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                logger.debug("ProfileRowComponent: DELETE object: " + result);
                pm.removeProfile(result);
            }
        };
        deleteButton = new JButton(deleteAction);
        deleteButton.setIcon(deleteIcon);
        add(deleteButton, ComponentType.DELETE);
        
        SQLTable table = result.getProfiledObject();
        
        StringBuilder tableName = new StringBuilder();
        if (table.getCatalog() != null) {
            tableName.append(table.getCatalogName()).append(".");
        }
        if (table.getSchema() != null) {
            tableName.append(table.getSchemaName()).append(".");
        }
        tableName.append(table.getName());
        add(new JLabel(tableName.toString()), ComponentType.TABLE_NAME);
        
        add(new JLabel("(" + table.getParentDatabase().getName() + ")"), ComponentType.CONNECTION_NAME);
        
        add(reProfileButton, ComponentType.RELOAD);
        
        ProgressWatcher pw = new ProgressWatcher(progressBar, result.getProgressMonitor());
        pw.setHideLabelWhenFinished(true);
        pw.setHideProgressBarWhenFinished(true);
        pw.start();
        
        result.addProfileResultListener(profileResultListener);
        result.addSPListener(profileStartedListener);
        
        add(progressBar, ComponentType.PROGRESS_BAR);
        statusLabel.setVisible(false);
        add(statusLabel, ComponentType.TABLE_INFO);      
        add(cancelButton, ComponentType.CANCEL);  
        this.addMouseListener(new ProfileRowMouseListener());
        
        profileResultListener.profileFinished(null);
    }

    public TableProfileResult getResult() {
        return result;
    }
    
    private boolean selected = false;
    private List<SelectionListener> listeners = new ArrayList<SelectionListener>();

    private final JProgressBar progressBar = new JProgressBar();
    
    public void setSelected(boolean v,int selectionType) {
        logger.debug("Is this profile row component focusable? " + isFocusable());
        logger.debug("Does this panel have focus? " + isFocusOwner());
        if (v) {
            requestFocusInWindow();
        }
        selected = v;
        setBackground(selected ? UIManager.getColor("List.selectionBackground"): UIManager.getColor("List.background"));
        fireSelectionEvent(new SelectionEvent(ProfileRowComponent.this, selected ? SelectionEvent.SELECTION_EVENT : SelectionEvent.DESELECTION_EVENT,selectionType));
    }

    public boolean isSelected() {
        return selected;
    }

    public void addSelectionListener(SelectionListener l) {
        listeners.add(l);
    }

    public void removeSelectionListener(SelectionListener l) {
        listeners.remove(l);
    }
    
    public void fireSelectionEvent(SelectionEvent e) {
        for (SelectionListener listener : listeners) {
            if (e.getType() == SelectionEvent.SELECTION_EVENT) {
                listener.itemSelected(e);
            } else {
                listener.itemDeselected(e);
            }
        }
    }
    
    private final List<ProfileChangeListener> profileListeners = new ArrayList<ProfileChangeListener>();
    
    public void addProfileChangeListener(ProfileChangeListener pcl) {
        profileListeners.add(pcl);
    }
    
    public void removeProfileChangeListener(ProfileChangeListener pcl) {
        profileListeners.remove(pcl);
    }
    
    private void fireProfileChangedEvent() {
        ProfileChangeEvent e = new ProfileChangeEvent(pm, pm.getResults());
        for (int i = profileListeners.size() - 1; i >= 0; i--) {
            profileListeners.get(i).profileListChanged(e);
        }
    }
    
    @Override
    public String toString() {
        return result.getProfiledObject().getName() + " with status " + statusLabel.getText();
    }
}
