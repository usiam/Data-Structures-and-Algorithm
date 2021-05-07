package lab3;

import java.util.ArrayList;
import java.util.Arrays;

public class Lab3Task2 {

	public static int[][] runningSum2DArray(int[][] array, int dir) {
		int numRows = 4;
		int numCols = 4;
		
		int[][] newArr = new int[numRows][numCols];

		if (dir == 1) {
			for (int i = 0; i < numRows; i++) {
				int sum = 0;
				for (int j = numCols - 1; j >= 0; j--) {
					sum += array[i][j];
					newArr[i][j] = sum;
				}
			}

			return newArr;

		} else if (dir == 2) {
			for (int i = 0; i < numRows; i++) {
				int sum = 0;

				for (int j = 0; j < numCols; j++) {
					sum += array[i][j];
					newArr[i][j] = sum;
				}
			}
			return newArr;
		} else if (dir == 3) {
			for (int i = 0; i < numRows; i++) {
				int sum = 0;

				for (int j = numCols - 1; j >= 0; j--) {
					sum += array[j][i];
					newArr[j][i] = sum;
				}
			}
			return newArr;
		} else if (dir == 4) {
			for (int i = 0; i < numRows; i++) {
				int sum = 0;

				for (int j = 0; j < numCols; j++) {
					sum += array[j][i];
					newArr[j][i] = sum;
				}
			}
			return newArr;
		}

		return array;
	}
	
	public static ArrayList<ArrayList<Integer>> runningSum2DArrayList(ArrayList<ArrayList<Integer>> list, int dir){
		int numRows = 4;
		int numCols = 4;
		
		ArrayList<ArrayList<Integer>> newList = new ArrayList<ArrayList<Integer>>();
		for(ArrayList<Integer> row : list) {
			ArrayList<Integer> newRow = new ArrayList<Integer>(row);
			newList.add(newRow);
		}
		
		if (dir == 1) {
			for (int i = 0; i < numRows; i++) {
				int sum = 0;
				for (int j = numCols - 1; j >= 0; j--) {
					sum += list.get(i).get(j);
					newList.get(i).set(j, sum);
				}
			}

			return newList;

		} else if (dir == 2) {
			for (int i = 0; i < numRows; i++) {
				int sum = 0;

				for (int j = 0; j < numCols; j++) {
					sum += list.get(i).get(j);
					newList.get(i).set(j, sum);
				}
			}
			return newList;
		} else if (dir == 3) {
			for (int i = 0; i < numRows; i++) {
				int sum = 0;

				for (int j = numCols - 1; j >= 0; j--) {
					sum += list.get(j).get(i);
					newList.get(j).set(i, sum);
				}
			}
			return newList;
		} else if (dir == 4) {
			for (int i = 0; i < numRows; i++) {
				int sum = 0;

				for (int j = 0; j < numCols; j++) {
					sum += list.get(j).get(i);
					newList.get(j).set(i, sum);
				}
			}
			return newList;
		}

		return newList;
	}
	

	public static void main(String[] args) {
		//Array
		
		System.out.println("Array\n------------\n");
		
		int[][] array = { { 10, 15, 30, 40 }, { 15, 5, 8, 2 }, { 20, 2, 4, 2 }, { 1, 4, 5, 0 } };
		
		System.out.println("dir == 1");
		Lab3Task1.print2Darray(runningSum2DArray(array, 1));
		
		System.out.println("\n-----------\n");
		
		System.out.println("dir == 2");
		Lab3Task1.print2Darray(runningSum2DArray(runningSum2DArray(array,1), 2));
	
		System.out.println("\n-----------\n");

		System.out.println("dir == 3");
		Lab3Task1.print2Darray(runningSum2DArray(array, 3));
		
		System.out.println("\n-----------\n");
		
		System.out.println("dir == 4");
		Lab3Task1.print2Darray(runningSum2DArray(runningSum2DArray(array,3), 4));

	
		
		
		//ArrayList
		
		System.out.println("\nArrayList\n------------\n");
		
		ArrayList<Integer> row1 = new ArrayList<Integer>(Arrays.asList(10, 15, 30, 40));
		ArrayList<Integer> row2 = new ArrayList<Integer>(Arrays.asList(15, 5, 8, 2));
		ArrayList<Integer> row3 = new ArrayList<Integer>(Arrays.asList(20, 2, 4, 2));
		ArrayList<Integer> row4 = new ArrayList<Integer>(Arrays.asList(1, 4, 5, 0));
		
		ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
		list.add(row1);
		list.add(row2);
		list.add(row3);
		list.add(row4);
		
		System.out.println("dir == 1");
		Lab3Task1.print2DList(runningSum2DArrayList(list, 1));
		
		System.out.println("\n-----------\n");
		
		System.out.println("dir == 2");
		Lab3Task1.print2DList(runningSum2DArrayList(runningSum2DArrayList(list,1), 2));
		
		System.out.println("\n-----------\n");
		
		System.out.println("dir == 3");
		Lab3Task1.print2DList(runningSum2DArrayList(list, 3));

		System.out.println("\n-----------\n");
		
		System.out.println("dir == 4");
		Lab3Task1.print2DList(runningSum2DArrayList(runningSum2DArrayList(list, 3), 4));
		
	}
}
