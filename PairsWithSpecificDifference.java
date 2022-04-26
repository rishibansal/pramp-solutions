import java.io.*;
import java.util.*;

public class PairsWithSpecificDifference {

    static int[][] findPairsWithGivenDifference(int[] arr, int k) {
        Set<Integer> dict = new HashSet<>(arr.length);
        for (int i = 0; i < arr.length; i++) {
            dict.add(arr[i]);
        }
        List<int[]> output = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (dict.contains(arr[i] + k)) {
                output.add(new int[]{arr[i] + k, arr[i]});
            }
        }
        return output.toArray(new int[][]{});
    }

    static void print(int[][] output) {
        for (int i = 0; i < output.length; i++) {
            System.out.print(Arrays.toString(output[i]) + ", ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        print(findPairsWithGivenDifference(new int[]{0, -1, -2, 2, 1}, 1));
        print(findPairsWithGivenDifference(new int[]{1, 7, 5, 3, 32, 17, 12}, 17));
    }
}
