package ca.sqlpower.sqlobject.comparator;

import java.util.List;

/**
 * 
 * @author jianjun.tan
 *
 * @param <E>
 */
public interface SortedList<E> extends List<E> {

	public void setSortComparator( SQLObjectComparator.Type type );
	public boolean isComparator( SQLObjectComparator.Type type );
	
}