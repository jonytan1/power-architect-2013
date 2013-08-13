/*
 * Copyright (c) 2008, SQL Power Group Inc.
 *
 * This file is part of SQL Power Library.
 *
 * SQL Power Library is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 3 of the License, or
 * (at your option) any later version.
 *
 * SQL Power Library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>. 
 */
package ca.sqlpower.swingui.dbtree;

import ca.sqlpower.object.annotation.NonProperty;

/**
 * Get the render content for the tree node, 
 * when the table/column object etc changed or render condition changed.
 * 
 * @author jianjun.tan
 *
 */
public interface DBTreeNodeRender {

	public static enum RenderType{
		/**
		 * Display the name of a SQLObject.
		 */
		LogicalName,
		/**
		 * Display the PhysicalName of a SQLObject.
		 */
		PhysicalName
	}
	
	/**
	 * Get the render content of a SQLObject to display on the node of DBTree according to renderType.
	 * @param type
	 * @return
	 */
	@NonProperty
	public String getNodeTitle(RenderType type); 
}
