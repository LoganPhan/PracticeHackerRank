package logan;

import java.util.Arrays;

public class InsertionSort {

	public static void main(String[] args) {
		int[] arr = { 4, 3, 2, 10, 12, 1, 5 };
		insertionSort(arr);
		Arrays.stream(arr).forEach(System.out::println);
	}

	static void insertionSort(int[] arr) {
		int length = arr.length;
		for (int i = 1; i < length; i++) {
			int key = arr[i];
			 int j = i-1;
			 
	            /* Move elements of arr[0..i-1], that are
	               greater than key, to one position ahead
	               of their current position */
	            while (j>=0 && arr[j] > key)
	            {
	                arr[j+1] = arr[j];
	                j = j-1;
	            }
	            arr[j+1] = key;
	        	Arrays.stream(arr).forEach(System.out::println);
		}
	}
}
