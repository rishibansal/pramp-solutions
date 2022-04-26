import java.io.*;
import java.util.*;

public class KMessedArraySort {

	private static int[] sortArray(int[] arr, int k) {
		PriorityQueue<Integer> heap = new PriorityQueue<>(); // min heap
		for (int i = 0; i < k + 1 && i < arr.length; i++) {
			heap.add(arr[i]);
		}
		int i = 0;
		while (!heap.isEmpty()) {
			arr[i] = heap.poll();
			if (i + k + 1 < arr.length) {
				heap.add(arr[i + k + 1]);
			}
			i++;
		}
		return arr;
	}

	public static void main(String[] args) {
		int[] arr = new int[]{1, 4, 5, 2, 3, 7, 9, 6, 8, 10};
		System.out.println("original array: " + Arrays.toString(arr));
		arr = sortArray(arr, 2);
		System.out.println("sorted array: " + Arrays.toString(arr));
	}
}