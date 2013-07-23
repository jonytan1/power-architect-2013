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

/**
 * This class is used to get the information about current project( or we can say current window ).
 * Example in {@link ca.sqlpower.architect.swingui.DBTree.DBTree}:
 * <code>
 * 		... ...
 * 		ArchitectWindow window = new ArchitectWindow(
 * 			public boolean isUsingLogicalNames(){
 * 				return this.session.isUsingLogicalNames();
 * 			});
 * 		treeCellRenderer = new DBTreeCellRenderer(window);
 * 		... ...
 * </code>
 * 
 * Since 1.0.7, we just get the info of "isUsingLogicalNames" from this object, 
 * not to get the session object,
 * when we display logical/physical name.
 * 
 * @author jianjun.tan
 *
 */
public class ArchitectWindow {

	/**
	 * Default is false, that mean to display physical name.
	 * @return
	 */
	public boolean isUsingLogicalNames(){ return false; }
}
