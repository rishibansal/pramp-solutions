import java.io.*;
import java.util.*;

public class PancakeSort {
	
	private static int[] pancakeSort(int[] arr) {
        for (int i = arr.length - 1; i >= 0; i--) {
            int maxIndex = getMaxIndex(arr, i);
            flip(arr, 0, maxIndex);
            flip(arr, 0, i);
        }
        return arr;
    }

    private static int getMaxIndex(int[] arr, int high) {
        int max = arr[0], maxIndex = 0;
        for (int i = 1; i <= high; i++) {
            if (max < arr[i]) {
                max = arr[i];
                maxIndex = i;
            }
        }
        return maxIndex;
    }

    private static void flip(int[] arr, int low, int high) {
        while (low <= high) {
            int temp = arr[low];
            arr[low] = arr[high];
            arr[high] = temp;
            low++;
            high--;
        }
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(pancakeSort(new int[]{1, 5, 4, 3, 2})));
        System.out.println(Arrays.toString(pancakeSort(new int[0])));
        System.out.println(Arrays.toString(pancakeSort(new int[]{0, 1, 1, 5, 2})));
    }
}
