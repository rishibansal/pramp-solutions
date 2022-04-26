import java.io.*;
import java.util.*;

public class IslandCount {

    public static void main(String[] args) {
        int[][] binaryMatrix = new int[][]{
                {0,    1,    0,    1,    0},
                {0,    0,    1,    1,    1},
                {1,    0,    0,    1,    0},
                {0,    1,    1,    0,    0},
                {1,    0,    1,    0,    1}
        };
        System.out.println(getNumberOfIslands(binaryMatrix));
    }

    private static int getNumberOfIslands(int[][] binaryMatrix) {
        if (binaryMatrix.length == 0) {
            return 0;
        }
        int[][] visited = new int[binaryMatrix.length][binaryMatrix[0].length];
        int count = 0;
        for (int i = 0; i < binaryMatrix.length; i++) {
            for (int j = 0; j < binaryMatrix[i].length; j++) {
                if (isValidMove(i, j, binaryMatrix, visited)) {
                    depthFirstSearch(i, j, binaryMatrix, visited, ++count);
                }
            }
        }
        return count;
    }

    private static void depthFirstSearch(int i, int j, int[][] binaryMatrix, int[][] visited, int islandNum) {
        visited[i][j] = islandNum;
        int[][] moves = new int[][]{
                {0, 1},
                {-1, 0},
                {0, -1},
                {1, 0}
        };
        for (int k = 0; k < moves.length; k++) {
            int next_i = i + moves[k][0];
            int next_j = j + moves[k][1];
            if (isValidMove(next_i, next_j, binaryMatrix, visited)) {
                depthFirstSearch(next_i, next_j, binaryMatrix, visited, islandNum);
            }
        }
    }

    private static boolean isValidMove(int i, int j, int[][] binaryMatrix, int[][] visited) {
        return i >= 0 && i <= binaryMatrix.length - 1 &&
                j >= 0 && j <= binaryMatrix[i].length - 1 &&
                binaryMatrix[i][j] == 1 &&
                visited[i][j] == 0;
    }

}

