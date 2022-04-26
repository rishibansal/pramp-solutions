import java.io.*;
import java.util.*;

public class ArrayIndexAndElementEquality {
	
	public static void main(String[] args) {
		System.out.println(indexEqualsValueSearch(new int[]{-1, 0, 3, 6}));
    	System.out.println(indexEqualsValueSearch(new int[]{-8, 0, 2, 5}));
	}

	// does not handle duplicate elements in the sorted array
	private static int indexEqualsValueSearch(int[] arr) {
		int candidate = -1;
	    int low = 0, high = arr.length - 1;
	    while (low <= high) {
	      int mid = (low + high) / 2;
	      if (arr[mid] == mid) {
	        candidate = mid;
	        high = mid - 1;
	      } else if (arr[mid] > mid) {
	        high = mid - 1;
	      } else {
	        low = mid + 1;
	      }
	    }
	    return candidate;
	}
}