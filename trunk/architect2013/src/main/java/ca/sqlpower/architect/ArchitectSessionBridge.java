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

package ca.sqlpower.architect;

import ca.sqlpower.swingui.dbtree.DBTreeNodeRenderUtils;
import ca.sqlpower.swingui.dbtree.DBTreeNodeRender.RenderType;

/**
 * This class is the bridge between {@link ca.sqlpower.architect.swingui.dbtree.DBTreeCellRenderer} and 
 * {@link ca.sqlpower.architect.swingui.ArchitectSwingSession}. By it, {@link ca.sqlpower.architect.swingui.dbtree.DBTreeCellRenderer}
 * can get some information from the session object of current project.
 * Example in {@link ca.sqlpower.architect.swingui.DBTree.DBTree}:
 * <code>
 * 		... ...
 * 		ArchitectSessionBridge bridge = new ArchitectSessionBridge(){
 * 			public RenderType getRenderType(){
 *             return DBTreeNodeRenderUtils.getRenderType(session.isUsingLogicalNames());
 * 			}
 *     };
 * 		treeCellRenderer = new DBTreeCellRenderer(bridge);
 * 		... ...
 * </code>
 * 
 * Since 1.0.7, we just get the info of "isUsingLogicalNames" from this object, 
 * not to get the session object, and transform it to 
 * {@link ca.sqlpower.swingui.dbtree.DBTreeNodeRender.RenderType}.
 * So we can display title of the DBTree node according to the 
 * "isUsingLogicalNames" of the session object.
 * 
 * @author jianjun.tan
 *
 */
public class ArchitectSessionBridge {

	/**
	 * Default is PhysicalName, that mean to display physical name.
	 * @return
	 */
	public RenderType getRenderType(){
		return RenderType.PhysicalName;
	}
}
