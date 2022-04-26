import java.io.*;
import java.util.*;

public class DiffBetweenTwoStrings {

	public static void main(String[] args) {
		System.out.println("source=ABCDEFG, target=ABDFFGH, answer=" + Arrays.toString(diffBetweenTwoStrings("ABCDEFG", "ABDFFGH")));
	}

	private static String[] diffBetweenTwoStrings(String source, String target) {
		int[][] minArrLen = new int[source.length()+1][target.length()+1];
		char[][] minArrDir = new char[source.length()+1][target.length()+1];
		for (int i = 0; i < minArrLen.length; i++) {
			for (int j = 0; j < minArrLen[i].length; j++) {
				if (i == 0 && j == 0) {
					minArrLen[i][j] = 0;
				} else if (i == 0) {
					minArrLen[i][j] = j;
					minArrDir[i][j] = 'l';
				} else if (j == 0) {
					minArrLen[i][j] = i;
					minArrDir[i][j] = 'u';
				} else {
					if (source.charAt(i - 1) == target.charAt(j - 1)) {
						minArrLen[i][j] = minArrLen[i-1][j-1] + 1;
						minArrDir[i][j] = 'd';
					} else {
						int len = minArrLen[i][j-1] + 1; //left
						char dir = 'l';
						if (len > minArrLen[i-1][j] + 1) {
							len = minArrLen[i-1][j] + 1;
							dir = 'u';
						}
						minArrLen[i][j] = len;
						minArrDir[i][j] = dir;
					}
				}
			}
		}
		// printMinArrLen(minArrLen);
		// printMinArrDir(minArrDir);
		String[] output = new String[minArrLen[source.length()][target.length()]];
		int k = output.length - 1;
		int curr_i = source.length(), curr_j = target.length();
		while (!(curr_i == 0 && curr_j == 0)) {
			char dir = minArrDir[curr_i][curr_j];
			if (dir == 'u') {
				output[k] = "-" + source.charAt(curr_i - 1);
				curr_i--;
			} else if (dir == 'l') {
				output[k] = "+" + target.charAt(curr_j - 1);
				curr_j--;
			} else {
				output[k] = "" + source.charAt(curr_i - 1);
				curr_i--;
				curr_j--;
			}
			k--;
		}
		return output;		
	}

	private static void printMinArrLen(int[][] minArrLen) {
		for (int i = 0; i < minArrLen.length; i++) {
			for (int j = 0; j < minArrLen[i].length; j++) {
				System.out.print(minArrLen[i][j] + ", ");
			}
			System.out.println();
		}		
	}

	private static void printMinArrDir(char[][] minArrDir) {
		for (int i = 0; i < minArrDir.length; i++) {
			for (int j = 0; j < minArrDir[i].length; j++) {
				System.out.print(minArrDir[i][j] + ", ");
			}
			System.out.println();
		}		
	}

}
