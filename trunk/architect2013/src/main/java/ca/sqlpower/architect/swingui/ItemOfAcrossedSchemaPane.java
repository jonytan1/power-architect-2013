package ca.sqlpower.architect.swingui;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import ca.sqlpower.object.AbstractSPObject;
import ca.sqlpower.object.SPObject;
import ca.sqlpower.sqlobject.SQLColumn;
import ca.sqlpower.sqlobject.SQLRelationship.ColumnMapping;
import ca.sqlpower.sqlobject.SQLTable;
import ca.sqlpower.swingui.dbtree.DBTreeNodeRender.RenderType;

/**
 * The Container to include the across-schema pkTable 
 * or fkTable of one relationship.
 * 
 * @author jianjun.tan
 *
 */
public class ItemOfAcrossedSchemaPane extends AbstractSPObject{

    public static final List<Class<? extends SPObject>> allowedChildTypes = Collections.emptyList();
    
    private Relationship relationship;
    /**
     * Whether to display pkTable info in AcrossedSchemaPane, or fkTable info.
     */
    private boolean insteadPkTable;
    /**
     * the width of table title that display in AcrossedSchemaPane.
     * And these space will be remain since the second column in relationship.
     */
    private int tableSpace=0;
    
    public ItemOfAcrossedSchemaPane() {
        this(null, true);
    }
    
    public ItemOfAcrossedSchemaPane(Relationship relationship, boolean insteadPkTable) {
        this.relationship = relationship;
        this.insteadPkTable = insteadPkTable;
        this.setName(relationship.getModelName() + "_" + getInsteadTable());
    }
    
    /**
     * Whether r is the relationship that this ItemOfAcrossedSchemaPane refers .
     * @param r
     * @return
     */
    public boolean sameRelationship(Relationship r) {
        return (this.relationship == r);
    }
    
    /**
     * Get the title list of the table's (pkTable/fkTable) columns in relationship's ColumnMapping.
     * When insteadPkTable is true, this table means pkTable, otherwise fkTable.  
     * @param type the column's title will render by it.
     * @return
     */
    public List<String> getColumnsList(RenderType type) {
        List<String> list = new ArrayList<String>();
        if (this.relationship == null) return list;
        for (ColumnMapping cm : this.relationship.getModel().getChildren(ColumnMapping.class)) {
            SQLColumn col = (this.insteadPkTable ? cm.getPkColumn() : cm.getFkColumn());
            list.add(col.getTitleByRenderType(type));
        }
        return list;
    }

    public String getTableTitle(RenderType type) {
        if (this.relationship == null) return "No related relationship";
        SQLTable t = (this.insteadPkTable ? relationship.getPkTable().getModel() : relationship.getFkTable().getModel());
        return t.getTitleByRenderType(type);
    }

    public int getTableSpace() {
        return tableSpace;
    }

    public void setTableSpace(int tableSpace) {
        this.tableSpace = tableSpace;
    }
    
    public Color getRelationshipHighlight() {
        return (this.relationship == null ? null : this.relationship.getHighlightColor());
    }

    @Override
    public List<Class<? extends SPObject>> getAllowedChildTypes() {
        return allowedChildTypes;
    }

    @Override
    public List<? extends SPObject> getChildren() {
        return Collections.emptyList();
    }

    @Override
    public List<? extends SPObject> getDependencies() {
        return Collections.emptyList();
    }

    @Override
    public void removeDependency(SPObject dependency) {
        return;
    }

    @Override
    protected boolean removeChildImpl(SPObject child) {
        return false;
    }
    
    private String getInsteadTable() {
        return (this.insteadPkTable ? "PkTable" : "FkTable");
    }
    
    @Override
    public String toString() {
        return "ItemOfAcrossedSchemaPane[Instead " + getInsteadTable() + " for (" + this.relationship + ")]";
    }
}
