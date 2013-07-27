package ca.sqlpower.sqlobject.comparator;

import java.util.Iterator;

import ca.sqlpower.sqlobject.SQLTable;
import ca.sqlpower.sqlobject.comparator.SQLObjectComparator.Type;
import junit.framework.TestCase;

public class ArraySortedListTest extends TestCase {
	private ArraySortedList<SQLTable> sortedList;
	private SQLObjectComparator<SQLTable> comparator;
	
	@Override
	public void setUp() {
		sortedList = new ArraySortedList<SQLTable>( new SQLTable[]{} );
		comparator = sortedList.getSortComparator();
	}

	public void testAdd(){
		SQLTable table = new SQLTable();
		table.setName("1");
		table.setLogicalName("2");
		table.setRemarks("001");
		sortedList.add(table);
		
		table = new SQLTable();
		table.setName("4");
		table.setLogicalName("1");
		table.setRemarks("002");
		sortedList.add(table);
		assertTrue(comparator.compare(sortedList.get(0),sortedList.get(1))<=0);
		printSortedList("Name");
		
		table = new SQLTable();
		table.setName("2");
		table.setLogicalName("7");
		table.setRemarks("003");
		sortedList.add(table);
		assertTrue(comparator.compare(sortedList.get(0),sortedList.get(1))<=0);
		assertTrue(comparator.compare(sortedList.get(1),sortedList.get(2))<=0);
		printSortedList("Name");
		
		table = new SQLTable();
		table.setName("8");
		table.setLogicalName("1");
		table.setRemarks("004");
		sortedList.add(table);
		assertTrue(comparator.compare(sortedList.get(0),sortedList.get(1))<=0);
		assertTrue(comparator.compare(sortedList.get(1),sortedList.get(2))<=0);
		assertTrue(comparator.compare(sortedList.get(2),sortedList.get(3))<=0);
		printSortedList("Name");
		
		table = new SQLTable();
		table.setName("2");
		table.setLogicalName("6");
		table.setRemarks("005");
		sortedList.add(table);
		assertTrue(comparator.compare(sortedList.get(0),sortedList.get(1))<=0);
		assertTrue(comparator.compare(sortedList.get(1),sortedList.get(2))<=0);
		assertTrue(comparator.compare(sortedList.get(2),sortedList.get(3))<=0);
		assertTrue(comparator.compare(sortedList.get(3),sortedList.get(4))<=0);
		printSortedList("Name");
		
		table = new SQLTable();
		table.setName("0");
		table.setLogicalName("9");
		table.setRemarks("006");
		sortedList.add(table);
		assertTrue(comparator.compare(sortedList.get(0),sortedList.get(1))<=0);
		assertTrue(comparator.compare(sortedList.get(1),sortedList.get(2))<=0);
		assertTrue(comparator.compare(sortedList.get(2),sortedList.get(3))<=0);
		assertTrue(comparator.compare(sortedList.get(3),sortedList.get(4))<=0);
		assertTrue(comparator.compare(sortedList.get(4),sortedList.get(5))<=0);
		printSortedList("Name");
		
		sortedList.setSortComparator(Type.ByLogicalName);
		comparator = sortedList.getSortComparator();
		printSortedList("LogicalName");
		assertTrue(comparator.compare(sortedList.get(0),sortedList.get(1))<=0);
		assertTrue(comparator.compare(sortedList.get(1),sortedList.get(2))<=0);
		assertTrue(comparator.compare(sortedList.get(2),sortedList.get(3))<=0);
		assertTrue(comparator.compare(sortedList.get(3),sortedList.get(4))<=0);
		assertTrue(comparator.compare(sortedList.get(4),sortedList.get(5))<=0);
	}
	
	private void printSortedList(String title){
		System.out.println( title );
		Iterator<SQLTable> it = sortedList.iterator();
		while ( it.hasNext() ){
			SQLTable child = it.next();
			System.out.println( child.getRemarks() + "-----name=" + child.getName() + ";logicalname=" + child.getLogicalName() );
		}
	}
}
