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

import java.util.Comparator;

import ca.sqlpower.sqlobject.SQLObject;

/**
 * The interface for sort comparator of {@link #SQLObject}.
 * 
 * @author jianjun.tan
 *
 */
public interface SQLObjectSortComparator<E extends SQLObject> extends Comparator<E> {
	/**
	 * Define the type of sort comparator for SQLObject.
	 *
	 */
	public enum Type{ 
		/**
		 * Sorted by sequence, that means the first is inserted firstly, 
		 * and  the last is inserted lastly.
		 */
		BySequence, 
		/**
		 * Sorted by physical name.
		 */
		ByPhysicalName, 
		/**
		 * Sorted by logical name.
		 */
		ByLogicalName };
	/**
	 * Check whether this is a defined type of {@link #SQLObjectSortComparator}.
	 * @param type
	 * @return
	 */
	public boolean isComparator( SQLObjectSortComparator.Type type );
	
	/**
	 * Compare the two SQLObject.
	 * Return value is less than 0, that means o1 is before o2;
	 * Return value is greater than 0, that means o1 is after o2;
	 */
	@Override
	public int compare(E o1, E o2);
}
