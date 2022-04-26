import java.io.*;
import java.util.*;

public class SentenceReverse {
	
	public static void main(String[] args) {
		char[] arr = new char[]{'p', 'e', 'r', 'f', 'e', 'c', 't', ' ', ' ',
								'm', 'a', 'k', 'e', 's', ' ', 
								'p', 'r', 'a', 'c', 't', 'i', 'c', 'e'};
		System.out.println("original sentence: " + Arrays.toString(arr));
		System.out.println("reversed sentence: " + Arrays.toString(reverseSentence(arr)));
	}

	private static char[] reverseSentence(char[] arr) {
		char[] output = new char[arr.length];
		int start = 0, i = 0, end = output.length - 1;
		while (start < arr.length) {
			//find next whitespace character
			while (i < arr.length && arr[i] != ' ') {
				i++;
			}
			int length = i - start;
			int j = end - length + 1;
			while (j <= end) {
				output[j++] = arr[start++];
			}
			end = end - length;
			//find next non whitespace character
			while (i < arr.length && arr[i] == ' ') {
				output[end--] = arr[i++];
			}
			start = i;
		}
		return output;
	}
}
