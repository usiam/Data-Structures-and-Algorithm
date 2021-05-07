package lab3;

import java.util.ArrayList;
import java.util.Arrays;

public class Lab3Task1 {
	public static void main(String[] args) {
		
		System.out.println("Array output\n------------------------");
		int[][] array = {{ 10, 15, 30, 40 }, { 15, 5, 8, 2 }, { 20, 2, 4, 2 }, { 1, 4, 5, 0 } };
		print2Darray(array);

		System.out.println();
		
		System.out.println("ArrayList output\n------------------------");

		ArrayList<Integer> row1 = new ArrayList<Integer>(Arrays.asList(10, 15, 30, 40));
		ArrayList<Integer> row2 = new ArrayList<Integer>(Arrays.asList(15, 5, 8, 2));
		ArrayList<Integer> row3 = new ArrayList<Integer>(Arrays.asList(20, 2, 4, 2));
		ArrayList<Integer> row4 = new ArrayList<Integer>(Arrays.asList(1, 4, 5, 0));

		ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
		list.add(row1);
		list.add(row2);
		list.add(row3);
		list.add(row4);

		print2DList(list);
	}

	public static void print2Darray(int[][] array) {
		int numRows = 4;
		int numCols = 4;

		for (int i = 0; i < numRows; i++) {
			for (int j = 0; j < numCols; j++) {
				String s = String.format("%-7s", array[i][j]);
				System.out.print(s);
			}

			System.out.println();
		}
	}

	public static void print2DList(ArrayList<ArrayList<Integer>> list) {
		int numRows = 4;
		int numCols = 4;

		for (int i = 0; i < numRows; i++) {
			for (int j = 0; j < numCols; j++) {
				String s = String.format("%-7s", list.get(i).get(j));
				System.out.print(s);
			}

			System.out.println();
		}

	}
}
