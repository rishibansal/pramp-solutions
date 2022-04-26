import java.io.*;
import java.util.*;

public class ShortestCellPath {
	
	public static void main(String[] args) {
		int[][] grid = new int[][] {
      		{1, 1, 1, 1}, 
      		{0, 0, 0, 1}, 
      		{1, 1, 1, 1}
    	};
    	System.out.println(shortestCellPath(grid, 0, 0, 2, 0));
	}

	private static int shortestCellPath(int[][] grid, int sr, int sc, int tr, int tc) {
        int limit_x = grid.length - 1, limit_y = grid[0].length - 1;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int[][] moves = new int[][]{
        	{0, 1}, 
        	{-1, 0}, 
        	{0, -1}, 
        	{1, 0}
        };

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{sr, sc});
        queue.add(new int[]{-1, -1});
        int depth = 0;
        while (!queue.isEmpty()) {
            int[] next = queue.poll();
            if (next[0] == tr && next[1] == tc) {
                return depth;
            }
            if (isDummy(next)) {
                depth++;
                queue.add(next);
            } else {
                visited[next[0]][next[1]] = true;
                for (int i = 0; i < moves.length; i++) {
                	int next_x = next[0] + moves[i][0];
                	int next_y = next[1] + moves[i][1];
                	if (isValid(next_x, next_y, limit_x, limit_y, visited, grid)) {
                		queue.add(new int[]{next_x, next_y});
                	}
                }                
            }
        }
        return -1;
	}

	private static boolean isDummy(int[] tuple) {
		return tuple[0] == -1 && tuple[1] == -1;
	}

    private static boolean isValid(int x, int y, int limit_x, int limit_y, boolean[][] visited, int[][] grid) {
        return x >= 0 && x <= limit_x && y >= 0 && y <= limit_y && !visited[x][y] && grid[x][y] != 0;
    }

    /*private static class Tuple {
        int x;
        int y;

        Tuple(int x, int y) {
            this.x = x;
            this.y = y;
        }

        boolean isDummy() {
            return x == -1 && y == -1;
        }
    }*/
}