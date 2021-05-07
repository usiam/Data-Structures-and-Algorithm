
/******************************************************************************
 *  Compilation:  javac Sorting.java
 *  Execution:    java Sorting input.txt AlgorithmUsed
 *  Dependencies: StdOut.java In.java Stopwatch.java
 *  Data files:   http://algs4.cs.princeton.edu/14analysis/1Kints.txt
 *                http://algs4.cs.princeton.edu/14analysis/2Kints.txt
 *                http://algs4.cs.princeton.edu/14analysis/4Kints.txt
 *                http://algs4.cs.princeton.edu/14analysis/8Kints.txt
 *                http://algs4.cs.princeton.edu/14analysis/16Kints.txt
 *                http://algs4.cs.princeton.edu/14analysis/32Kints.txt
 *                http://algs4.cs.princeton.edu/14analysis/1Mints.txt
 *
 *  A program to play with various sorting algorithms. 
 *
 *
 *  Example run:
 *  % java Sorting 2Kints.txt  2
 *
 ******************************************************************************/
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;

public class Sorting {

	/**
	 * 
	 * Sorts the numbers present in the file based on the algorithm provided. 0 =
	 * Arrays.sort() (Java Default) 1 = Bubble Sort 2 = Selection Sort 3 = Insertion
	 * Sort 4 = Mergesort 5 = Quicksort
	 *
	 * @param args the command-line arguments
	 */
	public static void main(String[] args) {
		In in = new In(args[0]);

		// Storing file input in an array
		int[] a = in.readAllInts();

		// TODO: Generate 3 other arrays, b, c, d where
		// b contains sorted integers from a (You can use Java Arrays.sort() method)
		// c contains all integers stored in reverse order
		// (you can have your own O(n) solution to get c from b
		// d contains almost sorted array
		// (You can copy b to a and then perform (0.1 * d.length) many swaps to acheive
		// this.

		int[] b = Arrays.copyOf(a, a.length); // you make a copy of a
		Arrays.sort(b); // you sort the copied array a which we call b now

		// c stores the worst case since it is sorted but in reverse
		int[] c = reverse(b);

		int[] d = n_swap(b, (int) (0.1 * b.length));

		// TODO:
		// Read the second argument and based on input select the sorting algorithm
		// * 0 = Arrays.sort() (Java Default)
		// * 1 = Bubble Sort
		// * 2 = Selection Sort
		// * 3 = Insertion Sort
		// * 4 = Mergesort
		// * 5 = Quicksort
		// Perform sorting on a,b,c,d. Print runtime for each case along with timestamp
		// and record those.
		// For runtime and printing, you can use the same code from Lab 4 as follows:

		String sortType = args[1];
		String[] arrayName = { "a", "b", "c", "d" };
		String netID = "usiam";

		for (int i = 0; i < arrayName.length; i++) {

			int[] sortArray = new int[a.length];
			String arrayUsed = arrayName[i];

			if (arrayUsed.equals("a")) {
				System.arraycopy(a, 0, sortArray, 0, sortArray.length); 
			} else if (arrayUsed.equals("b")) {
				System.arraycopy(b, 0, sortArray, 0, sortArray.length); 
			} else if (arrayUsed.equals("c")) {
				System.arraycopy(c, 0, sortArray, 0, sortArray.length); 
			} else if (arrayUsed.equals("d")) {
				System.arraycopy(d, 0, sortArray, 0, sortArray.length); 
			}

			// TODO: For each array, a, b, c, d:
			Stopwatch timer = new Stopwatch();
			// TODO: Perform Sorting and store the result in an array
			int[] sortedArray = sortingOperation(sortArray, sortType);

			// Stops the timer
			double time = timer.elapsedTimeMillis();

			try {
				// outputting sorted array for verification
				FileWriter writer = new FileWriter(arrayUsed + ".txt");
				for (int j = 0; j < sortedArray.length; j++) {
					writer.write(sortedArray[j] + "\n");
				}
				writer.close();
			} catch (IOException e) {

			}
			if (!sorted(sortedArray)) {
				// checks if sorting algorithm actually worked
				StdOut.printf("%s did not sort %s correctly, input file %s\n", algorithmName(sortType), arrayUsed, args[0]);
			}

			String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
			// TODO: Replace with your own netid

			StdOut.printf("%s %s %8.1f   %s  %s  %s\n", algorithmName(sortType), arrayUsed, time, timeStamp, netID, args[0]);
			// Write the resultant array to a file (Each time you run a program 4 output
			// files should be generated. (one for each a,b,c, and d)
		}
	}

	public static int[] reverse(int[] arr) {
		/*
		 * goes through the original array int[] arr, assigns the last element in the
		 * new array int[] reversed as the first element in int[] arr
		 */
		int[] reversed = new int[arr.length];
		int j = arr.length;

		for (int i = 0; i < arr.length; i++) {
			reversed[j - 1] = arr[i];
			j--;
		}

		return reversed;
	}

	public static String algorithmName(String algoNum) {
		// listing out which number corresponds to which sorting algorithm
		String algorithmUsed;
		switch (algoNum) {
		case "0":
			algorithmUsed = "default sort";
			break;
		case "1":
			algorithmUsed = "bubble sort";
			break;
		case "2":
			algorithmUsed = "selection sort";
			break;
		case "3":
			algorithmUsed = "insertion sort";
			break;
		case "4":
			algorithmUsed = "merge sort";
			break;
		case "5":
			algorithmUsed = "quick sort";
			break;
		default:
			algorithmUsed = "";
			break;
		}
		return algorithmUsed;
	}

	public static int[] n_swap(int[] to_swap, int n) {
		/*
		 * we choose two random indices and swap the values in the array at those two
		 * indices and we do this n times where n will be equal to (0.1 * d.length)
		 */
		int[] swapped = new int[to_swap.length];
		System.arraycopy(to_swap, 0, swapped, 0, to_swap.length);
		for (int numSwaps = 0; numSwaps < n; numSwaps++) {
			int swapInd1 = StdRandom.uniform(to_swap.length);
			int swapInd2 = StdRandom.uniform(to_swap.length);
			while (swapInd1 == swapInd2) {
				swapInd2 = StdRandom.uniform(to_swap.length);
			}
			int temp = swapped[swapInd1];
			swapped[swapInd1] = swapped[swapInd2];
			swapped[swapInd2] = temp;
		}
		return swapped;
	}

	public static boolean sorted(int[] sorted) {
		// Checks if the array is sorted
		for (int i = 0; i < sorted.length - 1; i++) {
			if (sorted[i] > sorted[i + 1]) {
				return false;
			}
		}
		return true;
	}

	public static int[] sortingOperation(int[] sortArray, String sortType) {
		int[] sortedArray;

		switch (sortType) {
		case "0":
			sortedArray = defaultSort(sortArray);
			break;
		case "1":
			sortedArray = bubbleSort(sortArray);
			break;
		case "2":
			sortedArray = selectionSort(sortArray);
			break;
		case "3":
			sortedArray = insertionSort(sortArray);
			break;
		case "4":
			sortedArray = mergeSort(sortArray);
			break;
		case "5":
			sortedArray = quickSort(sortArray);
			break;
		default:
			sortedArray = sortArray;
			break;
		}
		return sortedArray;
	}

	public static int[] defaultSort(int[] sortArray) {
		Arrays.sort(sortArray);
		return sortArray;
	}

	public static int[] bubbleSort(int[] sortArray) {
		int len = sortArray.length;
		for (int i = 0; i < len - 1; i++) {
			for (int j = 0; j < len - i - 1; j++) {
				if (sortArray[j] > sortArray[j + 1]) {
					int temp = sortArray[j];
					sortArray[j] = sortArray[j + 1];
					sortArray[j + 1] = temp;
				}
			}
		}
		return sortArray;
	}

	public static int[] selectionSort(int[] sortArray) {
		int len = sortArray.length;
		for (int i = 0; i < len - 1; i++) {
			int min_idx = i;
			for (int j = i + 1; j < len; j++) {
				// fixing place of smallest element in each pass
				if (sortArray[j] < sortArray[min_idx]) {
					min_idx = j;
				}
			}
			int temp = sortArray[min_idx];
			sortArray[min_idx] = sortArray[i];
			sortArray[i] = temp;
		}
		return sortArray;
	}

	public static int[] insertionSort(int[] sortArray) {
		int len = sortArray.length;
		for (int i = 1; i < len; i++) {
			int key = sortArray[i];
			int j = i - 1;

			while (j >= 0 && sortArray[j] > key) {
				sortArray[j + 1] = sortArray[j];
				j--;
			}
			sortArray[j + 1] = key;
		}
		return sortArray;

	}

	public static int[] mergeSort(int[] sortArray) {
		// calling merge_sort with a more convenient function signature
		return mergesort(sortArray, 0, sortArray.length - 1);
	}

	public static int[] mergesort(int[] sortArray, int l, int r) {
		if (l < r) {
			// pivot index
			int m = l + (r - l) / 2;

			// recursive calls to sort left and right halves
			sortArray = mergesort(sortArray, l, m);
			sortArray = mergesort(sortArray, m + 1, r);

			// merging left and right halves
			sortArray = merge(sortArray, l, m, r);
		}
		// base case, done sorting
		return sortArray;
	}

	public static int[] merge(int[] sortArray, int l, int m, int r) {
		int sz1 = m + 1 - l;
		int sz2 = r - m;

		// temporary arrays to be used while merging
		int leftSub[] = new int[sz1];
		int rightSub[] = new int[sz2];

		// putting left and right halves into temporary arrays
		System.arraycopy(sortArray, l, leftSub, 0, sz1);
		System.arraycopy(sortArray, m + 1, rightSub, 0, sz2);

		int i = 0;
		int j = 0;
		int k = l;

		// insert smallest of the elements
		while (i < sz1 && j < sz2) {
			if (leftSub[i] <= rightSub[j]) {
				sortArray[k++] = leftSub[i++];
			} else {
				sortArray[k++] = rightSub[j++];
			}
		}

		// insert any remaining elements from either half
		while (i < sz1) {
			sortArray[k++] = leftSub[i++];
		}

		while (j < sz2) {
			sortArray[k++] = rightSub[j++];
		}

		return sortArray;
	}

	public static int[] quickSort(int[] sortArray) {
		// calling quicksort with a more convenient function signature
		return quicksort(sortArray, 0, sortArray.length - 1);
	}

	public static int[] quicksort(int[] sortArray, int l, int r) {
		// base case, done sorting
		if (l >= r) {
			return sortArray;
		}

		// find pivot
		int m = partition(sortArray, l, r);

		// recursive calls to sort either side
		sortArray = quicksort(sortArray, l, m);
		sortArray = quicksort(sortArray, m + 1, r);

		return sortArray;
	}

	public static int partition(int[] sortArray, int l, int r) {
		// mid point
		int m = l + (r - l) / 2;
		int pivot = sortArray[m];

		// while !(l >= r)
		for (boolean done = false; done != true;) {
			while (sortArray[l] < pivot) {
				l++; // finding first left-elem larger than pivot
			}

			while (pivot < sortArray[r]) {
				r--; // finding first right-elem smaller than pivot
			}

			if (l >= r) {
				done = true;
			} else {
				// swap left larger and right smaller
				int temp = sortArray[l];
				sortArray[l] = sortArray[r];
				sortArray[r] = temp;

				l++;
				r--;
			}
		}

		return r;
	}

}
