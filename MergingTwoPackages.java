import java.io.*;
import java.util.*;

public class MergingTwoPackages {
	
	public static void main(String[] args) {
		int[] arr = new int[]{4, 6, 6, 6, 10, 15, 15, 15, 16};
    	System.out.println(Arrays.toString(getIndicesOfItemWeights(arr, 21)));
	}

	private static int[] getIndicesOfItemWeights(int[] arr, int limit) {
		Map<Integer, Integer> dict = new HashMap<>();
		for (int i = 0; i < arr.length; i++) {
	      	if (dict.containsKey(limit - arr[i])) {
	        	return new int[]{i, dict.get(limit - arr[i])};
	      	}
	      	dict.put(arr[i], Math.min(i, dict.getOrDefault(arr[i], i)));
    	}
    	return new int[]{};
	}
}