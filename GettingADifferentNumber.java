import java.io.*;
import java.util.*;

public class GettingADifferentNumber {

	// doesn't change arr, time O(nlogn), space O(n)
	private static int getDifferentNumber(int[] arr) {
		if (arr.length == 0) {
			return 0;
		}
		int[] sortedArr = new int[arr.length];
		System.arraycopy(arr, 0, sortedArr, 0, sortedArr.length);
		Arrays.sort(sortedArr);
		int i = 0;
		while (i < sortedArr.length) {
			if (i != sortedArr[i]) {
				return i;
			}
			i++;
		}
		return i;
	}

	// doesn't change arr, time O(n), space O(n)
	private static int getDifferentNumber2(int[] arr) {
		if (arr.length == 0) {
			return 0;
		}
		Set<Integer> set = new HashSet<>(arr.length);
		for (int i = 0; i < arr.length; i++) {
			set.add(arr[i]);
		}
		for (int i = 0; i < arr.length; i++) {
			if (!set.contains(i)) {
				return i;
			}
		}
		return arr.length;
	}

	// changes arr, time O(n), space O(1)
	private static int getDifferentNumber3(int[] arr) {
		if (arr.length == 0) {
			return 0;
		}
		for (int i = 0; i < arr.length; i++) {
			int temp = arr[i];
			if (temp < arr.length && temp != arr[temp]) {
				int temp2 = arr[i];
				arr[i] = arr[temp];
				arr[temp] = temp2;
			}
		}
		int i = 0;
		while (i < arr.length) {
			if (i != arr[i]) {
				return i;
			}
			i++;
		}
		return i;
	}

	public static void main(String[] args) {
		System.out.println(getDifferentNumber(new int[]{0, 1, 2, 3}));
		System.out.println(getDifferentNumber2(new int[]{0, 1, 2, 3}));
		System.out.println(getDifferentNumber3(new int[]{0, 1, 2, 3}));		
	}
}
