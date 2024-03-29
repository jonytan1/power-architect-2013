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
package ca.sqlpower.architect.swingui.action;

import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

import org.apache.log4j.Logger;

import ca.sqlpower.architect.swingui.ASUtils;
import ca.sqlpower.architect.swingui.ArchitectFrame;
import ca.sqlpower.architect.swingui.ArchitectSwingSession;
import ca.sqlpower.architect.swingui.ColumnEditPanel;
import ca.sqlpower.architect.swingui.ContainerPane;
import ca.sqlpower.architect.swingui.PlayPenComponent;
import ca.sqlpower.architect.swingui.Selectable;
import ca.sqlpower.architect.swingui.TablePane;
import ca.sqlpower.architect.swingui.event.ItemSelectionEvent;
import ca.sqlpower.architect.swingui.event.ItemSelectionListener;
import ca.sqlpower.architect.swingui.event.SelectionEvent;
import ca.sqlpower.architect.swingui.event.SelectionListener;
import ca.sqlpower.sqlobject.SQLColumn;
import ca.sqlpower.sqlobject.SQLObjectException;
import ca.sqlpower.sqlobject.SQLTable;
import ca.sqlpower.sqlobject.UserDefinedSQLType;
import ca.sqlpower.swingui.DataEntryPanelBuilder;

public class EditColumnAction extends AbstractArchitectAction {
	private static final Logger logger = Logger.getLogger(EditColumnAction.class);

	private SelectionHandler selectionHandler = new SelectionHandler();
	
	public EditColumnAction(ArchitectSwingSession session) {
        super(session, Messages.getString("EditColumnAction.name"), Messages.getString("EditColumnAction.description"), "edit_column"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
        setEnabled(false);
        
        session.getPlayPen().addSelectionListener(selectionHandler);
        setupAction(getPlaypen().getSelectedItems());
    }
	
	public EditColumnAction(ArchitectFrame frame) {
        super(frame, Messages.getString("EditColumnAction.name"), Messages.getString("EditColumnAction.description"), "edit_column"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		setEnabled(false);
        
        frame.addSelectionListener(selectionHandler);
        setupAction(getPlaypen().getSelectedItems());
	}

	public void actionPerformed(ActionEvent evt) {
	    List<SQLColumn> selectedCols = new ArrayList<SQLColumn>();
	    for (PlayPenComponent ppc : getPlaypen().getSelectedItems()) {
	        if (ppc instanceof TablePane) {
	            TablePane tp = (TablePane) ppc;
	            selectedCols.addAll(tp.getSelectedItems());
	        }
	    }
	        
	    if (selectedCols.isEmpty()) {
	        JOptionPane.showMessageDialog(getPlaypen(), Messages.getString("EditColumnAction.noColumnSelected")); //$NON-NLS-1$
	        return;
	    }
	    
	    try {
	        ColumnEditPanel cep = new ColumnEditPanel(selectedCols, getSession());
	        String dialogTitle;
	        if (selectedCols.size() == 1) {
	            SQLColumn column = selectedCols.get(0);
	            dialogTitle = Messages.getString(
	                    "EditColumnAction.columnPropertiesDialogTitle", column.getName());
	        } else {
	            dialogTitle = Messages.getString("EditColumnAction.multiEditDialogTitle");
	        }
	        JDialog d = DataEntryPanelBuilder.createDataEntryPanelDialog(
	                cep, frame, dialogTitle, DataEntryPanelBuilder.OK_BUTTON_LABEL);
	        d.setLocationRelativeTo(frame);
	        d.setVisible(true);
	        
        } catch (SQLObjectException ex) {
            ASUtils.showExceptionDialog(getSession(), "Failed to create column property editor", ex);
        }

	}
	
	// FIXME only used by InsertColumnAction
    protected void showDialog(final SQLTable st, final int colIdx) throws SQLObjectException {
        showDialog(st, colIdx, false, null);
    }

	
    // FIXME only used by InsertColumnAction
	protected void showDialog(
	        final SQLTable st,
	        final int colIdx,
	        final boolean addToTable,
	        final TablePane tp)
	throws SQLObjectException {
				    
		    logger.debug("Creating new column editor panel"); //$NON-NLS-1$
		    
            final SQLColumn column;
			if (!addToTable) {
                column = st.getColumn(colIdx);
			} else {
			    if (getSession().getSQLTypes().size() > 0) {
			        
			        // Iterate through the list of SQL Types, 
			        // uses the default one (if defined) from the 
			        // user preferences to create the SQLColumn.
			        UserDefinedSQLType defaultType = null;
			        for (UserDefinedSQLType type : getSession().getSQLTypes()) {
			            if (type.getType() == SQLColumn.getDefaultType()) {
			                defaultType = type;
			                break;
			            }
			        }
			        if (defaultType == null) {
			            defaultType = getSession().getSQLTypes().get(0);
			        }
			        column = new SQLColumn(defaultType);
			    } else {
			        column = new SQLColumn();
			    }
                
                // XXX it sucks to do this here, but the column can't determine its correct
                //     sequence name until it has a parent. By then, it will be too late.
                if (st.getPhysicalName() != null && !st.getPhysicalName().trim().equals("")) {
                    column.setAutoIncrementSequenceName(st.getPhysicalName() + "_" + column.getName() + "_seq"); //$NON-NLS-1$ //$NON-NLS-2$
                } else {
                    column.setAutoIncrementSequenceName(st.getName() + "_" + column.getName() + "_seq"); //$NON-NLS-1$ //$NON-NLS-2$
                }
			}
			
			final ColumnEditPanel columnEditPanel = new ColumnEditPanel(column, getSession());
			
			JDialog editDialog = DataEntryPanelBuilder.createDataEntryPanelDialog(
					columnEditPanel,
					frame,
					Messages.getString("EditColumnAction.columnPropertiesDialogTitle", column.getName()), //$NON-NLS-1$
					DataEntryPanelBuilder.OK_BUTTON_LABEL, //$NON-NLS-1$
					 new Callable<Boolean>(){
						public Boolean call() {
						    if (addToTable) {
						        tp.getModel().begin("adding a new column '" + columnEditPanel.getColPhysicalName().getText() + "'"); //$NON-NLS-1$ //$NON-NLS-2$
							    try {
							        tp.getModel().addColumn(column, colIdx);
							        tp.selectNone();
							        tp.selectItem(colIdx); // select new column
							    } catch (SQLObjectException e) {
							        ASUtils.showExceptionDialog(getSession(), "Error Could not add column to table", e); //$NON-NLS-1$
							    }
							}
	                        Boolean ret = Boolean.valueOf(columnEditPanel.applyChanges());
	                        if (addToTable) {
	                            tp.getModel().commit();
						    }
							return ret;
						}
					}, 
					new Callable<Boolean>(){
                        public Boolean call() {
							columnEditPanel.discardChanges();
							return Boolean.TRUE;
						}
					});
			editDialog.pack();
			editDialog.setLocationRelativeTo(frame);
			editDialog.setVisible(true);
	}

	/**
	 * Sets up the action's enabledness based on whether or not any columns
	 * are selected.
	 */
	private void setupAction(List<PlayPenComponent> selectedItems) {
		if (selectedItems.size() == 0) {
			setEnabled(false);
			logger.debug("Disabling EditColumnAction"); //$NON-NLS-1$
			putValue(SHORT_DESCRIPTION, Messages.getString("EditColumnAction.shortDescription")); //$NON-NLS-1$
		} else {
			Selectable item = selectedItems.get(0);
			String name = Messages.getString("EditColumnAction.selected"); //$NON-NLS-1$
			logger.debug("Selected Table"); //$NON-NLS-1$
			if (item instanceof TablePane) {				
				TablePane tp = (TablePane) item;
				
				if (tp.getSelectedItemIndex() > ContainerPane.ITEM_INDEX_TITLE ) {
					try {						
						logger.debug ("Enabling EditColumnAction"); //$NON-NLS-1$
						setEnabled(true);
						name = tp.getModel().getColumn(tp.getSelectedItemIndex()).getName();
					} catch (SQLObjectException ex) {
						logger.error("Couldn't get selected column name", ex); //$NON-NLS-1$
					}
				} else {
					name = tp.getModel().toString();
					setEnabled(false);
					logger.debug("Disabling EditColumnAction"); //$NON-NLS-1$
				}
			} 
			putValue(SHORT_DESCRIPTION, Messages.getString("EditColumnAction.specificColumnShortDescription", name)); //$NON-NLS-1$
		}
	}
	
	@SuppressWarnings("unchecked")
    private class SelectionHandler implements SelectionListener, ItemSelectionListener {

	    public void itemSelected(SelectionEvent e) {
            setupAction(getPlaypen().getSelectedItems());
            if (e.getSource() instanceof ContainerPane) {
                ((ContainerPane) e.getSource()).addItemSelectionListener(this);
            }
        }
        public void itemDeselected(SelectionEvent e) {
            setupAction(getPlaypen().getSelectedItems());
            if (e.getSource() instanceof ContainerPane) {
                ((ContainerPane) e.getSource()).removeItemSelectionListener(this);
            }
        }
        public void itemsDeselected(ItemSelectionEvent e) {
            setupAction(getPlaypen().getSelectedItems());
        }
        public void itemsSelected(ItemSelectionEvent e) {
            setupAction(getPlaypen().getSelectedItems());
        }
	    
	}

}
