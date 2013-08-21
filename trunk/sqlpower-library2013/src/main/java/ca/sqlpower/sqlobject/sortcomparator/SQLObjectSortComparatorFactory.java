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
package ca.sqlpower.sqlobject.sortcomparator;

import ca.sqlpower.sqlobject.SQLObject;

/**
 * The factory to create the {@link #SQLObjectSortComparator}.
 * 
 * @author jianjun.tan
 *
 */
public class SQLObjectSortComparatorFactory<E extends SQLObject> {
	public SQLObjectSortComparatorFactory(){}
	
	/**
	 * Create the defined type of {@link #SQLObjectSortComparator}.
	 * Default is {@link SQLObjectSortComparator.Type.BySequence}.
	 * @param type
	 * @return
	 */
	public SQLObjectSortComparator<E> createSortComparator( SQLObjectSortComparator.Type type ){
		if (type == SQLObjectSortComparator.Type.ByLogicalName) {
			return new LogicalNameSortComparator<E>();
		} else if (type == SQLObjectSortComparator.Type.ByPhysicalName) {
			return new PhysicalNameSortComparator<E>();
		}
		return new SequenceSortComparator<E>();
	}
}
