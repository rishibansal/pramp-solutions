import java.io.*;
import java.util.*;

public class ToeplitzMatrix {

    private static boolean isToeplitz(int[][] arr) {
        for (int i = 1; i < arr.length; i++) {
            for (int j = 1; j < arr[i].length; j++) {
                if (arr[i][j] != arr[i-1][j-1]) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {1, 2, 3, 4},
                {5, 1, 2, 3},
                {6, 5, 1, 2}
        };
        System.out.println("is toeplitz matrix: " + isToeplitz(matrix));
    }
}
