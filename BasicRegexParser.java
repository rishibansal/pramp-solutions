import java.io.*;
import java.util.*;

public class BasicRegexParser {

	private static boolean isMatch(String text, String pattern) {
		// System.out.println("text=" + text + ", pattern=" + pattern);
		if (text.length() == 0 && pattern.length() == 0) {
			return true;
		} else if (text.length() == 0) {
			if (pattern.length() > 1 && pattern.charAt(1) == '*') {
				return isMatch(text, pattern.substring(2));
			} else {
				return false;
			}
		} else if (pattern.length() == 0) {
			return false;
		} else if (pattern.length() > 1 && pattern.charAt(1) == '*') {
			if (text.charAt(0) == pattern.charAt(0) ||
				pattern.charAt(0) == '.') {
				return isMatch(text.substring(1),  pattern) ||
					isMatch(text, pattern.substring(2));
			} else {
				return isMatch(text, pattern.substring(2));
			}
		} else if (text.charAt(0) == pattern.charAt(0) ||
				pattern.charAt(0) == '.') {
			return isMatch(text.substring(1), pattern.substring(1));
		} else {
			return false;
		}
	}

	public static void main(String[] args) {
		System.out.println(isMatch("aa", "a"));
		System.out.println(isMatch("aa", "aa"));
		System.out.println(isMatch("abc", "a.c"));
		System.out.println(isMatch("abbb", "ab*"));
		System.out.println(isMatch("acd", "ab*c."));
		System.out.println(isMatch("abaa", "a.*a*"));
	}
}
