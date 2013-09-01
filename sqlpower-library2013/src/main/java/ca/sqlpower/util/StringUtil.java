package ca.sqlpower.util;

public class StringUtil {

	/**
	 * Compares two Strings, ignoring case considerations. <br>
	 * Two strings are considered equal if all of them are null;<br>
	 * Two strings are considered not equal if only one of them is null;<br>
	 * Otherwise, two strings are considered equal ignoring case if they are of the same length 
	 * and corresponding characters in the two strings are equal ignoring case. 
	 * @param s1
	 * @param s2
	 * @return
	 */
	public static boolean equalsIgnoreCase(String s1, String s2){
		if (s1 == null && s2 == null) return true;
		if (s1 == null || s2 == null) return false;
		return s1.equalsIgnoreCase(s2);
	}

	/**
	 * Compares two Strings. <br>
	 * Two strings are considered equal if all of them are null;<br>
	 * Two strings are considered not equal if only one of them is null;<br>
	 * Otherwise, the result is true if and only if s2 is a String object that 
	 * represents the same sequence of characters as s1(case sensitive).
	 * @param s1
	 * @param s2
	 * @return
	 */
	public static boolean equals(String s1, String s2){
		if (s1 == null && s2 == null) return true;
		if (s1 == null || s2 == null) return false;
		return s1.equals(s2);
	}
}
