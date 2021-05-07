package lab3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class Lab3Task3 {

	public static void main(String[] args) {

		ArrayList<Integer> al = new ArrayList<Integer>(Arrays.asList(1, 5, 7, 2));

		System.out.println("Basic while loop\n-----------");
		printArrayListBasicLoop(al);

		System.out.println("\nEnhanced for loop\n-----------");
		printArrayListForLoopListIterator(al);

		System.out.println("\nFor loop using iterator\n-----------");
		printArrayListForLoopListIterator(al);

		System.out.println("\nWhile loop using iterator\n-----------");
		printArrayListWhileLoopListIterator(al);
	}

	public static void printArrayListBasicLoop(ArrayList<Integer> al) {
		int size = al.size();
		int i = 0;

		while (i < size) {
			System.out.println(al.get(i));
			i++;
		}

		System.out.println();
	}

	public static void printArrayListEnhancedLoop(ArrayList<Integer> al) {
		for (int elem : al) {
			System.out.println(elem);
		}

		System.out.println();
	}

	public static void printArrayListForLoopListIterator(ArrayList<Integer> al) {

		for (Iterator<Integer> it = al.iterator(); it.hasNext();) {
			int elem = it.next();
			System.out.println(elem);
		}

		System.out.println();
	}

	public static void printArrayListWhileLoopListIterator(ArrayList<Integer> al) {
		Iterator<Integer> it = al.iterator();

		while (it.hasNext()) {
			int elem = it.next();
			System.out.println(elem);
		}

		System.out.println();
	}

}
