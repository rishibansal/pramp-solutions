import java.io.*;
import java.util.*;

public class MatrixSpiralCopy {

    private static int[] spiralCopy(int[][] inputMatrix) {
        int m = inputMatrix.length;
        int n = inputMatrix[0].length;
        int[] outputArray = new int[m * n];
        int k = 0;
        int p = 0;
        while (k < m / 2 && k < n / 2) {
            int i = k, j = k;
            while (j < n - k - 1) {
                outputArray[p++] = inputMatrix[i][j];
                j++;
            }
            while (i < m - k - 1) {
                outputArray[p++] = inputMatrix[i][j];
                i++;
            }
            while (j > k) {
                outputArray[p++] = inputMatrix[i][j];
                j--;
            }
            while (i > k) {
                outputArray[p++] = inputMatrix[i][j];
                i--;
            }
            k++;
        }
        if (p < outputArray.length) {
            int i = k, j = k;
            while (j < n - k) {
                outputArray[p++] = inputMatrix[i][j];
                j++;
            }
            i++;j--;
            while (i < m - k) {
                outputArray[p++] = inputMatrix[i][j];
                i++;
            } 
        }
        return outputArray;
    }

    public static void main(String[] args) {
        int[][] inputMatrix = new int[][]{
                {1, 2, 3, 4, 5},
                {6, 7, 8, 9, 10},
                {11, 12, 13, 14, 15},
                {16, 17, 18, 19, 20},
                {21, 22, 23, 24, 25}
        };
        System.out.println(Arrays.toString(spiralCopy(inputMatrix)));
        int[][] inputMatrix2 = new int[][]{
                {1, 2, 3, 4, 5}, 
                {6, 7, 8, 9, 10}, 
                {11, 12, 13, 14, 15}
        };
        System.out.println(Arrays.toString(spiralCopy(inputMatrix2)));
        int[][] inputMatrix3 = new int[][]{
                {1, 2, 3}, 
                {4, 5, 6}, 
                {7, 8, 9}, 
                {10, 11, 12}, 
                {13, 14, 15}
        };
        System.out.println(Arrays.toString(spiralCopy(inputMatrix3)));
    }
}
