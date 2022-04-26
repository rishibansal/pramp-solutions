import java.io.*;
import java.util.*;

public class ShiftedArraySearch {
	
	public static void main(String[] args) {
		int[] shiftedArr = new int[]{9, 12, 17, 2, 4, 5};
		System.out.println(shiftedArraySearch(shiftedArr, 9));
		System.out.println(shiftedArraySearch(shiftedArr, 12));
		System.out.println(shiftedArraySearch(shiftedArr, 17));
		System.out.println(shiftedArraySearch(shiftedArr, 2));
		System.out.println(shiftedArraySearch(shiftedArr, 4));
		System.out.println(shiftedArraySearch(shiftedArr, 5));
		System.out.println(shiftedArraySearch(shiftedArr, 18));
	}

	private static int shiftedArraySearch(int[] shiftedArr, int num) {
		final int n = shiftedArr.length;
		// step-1: find pivot element
		int pivot = - 1;
		int low = 0, high = n - 1;
		while (low <= high) {
			int mid = (low + high) / 2;
			if (shiftedArr[(mid - 1 + n) % n] < shiftedArr[mid] 
				&& shiftedArr[(mid + 1) % n] < shiftedArr[mid]) {
				pivot = mid;
				break;
			} else if (shiftedArr[mid] < shiftedArr[low]) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		if (pivot < 0 || pivot > n - 1) {
			System.out.println("pivot is invalid for array " + Arrays.toString(shiftedArr));
			return -1;
		}
 		//from now pivot is index of max element
		// step-2: find given element
		if (num >= shiftedArr[0]) return binarySearch(0, pivot, shiftedArr, num);
		else return binarySearch(pivot + 1, shiftedArr.length - 1, shiftedArr, num);
	}

	private static int binarySearch(int low, int high, int[] arr, int key) {
		if (low > high) {
			return -1;
		}
		int mid = (low + high) / 2;
		if (arr[mid] == key) {
			return mid;
		} else if (arr[mid] > key) {
			return binarySearch(low, mid - 1, arr, key);
		} else {
			return binarySearch(mid + 1, high, arr, key);
		}
	}
}