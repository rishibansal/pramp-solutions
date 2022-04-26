import java.io.*;
import java.util.*;

public class DeletionDistance {
	
	public static void main(String[] args) {
		System.out.println("deletion distance for 'heat' and 'hit' is: " + deletionDistance("heat", "hit"));
		System.out.println("deletion distance for 'dog' and 'frog' is: " + deletionDistance("dog", "frog"));
		System.out.println("deletion distance for 'some' and 'some' is: " + deletionDistance("some", "some"));
		System.out.println("deletion distance for '' and 'me' is: " + deletionDistance("", "me"));
	}

	private static int deletionDistance(String s1, String s2) {
		return s1.length() + s2.length() - 2 * longestCommonSubsequence(s1, s2);
	}

	private static int longestCommonSubsequence(String s1, String s2) {
		int m = s1.length() + 1, n = s2.length() + 1;
		int[][] lcs = new int[m][n];
		for (int k = 0; k < m + n - 1; k++) {
			for (int i = Math.min(k, m - 1); i >= 0; i--) {
				for (int j = k - i; j <= Math.min(k, n - 1); j++) {
					if (i > 0 && j > 0 && s1.charAt(i - 1) == s2.charAt(j - 1)) {
						lcs[i][j] = getValue(lcs, i - 1, j - 1) + 1;
					} else {
						lcs[i][j] = Math.max(
								getValue(lcs, i, j - 1), 
								getValue(lcs, i - 1, j)
							);						
					}
				}
			}
		}
		// printLcs(lcs);
		return lcs[m-1][n-1];
	}

	private static void printLcs(int[][] lcs) {
		for (int i = 0; i < lcs.length; i++) {
			System.out.println(Arrays.toString(lcs[i]));
		}
	}

	private static int getValue(int[][] lcs, int i, int j) {
		if (i >= 0 && j >= 0) {
			return lcs[i][j];
		}
		return 0;
	}

}