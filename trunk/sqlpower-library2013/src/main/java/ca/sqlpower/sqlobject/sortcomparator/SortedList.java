package ca.sqlpower.sqlobject.sortcomparator;

import java.util.List;

/**
 * 
 * @author jianjun.tan
 *
 * @param <E>
 */
public interface SortedList<E> extends List<E> {

	public void setSortComparator( SQLObjectSortComparator.Type type );
	public boolean isComparator( SQLObjectSortComparator.Type type );
	
}
