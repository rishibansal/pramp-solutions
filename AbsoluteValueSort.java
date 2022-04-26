import java.io.*;
import java.util.*;

public class AbsoluteValueSort {

	private static int[] absSort(int[] arr) {
        if (arr.length == 0) {
            return arr;
        }
        return sort(arr, 0, arr.length - 1);
    }

    private static int[] sort(int[] arr, int low, int high) {
        if (low == high) {
            return new int[]{ arr[low] };
        }
        int mid = (low + high) / 2;
        int[] left = sort(arr, low, mid);
        int[] right = sort(arr, mid + 1, high);
        return merge(left, right);
    }

    private static int[] merge(int[] left, int[] right) {
        int l = left.length, r = right.length;
        int[] output = new int[l + r];
        int i = 0, j = 0, k = 0;
        while (i < l && j < r) {
            if (Math.abs(left[i]) < Math.abs(right[j])) {
                output[k++] = left[i++];
            } else if (Math.abs(right[j]) < Math.abs(left[i])) {
                output[k++] = right[j++];
            } else {
                if (left[i] < right[j]) {
                    output[k++] = left[i++];
                } else {
                    output[k++] = right[j++];
                }
            }
        }
        while (i < l) {
            output[k++] = left[i++];
        }
        while (j < r) {
            output[k++] = right[j++];
        }
        return output;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(absSort(new int[]{2, -7, -2, -2, 0})));
        System.out.println(Arrays.toString(absSort(new int[]{})));
    }
}
