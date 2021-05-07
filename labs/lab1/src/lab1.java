import java.util.*;

public class lab1 {

	public static void main(String[] args) {

		System.out.println("Anagram\n--------");
		System.out.println(isAnagram("QweRty", "QweRtY"));
		System.out.println(isAnagram("qwe_123_omorw3", "3123_owrmoq_we"));
		System.out.println(isAnagram("^^^^&&123", "^^^^&&123"));
		System.out.println(isAnagram("1111", "11111"));

		System.out.println("\nRotation\n-------");
		System.out.println(isRotation("123yrewq", "yreqw123"));
		System.out.println(isRotation("0 1 2", "1 20 "));
		System.out.println(isRotation("^^^^&&123", "^^^^&&123"));
		System.out.println(isRotation("1111", "11111"));

	}

	// Question 1
	public static boolean isAnagram(String s1, String s2) {

		if (s1.length() != s2.length()) {// if length is not same they can never be anagrams
			return false;
		}

		char[] s1CharArray = s1.toCharArray(); // turns string into a character array
		Arrays.sort(s1CharArray); // sorts the character array

		char[] s2CharArray = s2.toCharArray();
		Arrays.sort(s2CharArray);

		if (Arrays.equals(s1CharArray, s2CharArray)) { // if the two character arrays are equal returns true
			return true;
		} else { // else returns false
			return false;
		}

	}

	// Question 2
	public static boolean isRotation(String s1, String s2) {
		if (!isAnagram(s1, s2)) { // if it's not an anagram or at least doesn't have the same length it will never
									// be a rotation
			return false;
		}

		String temp = s1 + s1; // concatenates the string with itself

		if (temp.contains(s2)) { // checks if the second string is in the contatenated string
			return true;
		}

		return false;

	}
}
