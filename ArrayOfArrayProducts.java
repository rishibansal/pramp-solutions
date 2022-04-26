import java.io.*;
import java.util.*;

public class ArrayOfArrayProducts {
	
    private static int[] arrayOfArrayProducts(int[] arr) {
        if (arr.length == 1) {
            return new int[]{};
        }
        int[] leftPrefix = new int[arr.length];
        int leftVal = 1;
        for (int i = 0; i < arr.length; i++) { //[8, 80, 160]
            leftVal = leftVal * arr[i];
            leftPrefix[i] = leftVal;
        }
        int[] rightPrefix = new int[arr.length];
        int rightVal = 1;
        for (int i = arr.length - 1; i >= 0; i--) { //[160, 20, 2]
            rightVal = rightVal * arr[i];
            rightPrefix[i] = rightVal;
        }
        int[] output = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            int outputVal = 1;
            if (i - 1 >= 0) {
                outputVal = outputVal * leftPrefix[i - 1];
            }
            if (i + 1 <= arr.length - 1) {
                outputVal = outputVal * rightPrefix[i + 1];
            }
            output[i] = outputVal;
        }
        return output;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(arrayOfArrayProducts(new int[]{8, 10, 2})));
        System.out.println(Arrays.toString(arrayOfArrayProducts(new int[]{2, 7, 3, 4})));
        System.out.println(Arrays.toString(arrayOfArrayProducts(new int[]{1})));
    }
}