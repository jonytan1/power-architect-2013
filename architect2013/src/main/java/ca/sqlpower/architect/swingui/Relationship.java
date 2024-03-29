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
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.AbstractAction;
import javax.swing.Icon;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import javax.swing.event.MouseInputAdapter;

import org.apache.log4j.Logger;

import ca.sqlpower.architect.layout.LayoutEdge;
import ca.sqlpower.architect.layout.LayoutNode;
import ca.sqlpower.architect.swingui.PlayPen.MouseModeType;
import ca.sqlpower.architect.swingui.event.SelectionEvent;
import ca.sqlpower.object.AbstractSPListener;
import ca.sqlpower.object.SPChildEvent;
import ca.sqlpower.object.SPListener;
import ca.sqlpower.object.SPObject;
import ca.sqlpower.object.annotation.Accessor;
import ca.sqlpower.object.annotation.Constructor;
import ca.sqlpower.object.annotation.ConstructorParameter;
import ca.sqlpower.object.annotation.Mutator;
import ca.sqlpower.object.annotation.NonBound;
import ca.sqlpower.object.annotation.NonProperty;
import ca.sqlpower.object.annotation.Transient;
import ca.sqlpower.sqlobject.SQLObjectException;
import ca.sqlpower.sqlobject.SQLRelationship;
import ca.sqlpower.sqlobject.SQLRelationship.ColumnMapping;
import ca.sqlpower.sqlobject.SQLSchema;
import ca.sqlpower.swingui.ColorIcon;
import ca.sqlpower.swingui.ColourScheme;
import ca.sqlpower.util.TransactionEvent;
import ca.sqlpower.util.WebColour;

public class Relationship extends PlayPenComponent implements SPListener, LayoutEdge {
	private static final Logger logger = Logger.getLogger(Relationship.class);
	
    /**
     * Defines an absolute ordering of the child types of this class.
     * 
     * IMPORTANT!: When changing this, ensure you maintain the order specified by {@link #getChildren()}
     */
	public static final List<Class<? extends SPObject>> allowedChildTypes = PlayPenComponent.allowedChildTypes;
	
	public static final String PARENT_TO_CHILD = "receives";
	public static final String CHILD_TO_PARENT = "is received by";

    public static final Vector<Color> SUGGESTED_COLOURS;
    static {
        SUGGESTED_COLOURS = new Vector<Color>();
        SUGGESTED_COLOURS.addAll(ColourScheme.BREWER_SET19);
        SUGGESTED_COLOURS.add(new WebColour(0, 0, 0));
    }
	
    private SQLRelationship model;
	private TablePane pkTable;
	private TablePane fkTable;
	
	/**
	 * Weather this component is initialized completely.
	 */
	private boolean initCompleted = false;
	
	// ---------------variables definition for relationship that crosses two schemas.----------------------------
	/**
     * The object instead of pkTable to draw the line of relationship under the 
     * tab schema of playpen that fkTable belongs to.
	 */
	private AcrossedSchemaPane pkAcrossedSchema;
    /**
     * The object instead of fkTable to draw the line of relationship under the 
     * tab schema of playpen that pkTable belongs to.
     */
    private AcrossedSchemaPane fkAcrossedSchema;
    /**
     * Weather the schema that pkTable belongs to is the current schema under PlayPen.
     */
    private SQLSchema currentSchema;
    /**
     * A bitmask of the constants (PARENT|CHILD)_FACES_(LEFT|RIGHT|TOP|BOTTOM)
     * for the PlayPen's tab schema pane that the fkTable belongs to when 
     * this relationship crosses two schemas.
     */
    protected int orientationAcrossed;
    
    // ---------------end of variables definition for relationship that crosses two schemas.----------------------------
	
	/**
	 * This represents a percentage of how far along one of the sides the connection
	 * to the primary key table should be drawn.
	 */
	private double pkConnection;
    
    /**
     * This represents a percentage of how far along one of the sides the connection
     * to the foreign key table should be drawn.
     */
	private double fkConnection;
	
    /**
     * A bitmask of the constants (PARENT|CHILD)_FACES_(LEFT|RIGHT|TOP|BOTTOM).
     */
    protected int orientation;
    
    public static final int NO_FACING_EDGES = 0;
    public static final int PARENT_FACES_RIGHT = 1;
    public static final int PARENT_FACES_LEFT = 2;
    public static final int PARENT_FACES_BOTTOM = 4;
    public static final int PARENT_FACES_TOP = 8;
    public static final int CHILD_FACES_RIGHT = 16;
    public static final int CHILD_FACES_LEFT = 32;
    public static final int CHILD_FACES_BOTTOM = 64;
    public static final int CHILD_FACES_TOP = 128;
    public static final int CHILD_MASK = 240;
    public static final int PARENT_MASK = 15;

	private JPopupMenu popup;

	private boolean selected;
	
	private final TablePaneBehaviourListener tpbListener = new TablePaneBehaviourListener();

    private final AcrossedSchemaPaneBehaviourListener aspbListener = new AcrossedSchemaPaneBehaviourListener();

    /**
	 * The colour to highlight related columns with when this relationship is selected.
	 */
    private Color columnHighlightColour = ColourScheme.SQLPOWER_ORANGE;
    
    /**
     * This listener will disconnect this pane from the model if the pane is removed from the
     * container.
     */
    private final AbstractSPListener containerPaneListener = new AbstractSPListener() {
        public void childRemoved(SPChildEvent e) {
            if (e.getChild() == Relationship.this) {
                destroy();
            }
        }
     };
     
     /**
      * This listener will force a repaint when the label text changes
      */
     private final AbstractSPListener labelListener = new AbstractSPListener() {
         public void propertyChanged(PropertyChangeEvent evt) {
             repaint();
         }
      };

    /**
     * This constructor is only for making a copy of an existing relationship component.
     * It is not useful in general, and it doesn't even produce a fully-functional copy.
     * For instance, the copy won't have a working popup menu.
     * 
     * @param r The relationship to copy
     * @param contentPane The content pane this copy will live in
     */
	Relationship(Relationship r, PlayPenContentPane contentPane) {
	    super(r, contentPane);
		setParent(contentPane);
		this.model = r.model;
		setName(r.getName());
		this.pkTable = r.pkTable;
		this.fkTable = r.fkTable;
		this.pkConnection = r.getPkConnection();
		this.fkConnection = r.getFkConnection();
		this.selected = false;
		this.columnHighlightColour = r.columnHighlightColour;
		
		this.foregroundColor = r.getForegroundColor();
		this.backgroundColor = r.getBackgroundColor();
		
		this.orientation = r.orientation;
		
		// for the relationship that crosses two schemas.
		this.orientationAcrossed = r.orientationAcrossed;
		this.currentSchema = contentPane.getPlayPen().getModelOfCurrentTab();
		
		if (isMagicEnabled() != r.isMagicEnabled()) {
		    setMagicEnabled(r.isMagicEnabled());
		}
		
		try {
			RelationshipUI ui = (RelationshipUI) r.getUI().getClass().newInstance();
			ui.installUI(this);
			setUI(ui);
		} catch (InstantiationException e) {
			throw new RuntimeException("Woops, couldn't invoke no-args constructor of "+r.getUI().getClass().getName()); //$NON-NLS-1$
		} catch (IllegalAccessException e) {
			throw new RuntimeException("Woops, couldn't access no-args constructor of "+r.getUI().getClass().getName()); //$NON-NLS-1$
		}
		init();
	}
	
	/**
	 * This constructor simply creates a Relationship component for
     * the given SQLRelationship and adds it to the playpen.  It
     * doesn't maniuplate the model at all.
	 */
	public Relationship(SQLRelationship model, PlayPenContentPane parent) throws SQLObjectException {
	    this(model, parent.getPlayPen().findTablePane(model.getPkTable()), 
	            parent.getPlayPen().findTablePane(model.getFkTable()), parent);	    
	}
	
	public Relationship(SQLRelationship model, TablePane pkTable, 
	        TablePane fkTable, PlayPenContentPane parent) 
	throws SQLObjectException {
	    this (model, pkTable, fkTable, parent, 0, 0, 0, 0);	    
	}

	@Constructor
	public Relationship(@ConstructorParameter(propertyName="model") SQLRelationship model,
	        @ConstructorParameter(propertyName="pkTable") TablePane pkTable,
	        @ConstructorParameter(propertyName="fkTable") TablePane fkTable,
	        @ConstructorParameter(propertyName="parent") PlayPenContentPane parent,
	        @ConstructorParameter(propertyName="pkConnection") double pkConnection,
	        @ConstructorParameter(propertyName="fkConnection") double fkConnection,
            @ConstructorParameter(propertyName="orientation") int orientation,
	        @ConstructorParameter(propertyName="orientationAcrossed") int orientationAcrossed) 
	throws SQLObjectException {
	    super(model.getName());
		this.model = model;
		setPkTable(pkTable);
		setFkTable(fkTable);
        this.pkConnection = pkConnection;
        this.fkConnection = fkConnection;
		this.orientation = orientation;
		this.orientationAcrossed = orientationAcrossed;
		setParent(parent);
		this.currentSchema = parent.getPlayPen().getModelOfCurrentTab();
        setup();

        this.init();
	}

	/**
	 * All constructors have to call this after setting pp, model, pkTable, and fkTable.
	 */
	protected void setup() {
		updateUI();
		setOpaque(false);
		setBackgroundColor(Color.green);
		model.addSPListener(this);
		setToolTipText(model.getName());
	}

	protected void createPopup() {
		ArchitectFrame af = getPlayPen().getSession().getArchitectFrame();
		popup = new JPopupMenu();

		JMenuItem mi;

        JMenu setFocusToRelatedTables = new JMenu(Messages.getString("Relationship.setFocusMenu")); //$NON-NLS-1$
        mi = new JMenuItem();
        mi.setAction(af.getFocusToParentAction()); 
        mi.setActionCommand(PlayPen.ACTION_COMMAND_SRC_PLAYPEN);
        setFocusToRelatedTables.add(mi);
        mi = new JMenuItem();
        mi.setAction(af.getFocusToChildAction());
        mi.setActionCommand(PlayPen.ACTION_COMMAND_SRC_PLAYPEN);
        setFocusToRelatedTables.add(mi);
        popup.add(setFocusToRelatedTables);
        
        JMenu setRelationshipLineColor = new JMenu(Messages.getString("Relationship.relationshipLineColor")); //$NON-NLS-1$
        for (final Color color : SUGGESTED_COLOURS) {
            Icon icon = new ColorIcon(60, 25, color);
            mi = new JMenuItem(icon);
            mi.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    getPlayPen().startCompoundEdit("Set relationship line colour");
                    for (Relationship r : getPlayPen().getSelectedRelationShips()) {
                        r.setForegroundColor(color);
                    }
                    getPlayPen().endCompoundEdit("Set relationship line colour");
                }
            });
            setRelationshipLineColor.add(mi);
        }
        popup.add(setRelationshipLineColor);
        
        mi = new JMenuItem(af.getReverseRelationshipAction());
        popup.add(mi);
        
        mi = new JMenuItem(af.getEditRelationshipAction());
        mi.setActionCommand(PlayPen.ACTION_COMMAND_SRC_PLAYPEN);
        popup.add(mi);
        
        if (logger.isDebugEnabled()) {
            popup.addSeparator();
            mi = new JMenuItem(new AbstractAction("Show Mappings") {
                /**
                 * 
                 */
                private static final long serialVersionUID = -8322133344548739211L;

                public void actionPerformed(ActionEvent e) {
                    StringBuffer componentList = new StringBuffer();
                    
                    for (ColumnMapping columnMap : getModel().getChildren(ColumnMapping.class)) {
                        componentList.append(columnMap).append("\n");
                    }
                    
                    JOptionPane.showMessageDialog(getPlayPen(), new JScrollPane(new JTextArea(componentList.toString())));
                }
            });
            popup.add(mi);
        }
        
        popup.addSeparator();
        mi = new JMenuItem(af.getDeleteSelectedAction());
        mi.setActionCommand(PlayPen.ACTION_COMMAND_SRC_PLAYPEN);
        popup.add(mi);
	}

	@Transient @Accessor
	public Point getPreferredLocation() {
		return ((RelationshipUI) getUI()).getPreferredLocation();
	}
	
	@Override
	public String toString() {
		return "Relationship: "+model; //$NON-NLS-1$
	}
	
	public void connect() {
        //Disconnect first in case the object is already connected. This ensures
        //a listener isn't addd twice.
        destroy();
        
        if (pkTable != null) {
            pkTable.addSPListener(tpbListener);
        }
        if (this.pkAcrossedSchema != null) {
            this.pkAcrossedSchema.addSPListener(aspbListener);
        }
        if (fkTable != null) {
            fkTable.addSPListener(tpbListener);
        }
        if (this.fkAcrossedSchema != null) {
            this.fkAcrossedSchema.addSPListener(aspbListener);
        }
        getParent().addSPListener(containerPaneListener);
        
        model.addSPListener(labelListener);
	}
	
	/**
	 * You must call this method when you are done with a TablePane
	 * component.  It unregisters this instance (and its UI delegate)
	 * on all event listener lists on which it was previously
	 * registered.
     */
	private void destroy() {
	    if (pkTable != null) {
            pkTable.removeSPListener(tpbListener);
        }
        if (this.pkAcrossedSchema != null) {
            this.pkAcrossedSchema.removeSPListener(aspbListener);
        }
        if (fkTable != null) {
            fkTable.removeSPListener(tpbListener);
        }
        if (this.fkAcrossedSchema != null) {
            this.fkAcrossedSchema.removeSPListener(aspbListener);
        }
	    getParent().removeSPListener(containerPaneListener);
	    
        model.removeSPListener(labelListener);
	}

	// -------------------- PlayPenComponent overrides --------------------

    public void updateUI() {
        RelationshipUI ui = (RelationshipUI) IERelationshipUI.createUI(this);
        ui.installUI(this);
		setUI(ui);
        updateLengths(false);
        
        if(isMagicEnabled())
            ui.bestConnectionPoints();
        
		revalidate();
    }

	// --------------------- SELECTABLE SUPPORT ---------------------

    @Transient @Mutator
	public void setSelected(boolean isSelected,int multiSelectType) {
		if (selected != isSelected) {
		    for (SQLRelationship.ColumnMapping m : getModel().getChildren(
		            SQLRelationship.ColumnMapping.class)) {
                
                if (isSelected) {
                    pkTable.addColumnHighlight(m.getPkColumn(), columnHighlightColour);
                    fkTable.addColumnHighlight(m.getFkColumn(), columnHighlightColour);
                } else {
                    pkTable.removeColumnHighlight(m.getPkColumn(), columnHighlightColour);
                    fkTable.removeColumnHighlight(m.getFkColumn(), columnHighlightColour);
                }
            }
			selected = isSelected;
			fireSelectionEvent(new SelectionEvent(this, selected ? SelectionEvent.SELECTION_EVENT : SelectionEvent.DESELECTION_EVENT,SelectionEvent.SINGLE_SELECT));
			repaint();
		}
	}

	@Transient @Accessor
	public boolean isSelected() {
		return selected;
	}

	// -------------------- ACCESSORS AND MUTATORS ---------------------

	@Transient @Accessor
    public String getUIClassID() {
        return RelationshipUI.UI_CLASS_ID;
    }

	public SQLRelationship getModel() {
		return model;
	}

	@Override
	public String getModelName() {
	    return model.getName();
	}
	
	@Mutator
	public void setPkTable(TablePane tp) {
	    TablePane oldPk = pkTable;
		if (pkTable != null) {
			pkTable.removeSPListener(tpbListener);
		}
		pkTable = tp;
		pkTable.addSPListener(tpbListener);
		firePropertyChange("pkTable", oldPk, pkTable);
		// XXX: update model?
	}

	@Accessor
	public TablePane getPkTable() {
		return pkTable;
	}

	@Mutator
	public void setFkTable(TablePane tp) {
	    TablePane oldFk = fkTable;
		if (fkTable != null) {
			fkTable.removeSPListener(tpbListener);
		}
		fkTable = tp;
		fkTable.addSPListener(tpbListener);
		firePropertyChange("fkTable", oldFk, fkTable);
		// XXX: update model?
	}

	private void init() {
	    initCompleted = true;
	    resetAcrossedPane();
	}
	
	/**
	 * Reset the SPListner for acrossed pane.
	 */
	private void resetAcrossedPane() {
	    if (!initCompleted) return;
	    
	    if (this.pkAcrossedSchema != null) {
	        this.pkAcrossedSchema.removeAcrossedSchemaRelationship(this);
	    }
        if (this.fkAcrossedSchema != null) {
            this.fkAcrossedSchema.removeAcrossedSchemaRelationship(this);
        }
        getPlayPen().setAcrossedSchemaForRelationship(this);
        if (this.pkAcrossedSchema != null) {
            this.pkAcrossedSchema.addAcrossedSchemaRelationship(this, true);
        }
        if (this.fkAcrossedSchema != null) {
            this.fkAcrossedSchema.addAcrossedSchemaRelationship(this, false);
        }
	}
	
	@Accessor
	public TablePane getFkTable() {
		return fkTable;
	}

	@Accessor(isInteresting=true)
	public double getPkConnection() {
		return pkConnection;
	}

	@Accessor(isInteresting=true)
	public double getFkConnection() {
		return fkConnection;
	}
    
    /**
     * Creates a point that tells the UI exactly where the connection should be connecting to the
     * primary key table.
     */
    public BasicRelationshipUI.ImmutablePoint createPkConnectionPoint() {
        
        Point p;
        RelationshipConnectible pane = getRelationshipConnectible(true);
        
        if((getOrientation2() & PARENT_FACES_BOTTOM) != 0)
            p = new Point((int)(pane.getWidth() * getPkConnection()), pane.getHeight());
        else if((getOrientation2() & PARENT_FACES_TOP) != 0)
            p = new Point((int)(pane.getWidth() * getPkConnection()), 0);
        else if((getOrientation2() & PARENT_FACES_LEFT) != 0)
            p = new Point(0, (int)(pane.getHeight() * getPkConnection()));
        else
            p = new Point(pane.getWidth(), (int)(pane.getHeight() * getPkConnection()));
        
        return new BasicRelationshipUI.ImmutablePoint(p);
    }
    
    /**
     * Creates a point that tells the UI exactly where the connection should be connecting to the
     * foreign key table.
     */
    public BasicRelationshipUI.ImmutablePoint createFkConnectionPoint() {
        
        Point p;
        RelationshipConnectible pane = getRelationshipConnectible(false);
        
        if((getOrientation2() & CHILD_FACES_BOTTOM) != 0)
            p = new Point((int)(pane.getWidth() * getFkConnection()), pane.getHeight());
        else if((getOrientation2() & CHILD_FACES_TOP) != 0)
            p = new Point((int)(pane.getWidth() * getFkConnection()), 0);
        else if((getOrientation2() & CHILD_FACES_LEFT) != 0)
            p = new Point(0, (int)(pane.getHeight() * getFkConnection()));
        else
            p = new Point(pane.getWidth(), (int)(pane.getHeight() * getFkConnection()));
        
        return new BasicRelationshipUI.ImmutablePoint(p);
    }
    
    /**
     * Takes the necessary info from the point and gets the percentage value we need to store
     */
    @Transient
    @Mutator
    public void setFkConnectionPoint(Point p) {
        if((getOrientation2() & CHILD_FACES_BOTTOM) != 0)
            setFkConnection(p.getX() / getRelationshipConnectible(false).getWidth());
        else if((getOrientation2() & CHILD_FACES_TOP) != 0)
            setFkConnection(p.getX() / getRelationshipConnectible(false).getWidth());
        else if((getOrientation2() & CHILD_FACES_LEFT) != 0)
            setFkConnection(p.getY() / getRelationshipConnectible(false).getHeight());
        else
            setFkConnection(p.getY() / getRelationshipConnectible(false).getHeight());
    }
    
    /**
     * Takes the necessary info from the point and gets the percentage value we need to store
     */
    @Transient
    @Mutator
    public void setPkConnectionPoint(Point p) {
        if((getOrientation2() & PARENT_FACES_BOTTOM) != 0)
            setPkConnection(p.getX() / getRelationshipConnectible(true).getWidth());
        else if((getOrientation2() & PARENT_FACES_TOP) != 0)
            setPkConnection(p.getX() / getRelationshipConnectible(true).getWidth());
        else if((getOrientation2() & PARENT_FACES_LEFT) != 0)
            setPkConnection(p.getY() / getRelationshipConnectible(true).getHeight());
        else
            setPkConnection(p.getY() / getRelationshipConnectible(true).getHeight());
    }
	
    /**
     * Returns the current orientation of this relationship; that is, which
     * sides of its PK table and its FK table it is attached to. The return
     * value is a bitmask of the constants
     * (PARENT|CHILD)_FACES_(LEFT|RIGHT|TOP|BOTTOM).
     */
	@Accessor(isInteresting=true)
	public int getOrientation() {
	    return orientation;
	}
	
	@Mutator
	public void setOrientation(int orientation) {	    
	    int oldValue = this.orientation;
	    this.orientation = orientation;
	    firePropertyChange("orientation", oldValue, orientation);
	    repaint();
	}

	@Mutator
	public void setPkConnection(double pk) {
	    double oldValue = pkConnection;
	    pkConnection = pk;
	    firePropertyChange("pkConnection", oldValue, pk);
	}

	@Mutator
	public void setFkConnection(double fk) {
	    double oldValue = fkConnection;
	    fkConnection = fk;
		firePropertyChange("fkConnection", oldValue, fk);
	}

	// ---------------- Component Listener ----------------
	private class TablePaneBehaviourListener extends AbstractSPListener {

        public void propertyChanged(PropertyChangeEvent evt) {
            /* (non-Javadoc)
             * @see ca.sqlpower.architect.swingui.PlayPenComponentListener#componentResized(ca.sqlpower.architect.swingui.PlayPenComponentEvent)
             */
            if ((evt.getPropertyName().equals("topLeftCorner") || (evt.getPropertyName().equals("lengths")))) {
                logger.debug("Component "+((PlayPenComponent)(evt.getSource())).getName()+" changed size"); //$NON-NLS-1$ //$NON-NLS-2$
                
                Point oldVal;
                Point newVal;
                if (evt.getPropertyName().equals("lengths")) {
                    Dimension oldDim = (Dimension) evt.getOldValue();
                    Dimension newDim = (Dimension) evt.getNewValue();
                    oldVal = new Point(oldDim.width, oldDim.height);
                    newVal = new Point(newDim.width, newDim.height);
                } else {
                    oldVal = (Point) evt.getOldValue();
                    newVal = (Point) evt.getNewValue();
                }
                if(oldVal.x != newVal.x || oldVal.y != newVal.y) {
                    if (evt.getSource() instanceof RelationshipConnectible) {
                        RelationshipConnectible rc = (RelationshipConnectible)(evt.getSource());
                        logger.debug("Component "+((PlayPenComponent)(evt.getSource())).getName()+" changed"); //$NON-NLS-1$ //$NON-NLS-2$
                        if (isRelatedRelationshipConnectible(rc)) {
                            ((BasicRelationshipUI) getUI()).revalidate();
                        }
                    }
                }
            } else if ("model.schemaParent".equals(evt.getPropertyName())) {
                if (evt.getSource() instanceof TablePane) {
                    boolean magicEnabled = ((TablePane)evt.getSource()).getModel().isMagicEnabled();
                    final Relationship r = Relationship.this;
                    if (!magicEnabled) {
                        r.setMagicEnabled(false);
                    }
                    r.resetAcrossedPane();
                    if (!magicEnabled) {
                        r.setMagicEnabled(true);
                    }
                }
            }
        }
	}
	
    // ---------------- Component Listener ----------------
    private class AcrossedSchemaPaneBehaviourListener extends AbstractSPListener {

        public void propertyChanged(PropertyChangeEvent evt) {
            /* (non-Javadoc)
             * @see ca.sqlpower.architect.swingui.PlayPenComponentListener#componentResized(ca.sqlpower.architect.swingui.PlayPenComponentEvent)
             */
            if ((evt.getPropertyName().equals("topLeftCorner") || (evt.getPropertyName().equals("lengths")))) {
                logger.debug("Component "+((PlayPenComponent)(evt.getSource())).getName()+" changed size"); //$NON-NLS-1$ //$NON-NLS-2$
                
                Point oldVal;
                Point newVal;
                if (evt.getPropertyName().equals("lengths")) {
                    Dimension oldDim = (Dimension) evt.getOldValue();
                    Dimension newDim = (Dimension) evt.getNewValue();
                    oldVal = new Point(oldDim.width, oldDim.height);
                    newVal = new Point(newDim.width, newDim.height);
                } else {
                    oldVal = (Point) evt.getOldValue();
                    newVal = (Point) evt.getNewValue();
                }
                if(oldVal.x != newVal.x || oldVal.y != newVal.y) {
                    if (evt.getSource() instanceof RelationshipConnectible) {
                        RelationshipConnectible rc = (RelationshipConnectible)(evt.getSource());
                        logger.debug("Component "+((PlayPenComponent)(evt.getSource())).getName()+" changed"); //$NON-NLS-1$ //$NON-NLS-2$
                        if (isRelatedRelationshipConnectible(rc)) {
                            ((BasicRelationshipUI) getUI()).revalidate();
                        }
                    }
                }
            }
        }
    }


	/**
	 * The RelationshipDecorationMover responds to mouse events on the
	 * relationship by moving either the PK or FK connection point so
	 * it is near the mouse's current position.  It ceases this
	 * activity when a mouse button is released.
	 *
	 * <p>The normal way to create a RelationshipDecorationMover is like this:
	 * <pre>
	 *  new RelationshipDecorationMover(myRelationship, &lt;true|false&gt;);
	 * </pre>
	 * note that no reference to the object is saved; it will cleanly dispose 
	 * itself when a mouse button is lifted and hence become eligible for garbage
	 * collection.
	 */
	protected static class RelationshipDecorationMover extends MouseInputAdapter {

		protected Relationship r;
		protected Point startingPk;
		protected Point startingFk;
		protected boolean movingPk;

		public RelationshipDecorationMover(Relationship r, boolean movePk) {
			this.r = r;
			this.movingPk = movePk;
			this.startingPk = new Point(r.createPkConnectionPoint().getX(), r.createPkConnectionPoint().getY());
			this.startingFk = new Point(r.createFkConnectionPoint().getX(), r.createFkConnectionPoint().getY());
			r.startedDragging();
			r.getPlayPen().addMouseMotionListenerToSchema(this);
			r.getPlayPen().addMouseListenerToSchema(this);
			r.getPlayPen().setCursor(Cursor.getPredefinedCursor(Cursor.MOVE_CURSOR));
		}

		/**
		 * Moves either the PK or FK decoration (depending on the
		 * {@link #movingPk} flag) so it is as close to the mouse
		 * pointer as possible, while still being attached to an edge
		 * of the parent (for PK) or child (for FK) table.
		 */
		public void mouseMoved(MouseEvent e) {
			Point p = new Point(e.getPoint());
			r.getPlayPen().unzoomPoint(p);
			if (movingPk) {
				r.setPkConnectionPoint(translatePoint(p));
			} else {
				r.setFkConnectionPoint(translatePoint(p));
			}
		}

		/**
		 * Forwards to {@link #mouseMoved}.
		 */
		public void mouseDragged(MouseEvent e) {
			mouseMoved(e);
		}

		/**
		 * Translates the given point from Relationship coordinates
		 * into PKTable or FKTable coordinates, with the help of the
		 * Relationship's UI delegate (which ensures the decoration
		 * still lines up with the table's edge, and that it faces the
		 * right way, and that it snaps to a straight line when
		 * close).  Whether the PK or FK table is the target depends
		 * on the state of the {@link #movingPk} property.
		 */
		protected Point translatePoint(Point p) {
			if (movingPk) {
				p.x = p.x - r.getRelationshipConnectible(true).getX();
				p.y = p.y - r.getRelationshipConnectible(true).getY();
				p = ((RelationshipUI) r.getUI()).closestEdgePoint(movingPk, p);
			} else {
				p.x = p.x - r.getRelationshipConnectible(false).getX();
				p.y = p.y - r.getRelationshipConnectible(false).getY();
				p = ((RelationshipUI) r.getUI()).closestEdgePoint(movingPk, p);
			}
			return p;
		}

		/**
		 * Cleans up this mover (it will no longer track mouse motion,
		 * and will become eligible for garbage collection unless this
		 * instance's creator saved a reference).
		 */
		public void mouseReleased(MouseEvent e) {
			r.getPlayPen().removeMouseMotionListenerFromSchema(this);
			r.getPlayPen().removeMouseListenerFromSchema(this);
			r.getPlayPen().setCursor(null);
			r.doneDragging();
		}
	}

    /**
     * Returns the colour that will be used to highlight columns participating
     * in this relationship when this relationship is selected.
     * 
     * @return
     */
	@Transient @Accessor
	public Color getColumnHighlightColour() {
        return columnHighlightColour;
    }

	// ------------------ SP listener ----------------
	public void childAdded(SPChildEvent e) {
        if (isSelected()) {
            SQLRelationship.ColumnMapping cm = (ColumnMapping) e.getChild();
            pkTable.addColumnHighlight(cm.getPkColumn(), columnHighlightColour);
            fkTable.addColumnHighlight(cm.getFkColumn(), columnHighlightColour);
        }
	}

	public void childRemoved(SPChildEvent e) {
        if (isSelected()) {
            SQLRelationship.ColumnMapping cm = (ColumnMapping) e.getChild();
            pkTable.removeColumnHighlight(cm.getPkColumn(), columnHighlightColour);
            fkTable.removeColumnHighlight(cm.getFkColumn(), columnHighlightColour);
        }
	}

	public void propertyChanged(PropertyChangeEvent e) {
		if (e.getPropertyName() != null) {
			if (e.getPropertyName().equals("name")) { //$NON-NLS-1$
				setToolTipText(model.getName());
			} else if (e.getPropertyName().equals("identifying") //$NON-NLS-1$
					   || e.getPropertyName().equals("pkCardinality") //$NON-NLS-1$
					   || e.getPropertyName().equals("fkCardinality")) { //$NON-NLS-1$
				repaint();
			}
		}
	}
	
	public void transactionStarted(TransactionEvent e) {
	    // no-op
	}
	
	public void transactionEnded(TransactionEvent e) {
	    // no-op
	}
	
	public void transactionRollback(TransactionEvent e) {
	    // no-op
	}

    /**
     * Determines if the given rectangle is visibly touching this component.
     * 
     * @param region The region to test.
     * @return Whether or not this Relationship visibly intersects the given region
     */
    public boolean intersects(Rectangle region) {
        return ((RelationshipUI) getUI()).intersects(region);
    }

    
    // ------- LayoutEdge methods --------

    @Transient @Accessor
    public LayoutNode getHeadNode() {
        return fkTable;
    }

    @Transient @Accessor
    public LayoutNode getTailNode() {
        return pkTable;
    }

    @Override @Transient @Accessor    
    public JPopupMenu getPopup(Point p) {
        // Lazy load popup if it isn't created
        // We don't create it in the constructor because the
        // ArchitectFrame instance required won't exist at that time.
        if (popup == null) {
            createPopup();
        }
        return popup;
    }
    
    @Transient @Accessor
    public boolean isStraightLine() {
        PlayPen pp = getPlayPen();
        if (pp != null) {
            ArchitectSwingSession session = pp.getSession();
            if (session != null) {
                return session.getRelationshipLinesDirect();
            }
        }
        return false;
    }

    public boolean displayRelationshipLabel() {
        PlayPen pp = getPlayPen();
        if (pp != null) {
            ArchitectSwingSession session = pp.getSession();
            if (session != null) {
                return session.isDisplayRelationshipLabel();
            }
        }
        return false;
    }

    @Override
    public void handleMouseEvent(MouseEvent evt) {
        PlayPen pp = getPlayPen();
        
        Point p = evt.getPoint();
        pp.unzoomPoint(p);
        p.translate(-getX(), -getY());
        
        if (evt.getID() == MouseEvent.MOUSE_CLICKED) {
            ArchitectSwingSession session = pp.getSession();
            if (evt.getClickCount() == 2) {
                session.getArchitectFrame().getEditRelationshipAction().actionPerformed
                (new ActionEvent(evt.getSource(),
                        ActionEvent.ACTION_PERFORMED,
                        PlayPen.ACTION_COMMAND_SRC_PLAYPEN));
            } else if (evt.getClickCount() == 1 && evt.getButton() == MouseEvent.BUTTON1 &&
                    isSelected() && componentPreviouslySelected) {
                setSelected(false, SelectionEvent.SINGLE_SELECT);
            }
            session.getArchitectFrame().getCreateIdentifyingRelationshipAction().cancel();
            session.getArchitectFrame().getCreateNonIdentifyingRelationshipAction().cancel();
        } else if (evt.getID() == MouseEvent.MOUSE_PRESSED) {
            componentPreviouslySelected = false;

            if (pp.getMouseMode() != MouseModeType.CREATING_RELATIONSHIP) {
                if ((evt.getModifiersEx() & (InputEvent.SHIFT_DOWN_MASK | InputEvent.CTRL_DOWN_MASK)) != 0) {
                    pp.setMouseMode(MouseModeType.MULTI_SELECT);
                } else {
                    pp.setMouseMode(MouseModeType.SELECT_RELATIONSHIP);
                    if (!isSelected()) {
                        pp.selectNone();
                    }
                }
            }
            
            if (isSelected()) {
                componentPreviouslySelected = true;
            } else {
                setSelected(true,SelectionEvent.SINGLE_SELECT);
            }

            // moving pk/fk decoration
            boolean overPkDec = ((RelationshipUI) getUI()).isOverPkDecoration(p);
            boolean overFkDec = ((RelationshipUI) getUI()).isOverFkDecoration(p);
            if (overPkDec || overFkDec && SwingUtilities.isLeftMouseButton(evt)) {
                new RelationshipDecorationMover(this, overPkDec);
            }
        } else if (evt.getID() == MouseEvent.MOUSE_MOVED || evt.getID() == MouseEvent.MOUSE_DRAGGED) {
            // relationship is non-rectangular so we can't use getBounds for intersection testing
            setSelected(intersects(pp.rubberBand),SelectionEvent.SINGLE_SELECT);
        }
    }

    @Transient @Mutator
    public void setTextForParentLabel(String textForParentLabel) {
        model.setTextForParentLabel(textForParentLabel);
    }

    @Transient @Accessor
    public String getTextForParentLabel() {
        return model.getTextForParentLabel();
    }

    @Transient @Mutator
    public void setTextForChildLabel(String textForChildLabel) {
        model.setTextForChildLabel(textForChildLabel);
    }

    @Transient @Accessor
    public String getTextForChildLabel() {
        return model.getTextForChildLabel();
    }

    @NonBound
    public List<? extends SPObject> getDependencies() {
        List<SPObject> dependencies = new ArrayList<SPObject>();
        dependencies.add(getModel());
        dependencies.add(getFkTable());
        dependencies.add(getPkTable());
        return dependencies;
    }

    public void removeDependency(SPObject dependency) {
        if (dependency == getModel()) {
            super.removeDependency(dependency);
        } else if (dependency == getPkTable()) {
            setPkTable(null);
        } else if (dependency == getFkTable()) {
            setFkTable(null);
        } else {
            throw new IllegalArgumentException("This Relationship is not dependant on " + dependency);
        }
    }

    @Override
    public void paint(Graphics2D g2) {
        throw new RuntimeException("RelationshipUI don't support the method paint(Graphics2D g2). To call paint(SQLSchema currentSchema, Graphics2D g2) instead.");
    }
    
    /**
     * 
     * @param currentSchema
     * @param g2
     */
    public void paint(SQLSchema currentSchema, Graphics2D g2) {
        setCurrentSchemaUnderPlayPen(currentSchema);
        ((RelationshipUI)getUI()).paint(currentSchema, g2);
        if (logger.isDebugEnabled()) {
            Color oldColor = g2.getColor();
            g2.setColor(Color.ORANGE);
            g2.drawRect(0, 0, getWidth(), getHeight());
            g2.setColor(oldColor);
        }
    }
    
    @NonProperty
    public boolean isAcrossed() {
        return this.model.isAcrossedSchema();
    }
    
    /**
     * Get the SQLSchema of SQLRelation's pkTable / fkTable.
     * @param isPk
     * @return
     */
    @NonProperty
    public SQLSchema getSchema(boolean isPk) {
        return this.model.getSchema(isPk);
    }
    
    /**
     * Whether sch is same to the schema of SQLRelation's fkTable.
     * @return
     */
    @NonProperty
    public boolean sameFkSchema(SQLSchema sch) {
        if (sch == null) return false;
        SQLSchema fkSchema = this.model.getSchema(false);
        if (fkSchema == sch) return true;
        if (fkSchema == null) {
            return sch.getName().equalsIgnoreCase(this.model.getFkSchemaName());
        }
        return false;
    }

    /**
     * Set the object instead of pkTable and fkTable to draw the line of relationship under the 
     * tab schema of playpen that fkTable/pkTable belongs to, when this relationship 
     * across two schemas.
     * @param pkAcrossedSchema      this object will display in the fkTable's tab schema of PlayPen.
     * @param fkAcrossedSchema      this object will display in the pkTable's tab schema of PlayPen.
     */
    @NonProperty
    public void setAcrossedSchema(AcrossedSchemaPane pkAcrossedSchema, 
            AcrossedSchemaPane fkAcrossedSchema) {
        if (pkAcrossedSchema == null || fkAcrossedSchema == null) {
            throw new RuntimeException("The two acrossedSchemas should be not null.");
        }
        AcrossedSchemaPane oldPk = this.pkAcrossedSchema;
        AcrossedSchemaPane oldFk = this.fkAcrossedSchema;

        disconnectAcrossedSchema();
        
        this.pkAcrossedSchema = pkAcrossedSchema;
        this.fkAcrossedSchema = fkAcrossedSchema;
        this.pkAcrossedSchema.addSPListener(aspbListener);
        this.fkAcrossedSchema.addSPListener(aspbListener);
        firePropertyChange("pkAcrossedSchema", oldPk, pkAcrossedSchema);
        firePropertyChange("fkAcrossedSchema", oldFk, fkAcrossedSchema);
    }
    
    public void clearAcrossedSchema() {
        AcrossedSchemaPane oldPk = this.pkAcrossedSchema;
        AcrossedSchemaPane oldFk = this.fkAcrossedSchema;

        disconnectAcrossedSchema();
        this.pkAcrossedSchema = null;
        this.fkAcrossedSchema = null;
        firePropertyChange("pkAcrossedSchema", oldPk, pkAcrossedSchema);
        firePropertyChange("fkAcrossedSchema", oldFk, fkAcrossedSchema);
    }

    /**
     * Unregister the Listeners for the "topLeftCorner" and "lengths" changes of AcrossedSchemaPane.
     */
    private void disconnectAcrossedSchema() {
        if (this.pkAcrossedSchema != null) {
            this.pkAcrossedSchema.removeSPListener(aspbListener);
        }
        if (this.fkAcrossedSchema != null) {
            this.fkAcrossedSchema.removeSPListener(aspbListener);
        }
    }
    
    @NonProperty
    public RelationshipConnectible getRelationshipConnectible(boolean isPk) {
        if (isPk) {
            return (usePkAcrossedSchema() ? this.pkAcrossedSchema : this.pkTable);
        }
        return (useFkAcrossedSchema() ? this.fkAcrossedSchema : this.fkTable);
    }
    
    private boolean usePkAcrossedSchema() {
        if (this.pkAcrossedSchema != null && this.isAcrossed() && !isPkSchemaOfPlayPen()) {
            return true;
        }
        return false;
    }

    private boolean useFkAcrossedSchema() {
        if (this.fkAcrossedSchema != null && this.isAcrossed() && isPkSchemaOfPlayPen()) {
            return true;
        }
        return false;
    }

    @NonProperty
    public boolean isSelfRelationship() {
        return (this.pkTable == this.fkTable);
    }
    
    @NonProperty
    private void setCurrentSchemaUnderPlayPen(SQLSchema schema) {
        this.currentSchema = schema;
    }
    
    /**
     * Returns the current orientation of this relationship for current tab schema 
     * pane of PlayPen; that is, which sides of its PK table and its FK table it is 
     * attached to. The return value is a bitmask of the constants
     * (PARENT|CHILD)_FACES_(LEFT|RIGHT|TOP|BOTTOM).
     * @return
     */
    @NonProperty
    public int getOrientation2() {
        if (isPkSchemaOfPlayPen() || !this.isAcrossed()) {
            return this.orientation;
        }
        return (this.fkAcrossedSchema != null) ? this.orientationAcrossed : this.orientation;
    }

    /**
     * Set the current orientation of this relationship for current tab schema 
     * pane of PlayPen; that is, which sides of its PK table and its FK table it is 
     * attached to. This value is a bitmask of the constants
     * (PARENT|CHILD)_FACES_(LEFT|RIGHT|TOP|BOTTOM).
     * @param orientation
     */
    @NonProperty
    public void setOrientation2(int orientation) {
        if (isPkSchemaOfPlayPen() || !this.isAcrossed()) {
            this.setOrientation(orientation);
            return;
        }
        if (this.fkAcrossedSchema != null) {
            this.setOrientationAcrossed(orientation);
            return;
        }
    }
    
    private boolean isRelatedRelationshipConnectible(RelationshipConnectible rc) {
        if (rc == null) return false;
        if (rc ==pkTable || rc == fkTable) return true;
        if (rc == pkAcrossedSchema || rc == fkAcrossedSchema) {
            return true;
        }
        return false;
    }

    private boolean isPkSchemaOfPlayPen() {
        logger.debug("currentSchema=" + this.currentSchema + "; pkSchema=" + this.model.getSchema(true) + 
                "; fkSchema=" + this.model.getSchema(false) + "; isPkSchemaOfPlayPen=" + 
                (this.currentSchema == this.model.getSchema(true)) + "; isAcrossed=" + isAcrossed() + 
                "; pkAcrossedSchema=" + pkAcrossedSchema + "; fkAcrossedSchema=" + fkAcrossedSchema);
        return (this.currentSchema == this.model.getSchema(true));
    }
    
    @Transient @Accessor
    public int getOrientationAcrossed() {
        return orientationAcrossed;
    }

    @Transient @Mutator
    public void setOrientationAcrossed(int orientationAcrossed) {
        int oldValue = this.orientationAcrossed;
        if (oldValue == orientationAcrossed) return;
        this.orientationAcrossed = orientationAcrossed;
        firePropertyChange("orientationAcrossed", oldValue, orientationAcrossed);
    }
    
    public Color getHighlightColor() {
        return (this.selected ? this.columnHighlightColour : null);
    }

    @Transient @Accessor
    public AcrossedSchemaPane getPkAcrossedSchema() {
        return pkAcrossedSchema;
    }

    @Transient @Mutator
    public void setPkAcrossedSchema(AcrossedSchemaPane pkAcrossedSchema) {
        this.pkAcrossedSchema = pkAcrossedSchema;
    }

    @Transient @Accessor
    public AcrossedSchemaPane getFkAcrossedSchema() {
        return fkAcrossedSchema;
    }

    @Transient @Mutator
    public void setFkAcrossedSchema(AcrossedSchemaPane fkAcrossedSchema) {
        this.fkAcrossedSchema = fkAcrossedSchema;
    }
    
}
