import java.io.*;
import java.util.*;

public class BracketMatch {

    public static void main(String[] args) {
        System.out.println("input: (()      output: " + bracketMatch("(()"));
        System.out.println("input: (())     output: " + bracketMatch("(())"));
        System.out.println("input: ())(     output: " + bracketMatch("())("));
    }

    private static int bracketMatch(String text) {
        int count = 0, supp = 0;
        char[] input = text.toCharArray();
        for (int i = 0; i < input.length; i++) {
            if (input[i] == '(') {
                count++;
            } else if (input[i] == ')') {
                count--;
                if (count < 0) {
                    supp++;
                    count = 0;
                }
            } else {
                System.out.println("Bad input text: " + text);
                return -1;
            }
        }
        return count + supp;
    }
}