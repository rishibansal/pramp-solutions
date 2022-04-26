import java.io.*;
import java.util.*;

public class NumberOfPaths {
	
	private static int numOfPathsToDest(int n) {
        return pathsToIAndJ(n - 1, n - 1);
    }

    private static int pathsToIAndJ(int i, int j) {
        if (i == 0 && j == 0) {
            return 1;
        } else if (j == 0) {
            return pathsToIAndJ(i - 1, j);
        } else if (i == j) {
            return pathsToIAndJ(i, j - 1);
        } else {
            return pathsToIAndJ(i - 1, j) + pathsToIAndJ(i, j - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println("1: " + numOfPathsToDest(1));
        System.out.println("2: " + numOfPathsToDest(2));
        System.out.println("3: " + numOfPathsToDest(3));
        System.out.println("4: " + numOfPathsToDest(4));
        System.out.println("5: " + numOfPathsToDest(5));
        System.out.println("6: " + numOfPathsToDest(6));
    }
}
