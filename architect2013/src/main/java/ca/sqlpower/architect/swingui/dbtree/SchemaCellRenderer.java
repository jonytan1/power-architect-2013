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

import java.awt.Component;

import javax.swing.DefaultListCellRenderer;
import javax.swing.JList;

import ca.sqlpower.sqlobject.SQLSchema;

/**
 * Render a SQLSchema object in DBTree.
 * @version 1.0.8
 * @since 2013/07
 * @author jianjun.tan
 *
 */
public class SchemaCellRenderer extends DefaultListCellRenderer {

	private final String nullRenderer;
	/**
	 * 
	 */
	private static final long serialVersionUID = 3509149214828372366L;

	public SchemaCellRenderer( String nullRenderer ){
		this.nullRenderer = nullRenderer;
	}
	
    @Override
    public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected,
            boolean cellHasFocus) {
    	if ( value != null && value instanceof String ) 
    		return super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
    	SQLSchema schema = ( SQLSchema ) value; 
    	return super.getListCellRendererComponent(list, ( schema == null ? nullRenderer : schema.getPhysicalName() ), index, isSelected, cellHasFocus);
    }
	
}
