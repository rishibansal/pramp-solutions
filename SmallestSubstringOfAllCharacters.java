import java.io.*;
import java.util.*;

public class SmallestSubstringOfAllCharacters {

	public static void main(String[] args) {
		System.out.println(getShortestUniqueSubstring(new char[]{'x', 'y', 'z'}, "xyyzyzyx"));
	}

	private static String getShortestUniqueSubstring(char[] arr, String str) {
		Map<Character, Integer> dict = new HashMap<>();
		for (int k = 0; k < arr.length; k++) {
			dict.put(arr[k], 0);
		}
		int i = 0, j = arr.length - 1;
		int count = 0;
		for (int k = i; k <= j && k < str.length(); k++) {
			count = addToDict(str.charAt(k), dict, count);
		}
		int minlen = Integer.MAX_VALUE;
		int min_i = -1;
		int min_j = -1;
		while (j < str.length()) {
			if (count == arr.length) {
				int currlen = j - i + 1;
				if (currlen < minlen) {
					minlen = currlen;
					min_i = i;
					min_j = j;
				}
			}
			if (count != arr.length) {
				j++;
				if (j < str.length()) {
					count = addToDict(str.charAt(j), dict, count);
				}
			} else {
				count = removeFromDict(str.charAt(i), dict, count);
				i++;
			}
		}
		// System.out.println(str.substring(min_i, min_j + 1) + ", i=" + min_i + ", j=" + min_j);
		return minlen == Integer.MAX_VALUE ? "" : str.substring(min_i, min_j + 1);
	}

	private static int addToDict(char c, Map<Character, Integer> dict, int count) {
		if (dict.containsKey(c)) {
			int curr = dict.get(c);
			if (curr == 0) {
				count++;
			}
			dict.put(c, curr + 1);
		}
		return count;
	}

	private static int removeFromDict(char c, Map<Character, Integer> dict, int count) {
		if (dict.containsKey(c)) {
			int curr = dict.get(c);
			if (curr == 1) {
				count--;
			}
			dict.put(c, curr - 1);
		}
		return count;
	}
}
