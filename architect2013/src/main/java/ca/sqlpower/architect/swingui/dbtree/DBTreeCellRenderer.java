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

package ca.sqlpower.architect.swingui.dbtree;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.sql.DatabaseMetaData;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JTree;
import javax.swing.tree.DefaultTreeCellRenderer;

import org.apache.log4j.Logger;

import ca.sqlpower.architect.ArchitectSessionBridge;
import ca.sqlpower.architect.swingui.SQLTypeTreeCellRenderer;
import ca.sqlpower.object.SPObject;
import ca.sqlpower.sqlobject.SQLCatalog;
import ca.sqlpower.sqlobject.SQLColumn;
import ca.sqlpower.sqlobject.SQLDatabase;
import ca.sqlpower.sqlobject.SQLIndex;
import ca.sqlpower.sqlobject.SQLObject;
import ca.sqlpower.sqlobject.SQLRelationship;
import ca.sqlpower.sqlobject.SQLSchema;
import ca.sqlpower.sqlobject.SQLTable;
import ca.sqlpower.sqlobject.UserDefinedSQLTypeSnapshot;
import ca.sqlpower.sqlobject.SQLIndex.Column;
import ca.sqlpower.sqlobject.SQLRelationship.SQLImportedKey;
import ca.sqlpower.swingui.ComposedIcon;
import ca.sqlpower.swingui.dbtree.DBTreeNodeRender;

/**
 * The DBTreeCellRenderer renders nodes of a JTree which are of
 * type SQLObject.  This class is much older than November 2006; it
 * was pulled out of the DBTree.java compilation unit into its own
 * file on this date so it could be used more naturally as the cell
 * renderer for a different JTree.
 *
 * @author fuerth
 * @version $Id$
 */
public class DBTreeCellRenderer extends DefaultTreeCellRenderer {
    
    private static final Logger logger = Logger.getLogger(DBTreeCellRenderer.class);
    
    public static final ImageIcon DB_ICON = new ImageIcon(DBTreeCellRenderer.class.getResource("icons/Database16.png"));
	public static final ImageIcon TARGET_DB_ICON = new ImageIcon(DBTreeCellRenderer.class.getResource("icons/Database_target16.png"));
	public static final ImageIcon CATALOG_ICON = new ImageIcon(DBTreeCellRenderer.class.getResource("icons/Catalog16.png"));
	public static final ImageIcon SCHEMA_ICON = new ImageIcon(DBTreeCellRenderer.class.getResource("icons/Schema16.png"));
	public static final ImageIcon TABLE_ICON = new ImageIcon(DBTreeCellRenderer.class.getResource("icons/Table16.png"));
	public static final ImageIcon EXPORTED_KEY_ICON = new ImageIcon(DBTreeCellRenderer.class.getResource("icons/ExportedKey16.png"));
    public static final ImageIcon IMPORTED_KEY_ICON = new ImageIcon(DBTreeCellRenderer.class.getResource("icons/ImportedKey16.png"));
	public static final ImageIcon OWNER_ICON = new ImageIcon(DBTreeCellRenderer.class.getResource("icons/Owner16.png"));
    public static final ImageIcon INDEX_ICON = new ImageIcon(DBTreeCellRenderer.class.getResource("icons/Index16.png"));
    public static final ImageIcon PK_ICON = new ImageIcon(DBTreeCellRenderer.class.getResource("icons/Index_key16.png"));
    public static final ImageIcon UNIQUE_INDEX_ICON = new ImageIcon(DBTreeCellRenderer.class.getResource("icons/Index_unique16.png"));
    public static final ImageIcon COLUMN_ICON = new ImageIcon(DBTreeCellRenderer.class.getResource("icons/Column16.png"));
    public static final ImageIcon ERROR_BADGE = new ImageIcon(DBTreeCellRenderer.class.getResource("/icons/parts/noAccess.png"));
    public static final ImageIcon REFRESH_ICON = new ImageIcon(DBTreeCellRenderer.class.getResource("/icons/arrow_refresh16.png"));
   
    private final List<IconFilter> iconFilterChain = new ArrayList<IconFilter>();
    
    private ArchitectSessionBridge bridge;
    
    public DBTreeCellRenderer(ArchitectSessionBridge bridge) {
        super();
        this.bridge = bridge;
    }

	/*public DBTreeCellRenderer() {
        this(new ArchitectSessionBridge());
    }*/

    public Component getTreeCellRendererComponent(JTree tree,
												  Object value,
												  boolean sel,
												  boolean expanded,
												  boolean leaf,
												  int row,
												  boolean hasFocus) {
		if ( value != null && value instanceof DBTreeNodeRender){
			setText(((DBTreeNodeRender) value).getNodeTitle(this.bridge.getRenderType()));
		} else {
			setText(value == null ? "null" : value.toString());
		}
	    setToolTipText(getText());
	    
        if (value instanceof SQLDatabase) {
			SQLDatabase db = (SQLDatabase) value;
			if (db.isPlayPenDatabase()) {
				setIcon(TARGET_DB_ICON);
			} else {
				setIcon(DB_ICON);
			}
		} else if (value instanceof SQLCatalog) {
			if (((SQLCatalog) value).getNativeTerm().equals("owner")) { //$NON-NLS-1$
				setIcon(OWNER_ICON);
			} else if (((SQLCatalog) value).getNativeTerm().equals("database")) { //$NON-NLS-1$
				setIcon(DB_ICON);
			} else if (((SQLCatalog) value).getNativeTerm().equals("schema")) { //$NON-NLS-1$
				setIcon(SCHEMA_ICON);
			} else {
				setIcon(CATALOG_ICON);
			}
		} else if (value instanceof SQLSchema) {
			if (((SQLSchema) value).getNativeTerm().equals("owner")) { //$NON-NLS-1$
				setIcon(OWNER_ICON);
			} else {
				setIcon(SCHEMA_ICON);
			}
		} else if (value instanceof SQLTable) {
		    setIcon(TABLE_ICON);
		} else if (value instanceof SQLRelationship) {
		    setIcon(EXPORTED_KEY_ICON);
		} else if (value instanceof SQLImportedKey) {
		    setIcon(IMPORTED_KEY_ICON);
		} else if (value instanceof SQLIndex) {
            SQLIndex i = (SQLIndex) value;
            if (i.isPrimaryKeyIndex()) {
                setIcon(PK_ICON);
            } else if (i.isUnique()) {
                setIcon(UNIQUE_INDEX_ICON);
            } else {
                setIcon(INDEX_ICON);
            }
        } else if (value instanceof SQLColumn) {
            tagColumn((SQLColumn)value);
            setIcon(COLUMN_ICON);
        } else if (value instanceof Column) {
            Column col = (Column) value;
            logger.debug("Column has properties " + col);
            if (col.getColumn() != null) {
                tagColumn((col).getColumn());
            }
            setIcon(COLUMN_ICON);
        } else if (value instanceof UserDefinedSQLTypeSnapshot) {
            UserDefinedSQLTypeSnapshot snapshot = (UserDefinedSQLTypeSnapshot) value;
            setText(snapshot.getSPObject().getName());
            if (!((UserDefinedSQLTypeSnapshot) value).isDomainSnapshot()) {
                setIcon(SQLTypeTreeCellRenderer.TYPE_ICON);
            } else {
                setIcon(SQLTypeTreeCellRenderer.DOMAIN_ICON);
            }
            if (snapshot.isDeleted()) {
                setIcon(ComposedIcon.getInstance(getIcon(), 
                        ERROR_BADGE));
            } else if (snapshot.isObsolete()) {
                final BufferedImage bufferedImage = 
                    new BufferedImage(16, 16, BufferedImage.TYPE_INT_ARGB);
                
                //TODO this should be done statically
                Graphics2D g = bufferedImage.createGraphics();
                g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, 
                        RenderingHints.VALUE_INTERPOLATION_BILINEAR);
                g.drawImage(REFRESH_ICON.getImage(), 8, 8, 8, 8, new Color(0x00ffffff, true), null);
                g.dispose();
                
                setIcon(ComposedIcon.getInstance(getIcon(), 
                        new ImageIcon(bufferedImage)));
            }
        } else if (tree.getModel() instanceof DBTreeModel && 
                value == ((DBTreeModel) tree.getModel()).getSnapshotContainer()) {
            setText("Types");
            setIcon(null);
        } else {
			setIcon(null);
		}
        
        if (value instanceof SQLObject && !((SQLObject) value).getChildrenInaccessibleReasons().isEmpty()) {
            logger.debug("Children are not accessible from the node " + ((SQLObject) value).getName());
            if (getIcon() == null) {
                setIcon(ERROR_BADGE);
            } else {
                setIcon(ComposedIcon.getInstance(getIcon(), ERROR_BADGE));
            }
            setToolTipText("Inaccessible: " + ((SQLObject) value).getChildrenInaccessibleReasons());
        }

		this.selected = sel;
		this.hasFocus = hasFocus;

        if (sel) {
            setForeground(getTextSelectionColor());
        } else {
            if (value instanceof SQLObject) {
                if (((SQLObject) value).isPopulated()) {
                    setForeground(getTextNonSelectionColor());
                } else {
                    setForeground(Color.LIGHT_GRAY);
                }
            } else {
                setForeground(getTextNonSelectionColor());
            }
        }
	    
	    if (value instanceof SPObject || value == null) {
	        for (IconFilter filter : getIconFilterChain()) {
	            setIcon(filter.filterIcon(getIcon(), (SPObject) value));
	        }
	    }
	    
		return this;
	}
    
     /**
     * Determines what tag to append to the given column
     */
    private void tagColumn(SQLColumn col) {
        StringBuffer tag = new StringBuffer();
        StringBuffer fullTag = new StringBuffer();
        boolean isPK = col.isPrimaryKey();
        boolean isFK = col.isForeignKey();
        boolean isAK = col.isUniqueIndexed() && !isPK;
        boolean emptyTag = true;
        if (isPK) {
            tag.append("P"); //$NON-NLS-1$
            emptyTag = false;
        } 
        if (isFK) {
            tag.append("F"); //$NON-NLS-1$
            emptyTag = false;
        }
        if (isAK) {
            tag.append("A"); //$NON-NLS-1$
            emptyTag = false;
        }
        
        if (!emptyTag) {
            tag.append("K"); //$NON-NLS-1$
            fullTag.append("  [ "); //$NON-NLS-1$
            fullTag.append(tag);
            fullTag.append(" ]"); //$NON-NLS-1$
            setText(getText() + fullTag.toString());
        }
        if (col.getNullable() == DatabaseMetaData.columnNoNulls) setText(getText() + " [ M ]");
    }

    /**
     * Adds the given icon filter to the end of the filter chain. The filter
     * will be invoked after all currently existing filters on this renderer.
     * 
     * @param filter
     *            The filter to add. Must not be null.
     */
    public void addIconFilter(IconFilter filter) {
        if (filter == null) {
            throw new NullPointerException("Null icon filters not allowed");
        }
        iconFilterChain.add(filter);
    }

    /**
     * Removed the given icon filter chain from this renderer's filter chain. If
     * the given filter is not in the list, calling this method has no effect.
     * 
     * @param filter
     *            The filter to remove
     * @return True if the filter was in the list (so it has been removed);
     *         false if the filter was not in the list (so the list remains
     *         unchanged).
     */
    public boolean removeIconFilter(IconFilter filter) {
        return iconFilterChain.remove(filter);
    }
    
    /**
     * Returns a read-only view of this renderer's filter chain. The filters
     * are invoked in the order that they exist in this list.
     */
    public List<IconFilter> getIconFilterChain() {
        return Collections.unmodifiableList(iconFilterChain);
    }
}