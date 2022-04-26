import java.io.*;
import java.util.*;

public class DecryptMessage {

    private static String decrypt(String word) {
        if (word.length() == 0) {
            return word;
        }
        char[] en = word.toCharArray();
        char[] de = new char[en.length];
        de[0] = makeValidChar((int)en[0] - 1);
        for (int i = 1; i < en.length; i++) {
            int m = (122 - ((int)en[i] - (int)en[i-1])) / 26;
            de[i] = makeValidChar(((int)en[i] - (int)en[i-1]) + m * 26);
        }
        return new String(de);
    }

    private static char makeValidChar(int num) {
        if (num > 122) {
            while (num > 122) {
                num = num - 26;
            }
        }
        if (num < 97) {
            while (num < 97) {
                num = num + 26;
            }
        }
        return (char) num;
    }

    public static void main(String[] args) {
        System.out.println(decrypt("dnotq"));
    }
}
