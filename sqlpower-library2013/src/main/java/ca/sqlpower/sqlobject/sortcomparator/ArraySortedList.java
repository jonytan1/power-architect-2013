package ca.sqlpower.sqlobject.sortcomparator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import ca.sqlpower.sqlobject.SQLObject;
import ca.sqlpower.sqlobject.sortcomparator.SQLObjectSortComparator.Type;

/**
 * This ArrayList is to store the {@link #SQLObject}s that sorted by the defined {@link SQLObjectSortComparator}.
 * 
 * @author jianjun.tan
 *
 * @param <E>
 */
public class ArraySortedList<E extends SQLObject> implements SortedList<E> {
	
	private SQLObjectSortComparator<E> comparator;
	private List<E> sortedList = new ArrayList<E>();
	private E[] eArray;
	
	/**
	 * Default is sorted by sequence.
	 */
	public ArraySortedList ( E[] eArray ){
		this( SQLObjectSortComparator.Type.BySequence, eArray );
	}
	
	public ArraySortedList ( SQLObjectSortComparator.Type type, E[] eArray ){
		comparator = new SQLObjectSortComparatorFactory<E>().createSortComparator(type);
		this.eArray = eArray;
	}
	
	@Override
	public boolean add(E e) {
		synchronized( this.sortedList ){
			if (comparator.isComparator(Type.BySequence)){
				this.sortedList.add(this.sortedList.size(), e);
				return true;
			}
			int index = findIndexByBisection( e, 0, this.sortedList.size() - 1);
			this.sortedList.add(index, e);
			return true;
		}
	} 

	private int findIndexByBisection( E e, int start, int end ){
		if ( start > end ) return start;
		else if (start == end){
			// Get the position of element that is the first one greater than the specified element e. 
			// if no, return list.size() + 1
			boolean gt = ( comparator.compare(this.sortedList.get(start), e) <= 0 );
			return ( gt ? start + 1 : start);
		}
		int middle = ( end + start ) / 2;
		if ( comparator.compare(this.sortedList.get(middle), e) <= 0 ){
			return findIndexByBisection( e, middle + 1, end );
		}
		return findIndexByBisection( e, start, middle );
	}
	
	@Override
	public void add(int index, E element) {
		synchronized( this.sortedList ){
			if (comparator.isComparator(Type.BySequence)){
				this.sortedList.add(index, element);
				return;
			}
		}
		throw new UnsupportedOperationException("ArraySortedList that the type of Comparator is not BySequence, doesn't support add(int,E). Use \"add(E)\" instead.");
	}

	@Override
	public boolean addAll(Collection<? extends E> c) {
		synchronized( this.sortedList ){
			if (comparator.isComparator(Type.BySequence)){
				return this.sortedList.addAll(c);
			}
			if ( !this.sortedList.addAll(c) ) return false;
			E[] children = sortedList.toArray(eArray);
    		Arrays.sort( children, comparator);
    		List<E> newList = new ArrayList<E>();
    		for ( int i = 0; i < children.length; i++ ){
    			newList.add(children[i]);
    		}
    		sortedList = newList;
			return true;
		}
	}

	@Override
	public boolean addAll(int index, Collection<? extends E> c){
		synchronized( this.sortedList ){
			if (comparator.isComparator(Type.BySequence)){
				return this.sortedList.addAll(index, c);
			}
		}
		throw new UnsupportedOperationException("The ArraySortedList which the type of Comparator is not BySequence, doesn't support addAll(int,Collection<? extends E>).");
	}

	@Override
	public void clear() {
		synchronized( this.sortedList ){
			this.sortedList.clear();
		}
	}

	@Override
	public boolean contains(Object o) {
		synchronized( this.sortedList ){
			return this.sortedList.contains(o);
		}
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		synchronized( this.sortedList ){
			return this.sortedList.containsAll(c);
		}
	}

	@Override
	public E get(int index) {
		synchronized( this.sortedList ){
			return this.sortedList.get(index);
		}

	}

	@Override
	public int indexOf(Object o) {
		synchronized( this.sortedList ){
			return this.sortedList.indexOf(o);
		}
	}

	@Override
	public boolean isEmpty() {
		synchronized( this.sortedList ){
			return this.sortedList.isEmpty();
		}
	}

	@Override
	public Iterator<E> iterator() {
		synchronized( this.sortedList ){
			return this.sortedList.iterator();
		}
	}

	@Override
	public int lastIndexOf(Object o) {
		synchronized( this.sortedList ){
			return this.sortedList.lastIndexOf(o);
		}
	}

	@Override
	public ListIterator<E> listIterator() {
		synchronized( this.sortedList ){
			return this.sortedList.listIterator();
		}
	}

	@Override
	public ListIterator<E> listIterator(int index) {
		synchronized( this.sortedList ){
			return this.sortedList.listIterator(index);
		}
	}

	@Override
	public boolean remove(Object o) {
		synchronized( this.sortedList ){
			return this.sortedList.remove(o);
		}
	}

	@Override
	public E remove(int index) {
		synchronized( this.sortedList ){
			return this.sortedList.remove(index);
		}
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		synchronized( this.sortedList ){
			return this.sortedList.removeAll(c);
		}
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		synchronized( this.sortedList ){
			return this.sortedList.retainAll(c);
		}
	}

	@Override
	public E set(int index, E element) {
		synchronized( this.sortedList ){
			return this.sortedList.set( index, element );
		}
	}

	@Override
	public int size() {
		synchronized( this.sortedList ){
			return this.sortedList.size();
		}
	}

	@Override
	public List<E> subList(int fromIndex, int toIndex) {
		synchronized( this.sortedList ){
			return this.sortedList.subList(fromIndex, toIndex);
		}
	}

	@Override
	public Object[] toArray() {
		synchronized( this.sortedList ){
			return this.sortedList.toArray();
		}
	}

	@Override
	public <T> T[] toArray(T[] a) {
		synchronized( this.sortedList ){
			return this.sortedList.toArray(a);
		}
	}

	@Override
	public void setSortComparator(Type type) {
		if (type != null && type == Type.BySequence ){
			comparator = new SQLObjectSortComparatorFactory<E>().createSortComparator(type);
			return;
		}
		if ( type != null && !comparator.isComparator(type) ){
			synchronized( this.sortedList ){
				comparator = new SQLObjectSortComparatorFactory<E>().createSortComparator(type);
				E[] children = (E[]) sortedList.toArray(eArray);
	    		Arrays.sort( children, comparator);
	    		List<E> newList = new ArrayList<E>();
	    		for ( int i = 0; i < children.length; i++ ){
	    			newList.add(children[i]);
	    		}
	    		sortedList = newList;
			}
		}
	} 

	@Override
	public boolean isComparator(Type type) {
		return comparator.isComparator(type);
	}

	/**
	 * Get the current sort comparator.
	 * @return
	 */
	public SQLObjectSortComparator<E> getSortComparator(){
		return comparator;
	}
}
