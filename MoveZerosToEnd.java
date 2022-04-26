import java.io.*;
import java.util.*;

public class MoveZerosToEnd {

	private static int[] moveZerosToEnd(int[] arr) {
        int i = 0, j = 0;
        while (i < arr.length) {
            if (arr[i] != 0) {
                arr[j] = arr[i];
                j++;
            }
            i++;
        }
        while (j < arr.length) {
            arr[j++] = 0;
        }
        return arr;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(moveZerosToEnd(new int[]{1, 10, 0, 2, 8, 3, 0, 0, 6, 4, 0, 5, 7, 0})));
        System.out.println(Arrays.toString(moveZerosToEnd(new int[]{})));
    }
}
