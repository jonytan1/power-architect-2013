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
package ca.sqlpower.sqlobject.comparator;

import java.io.Serializable;
import java.util.Locale;

import ca.sqlpower.sqlobject.SQLObject;

/**
 * 
 * @author jianjun.tan
 *
 */
public class SQLObjectLogicalNameComparator<E extends SQLObject> implements SQLObjectComparator<E>, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5348517331522189770L;
	
	public SQLObjectLogicalNameComparator() {}

	@Override
	public int compare(E o1, E o2) {
		if ( o1 == o2 ) return 0;
		else if ( o1 == null ) return -1;
		else if ( o2 == null ) return 1;
		else {
			String s1 = o1.getLogicalName();
			String s2 = o2.getLogicalName();
			s1 = ( s1 == null ? "" : s1.trim().toLowerCase(Locale.getDefault()) );
			s2 = ( s2 == null ? "" : s2.trim().toLowerCase(Locale.getDefault()) );
			if ( s1.equalsIgnoreCase( s2 ) ) return 0;
			else if ( s1.isEmpty() ) return -1;
			else if ( s2.isEmpty() ) return 1;
			else return s1.compareTo(s2);
		}
	}

	@Override
	public boolean isComparator(SQLObjectComparator.Type type) {
		return type==SQLObjectComparator.Type.ByLogicalName;
	}
}