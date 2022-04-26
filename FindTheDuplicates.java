import java.io.*;
import java.util.*;

public class FindTheDuplicates {
	
	public static void main(String[] args) {
		int[] arr1 = new int[]{1, 2, 3, 5, 6, 7, 8, 10, 51, 100, 501, 600, 1000};
		int[] arr2 = new int[]{500, 1000};
		System.out.println(Arrays.toString(findDuplicates(arr1, arr2)));
	}

	private static int[] findDuplicates(int[] left, int[] right) {
		List<Integer> output_list = new ArrayList<>();
		int i = 0, j = 0;
		while (i < left.length && j < right.length) {
			if (left[i] == right[j]) {
				output_list.add(left[i]);
				i++;
				j++;
			} else if (left[i] < right[j]) {
				// find right[j] in left[i+1:]
				i = binarySearch(left, i + 1, left.length - 1, right[j]);
			} else {
				// find left[i] in right[j+1:]
				j = binarySearch(right, j + 1, right.length - 1, left[i]);
			}
		}
		int[] output = new int[output_list.size()];
		int k = 0;
		for (Integer output_val : output_list) {
			output[k++] = output_val;
		}
		return output;
	}

	private static int binarySearch(int[] arr, int low, int high, int num) {
		if (low > high) {
			return low;
		}
		int mid = (low + high) / 2;
		if (arr[mid] == num) {
			return mid;
		} else if (arr[mid] > num) {
			return binarySearch(arr, low, mid - 1, num);
		} else {
			return binarySearch(arr, mid + 1, high, num);
		}
	}
}