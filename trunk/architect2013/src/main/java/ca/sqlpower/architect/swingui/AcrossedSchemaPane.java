package ca.sqlpower.architect.swingui;

import java.awt.Dimension;
import java.awt.Insets;
import java.awt.Point;
import java.awt.datatransfer.Transferable;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.log4j.Logger;

import ca.sqlpower.architect.layout.LayoutEdge;
import ca.sqlpower.object.AbstractSPListener;
import ca.sqlpower.object.ObjectDependentException;
import ca.sqlpower.object.SPChildEvent;
import ca.sqlpower.object.SPObject;
import ca.sqlpower.object.annotation.Constructor;
import ca.sqlpower.object.annotation.ConstructorParameter;
import ca.sqlpower.object.annotation.NonProperty;
import ca.sqlpower.sqlobject.SQLSchema;
import ca.sqlpower.swingui.dbtree.DBTreeNodeRender.RenderType;
import ca.sqlpower.swingui.dbtree.DBTreeNodeRenderUtils;
import ca.sqlpower.util.SQLPowerUtils;

/**
 * A containerPane for another schema that display in current schema pane.
 * 
 * @author jianjun.tan
 *
 */
public class AcrossedSchemaPane extends ContainerPane<SQLSchema, ItemOfAcrossedSchemaPane> implements RelationshipConnectible {

    private static Logger logger = Logger.getLogger(AcrossedSchemaPane.class);
    
    private SQLSchema acrossedSchema;

    private List<ItemOfAcrossedSchemaPane> relationshipsAcrossedSchema = new ArrayList<ItemOfAcrossedSchemaPane>();

    /**
     * Defines an absolute ordering of the child types of this class.
     * 
     * IMPORTANT!: When changing this, ensure you maintain the order specified by {@link #getChildren()}
     */
    public static final List<Class<? extends SPObject>> allowedChildTypes = 
            Collections.<Class<? extends SPObject>>singletonList(ItemOfAcrossedSchemaPane.class);

    private final AbstractSPListener acrossedSchemaNameListener = new AbstractSPListener() {
        @Override
        public void propertyChanged(PropertyChangeEvent evt) {
            if ("name".equals(evt.getPropertyName())) {
                AcrossedSchemaPane asp = AcrossedSchemaPane.this;
                if (asp.acrossedSchema != evt.getSource()) return;
                if (logger.isDebugEnabled()) {
                    logger.debug("AcrossedSchemaPane got schema name changed event." + //$NON-NLS-1$
                            "  Source="+evt.getSource()+" Property="+evt.getPropertyName()+ //$NON-NLS-1$ //$NON-NLS-2$
                            " oldVal="+evt.getOldValue()+" newVal="+evt.getNewValue());  //$NON-NLS-1$ //$NON-NLS-2$
                }
                asp.setLengths(asp.getUI().getPreferredSize());
            }
        }
    };

    private final AbstractSPListener schemaListener = new AbstractSPListener() {
        @Override
        public void propertyChanged(PropertyChangeEvent evt) {
            if (logger.isDebugEnabled()) {
                logger.debug("AcrossedSchemaPane got object changed event." + //$NON-NLS-1$
                        "  Source="+evt.getSource()+" Property="+evt.getPropertyName()+ //$NON-NLS-1$ //$NON-NLS-2$
                        " oldVal="+evt.getOldValue()+" newVal="+evt.getNewValue());  //$NON-NLS-1$ //$NON-NLS-2$
            }
            if (!"parent".equals(evt.getPropertyName())) {
                firePropertyChange("model."+evt.getPropertyName(), evt.getOldValue(), evt.getNewValue()); //$NON-NLS-1$
            }
        }
    };
    
    private final AbstractSPListener containerPaneListener = new AbstractSPListener() {
        public void childRemoved(SPChildEvent e) {
            if (e.getChild() == AcrossedSchemaPane.this) {
                destroy();
            }
        }
    };
    
    private final ActionEvent mouseActionEvent = new ActionEvent(
             this, ActionEvent.ACTION_PERFORMED,
             PlayPen.ACTION_COMMAND_SRC_PLAYPEN);

    public SQLSchema getAcrossedSchema() {
        return acrossedSchema;
    }

    public AcrossedSchemaPane(AcrossedSchemaPane as, PlayPenContentPane parent) {
        super(as.getName(), parent);
        // "model" is the model of the current schema pane of PlayPen.
        this.model = as.model;
        this.acrossedSchema = as.acrossedSchema;
        this.margin = (Insets) as.margin.clone();
        updateUI();
    }
    
    @Constructor
    /**
     * Create a AcrossedSchemaPane object that is related the acrossed schema, and it
     * will display in the Playpen's schemaPane related sch.
     * @param sch   this AcrossedSchemaPane object will display in the Playpen's
     *                          schemaPane related sch.
     * @param acrossedSch   acrossed schema.
     * @param parent
     */
    public AcrossedSchemaPane(@ConstructorParameter(propertyName="model") SQLSchema sch, 
            @ConstructorParameter(propertyName="acrossedSchema") SQLSchema acrossedSch, 
            @ConstructorParameter(propertyName="parent") PlayPenContentPane parent) {
        super(sch.getName() + "." + acrossedSch.getName(), parent);
        this.model = sch;
        this.acrossedSchema = acrossedSch;
        updateUI();
    }
    
    public void connect() {
        destroy();
        
        SQLPowerUtils.listenToHierarchy(model, schemaListener);
        getParent().addSPListener(containerPaneListener);
        acrossedSchema.addSPListener(acrossedSchemaNameListener);
    }

    private void destroy() {
        SQLPowerUtils.unlistenToHierarchy(model, schemaListener);
        getParent().removeSPListener(containerPaneListener);
        acrossedSchema.removeSPListener(acrossedSchemaNameListener);
    }
    
    @Override
    public List<LayoutEdge> getOutboundEdges() {
        return null;
    }

    @Override
    public List<LayoutEdge> getInboundEdges() {
        return null;
    }

    @Override
    protected List<ItemOfAcrossedSchemaPane> getItems() {
        return getList();
    }

    @Override
    public int pointToItemIndex(Point p) {
        return ((AcrossedSchemaPaneUI) getUI()).pointToItemIndex(p);
    }

    /**
     * Nothing to be Transferable.
     */
    @Override
    public Transferable createTransferableForSelection() {
        return null;
    }

    /**
     * Nothing to paste.
     */
    @Override
    public void pasteData(Transferable t) {}

    @Override
    public String getModelName() {
        return model.getName();
    }

    public void updateUI() {
        AcrossedSchemaPaneUI ui = (AcrossedSchemaPaneUI) AcrossedSchemaPaneUI.createUI(this);
        ui.installUI(this);
        setUI(ui);
        this.setMinimumSize(new Dimension(100,Math.max(60, ui.getIconHeight())));
        updateLengths(false);
    }
    
    @Override
    public void handleMouseEvent(MouseEvent evt) {
        super.handleMouseEvent(evt);
        
        PlayPen pp = getPlayPen();

        Point p = evt.getPoint();
        pp.unzoomPoint(p);
        p.translate(-getX(), -getY());
        if (evt.getID() == MouseEvent.MOUSE_CLICKED) {
            logger.debug("handleMouseEvent --- MOUSE_CLICKED!");
            if ((evt.getModifiers() & MouseEvent.BUTTON1_MASK) != 0) {
                if (evt.getClickCount() == 2) { // double click
                    logger.debug("handleMouseEvent --- Double MOUSE_CLICKED!");
                    if (isSelected()) {
                        ArchitectFrame af = pp.getSession().getArchitectFrame();
                        af.getEditPlayPenSchemaAction().actionPerformed(mouseActionEvent);
                    }
                }
            }
        }
    }
    
    public void addAcrossedSchemaRelationship(Relationship r, boolean insteadPkTable) {
        // Ignore this add operation generated by Relationship when to undo or to re-do.
        if (!r.isMagicEnabled()) return;

        ItemOfAcrossedSchemaPane addedItem = findItemByRelationship(r);
        if (addedItem != null) return;
        
        addedItem = new ItemOfAcrossedSchemaPane(r, insteadPkTable);
        try {
            this.addChild(addedItem);
        } catch (IllegalArgumentException e) {
            logger.error("An error is found when add an item for AcrossedSchemaPane:" + e.toString());
        }
    }
    
    public void removeAcrossedSchemaRelationship(Relationship r) {
        // Ignore this remove operation when to undo or to re-do.
        if (!r.isMagicEnabled()) return;
        
        ItemOfAcrossedSchemaPane child = findItemByRelationship(r);
        if (child == null) return;
        try {
            this.removeChild(child);
        } catch (IllegalArgumentException e) {
            logger.error("An error is found when remove an item from AcrossedSchemaPane:" + e.toString());
        } catch (ObjectDependentException e) {
            logger.error("An error is found when remove an item from AcrossedSchemaPane:" + e.toString());
        }
    }
    
    private ItemOfAcrossedSchemaPane findItemByRelationship(Relationship r) {
        for (ItemOfAcrossedSchemaPane item : getList()) {
            if (item.sameRelationship(r)) {
                return item;
            }
        }
        return null;
    }

    @NonProperty
    public RenderType getRenderType() {
        PlayPen pp = getPlayPen();
        if (pp != null) {
            ArchitectSwingSession session = pp.getSession();
            if (session != null) {
                return DBTreeNodeRenderUtils.getRenderType(session.isUsingLogicalNames());
            }
        }
        return DBTreeNodeRenderUtils.getRenderType(true);
    }
    
    @Override
    public List<Class<? extends SPObject>> getAllowedChildTypes() {
        return allowedChildTypes;
    }

    @Override
    public List<? extends SPObject> getChildren() {
        return getList();
    }

    @Override
    public List<? extends SPObject> getDependencies() {
        return Collections.emptyList();
    }

    @Override
    public void removeDependency(SPObject dependency) {
        return;
    }

    private synchronized List<ItemOfAcrossedSchemaPane> getList() {
        return Collections.unmodifiableList(this.relationshipsAcrossedSchema);
    }
    
    @Override
    protected void addChildImpl(SPObject child, int index) {
        if (child instanceof ItemOfAcrossedSchemaPane) {
            if (logger.isDebugEnabled()) {
                logger.debug(child + " for Pk/Fk Table inserted into Acrossed-Schema Pane (" + this +")."); //$NON-NLS-1$ //$NON-NLS-2$
            }
            synchronized(this.relationshipsAcrossedSchema) {
                this.relationshipsAcrossedSchema.add((ItemOfAcrossedSchemaPane)child);
            }
            this.setLengths(((AcrossedSchemaPaneUI) this.getUI()).getPreferredSize());
            fireChildAdded(ItemOfAcrossedSchemaPane.class, child, index);
        }
    }
    
    @Override
    public boolean removeChildImpl(SPObject child) {
        if (child instanceof ItemOfAcrossedSchemaPane) {
            ItemOfAcrossedSchemaPane removedItem = (ItemOfAcrossedSchemaPane)child;
            if (logger.isDebugEnabled()) {
                logger.debug(removedItem + " for Pk/Fk Table removed from Acrossed-Schema Pane (" + this +")."); //$NON-NLS-1$ //$NON-NLS-2$
            }
            boolean removed;
            int index;
            synchronized(this.relationshipsAcrossedSchema) {
                index = this.relationshipsAcrossedSchema.indexOf(removedItem);
                removed = this.relationshipsAcrossedSchema.remove(removedItem);
            }
            if (removed) {
                this.setLengths(((AcrossedSchemaPaneUI) this.getUI()).getPreferredSize());
                fireChildRemoved(ItemOfAcrossedSchemaPane.class, removedItem, index);
                return true;
            }
        }
       return false;
    }
    
    @Override
    public String toString() {
        return "AcrossedSchemaPane : " + this.getName() + "(Acrossed Schema)";
    }

}
