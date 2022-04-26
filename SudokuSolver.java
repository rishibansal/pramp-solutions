import java.io.*;
import java.util.*;

public class SudokuSolver {
	
	public static void main(String[] args) {
		char[][] board = new char[][]{
			{'5', '3', '.', '.', '7', '.', '.', '.', '.'}, 
			{'6', '.', '.', '1', '9', '5', '.', '.', '.'}, 
			{'.', '9', '8', '.', '.', '.', '.', '6', '.'}, 
			{'8', '.', '.', '.', '6', '.', '.', '.', '3'}, 
			{'4', '.', '.', '8', '.', '3', '.', '.', '1'}, 
			{'7', '.', '.', '.', '2', '.', '.', '.', '6'}, 
			{'.', '6', '.', '.', '.', '.', '2', '8', '.'}, 
			{'.', '.', '.', '4', '1', '9', '.', '.', '5'}, 
			{'.', '.', '.', '.', '8', '.', '.', '7', '9'}
		};
		boolean solvable = sudokuSolve(board);
		System.out.println("solvable: " + solvable);
		if (solvable) {
			printBoard(board);
		}
	}

	private static boolean sudokuSolve(char[][] board) {
		return sudokuSolve(board, 0, 0);
	}

	private static boolean sudokuSolve(char[][] board, int start_i, int start_j) {
		int next_i = -1, next_j = -1;
		boolean nextFound = false;
		for (int i = start_i; i < board.length; i++) {
			for (int j = start_j; j < board[i].length; j++) {
				if (board[i][j] == '.') {
					next_i = i;
					next_j = j;
					nextFound = true;
					break;
				}
			}
			if (nextFound) {
				break;
			}
			start_j = 0;
		}
		if (nextFound) {
			char[] possibleValues = possibleValues(board, next_i, next_j);
			if (possibleValues.length == 0) {
				return false;
		    }
			for (int k = 0; k < possibleValues.length; k++) {
		        board[next_i][next_j] = possibleValues[k];
		        int[] nextPosition = nextPosition(board, next_i, next_j);
		        boolean solved = sudokuSolve(board, nextPosition[0], nextPosition[1]);
		        if (solved) {
		            return true;
		        }
		    }
			board[next_i][next_j] = '.';
		    return false;
		}
		return true;
	}

	private static void printBoard(char[][] board) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
	}

	private static char[] possibleValues(char[][] board, int i, int j) {
        Set<Character> taken = new HashSet<>();
        // traverse the row
        for (int k = 0; k < board[i].length; k++) {
            if (board[i][k] != '.') {
                taken.add(board[i][k]);
            }
        }
        // traverse the column
        for (int k = 0; k < board.length; k++) {
            if (board[k][j] != '.') {
                taken.add(board[k][j]);
            }
        }
        // traverse the square
        int box_i = i / 3, box_j = j / 3;
        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                if (board[box_i * 3 + x][box_j * 3 + y] != '.') {
                    taken.add(board[box_i * 3 + x][box_j * 3 + y]);
                }
            }
        }
        char[] output = new char[9 - taken.size()];
        int q = 0;
        for (char p = '1'; p <= '9'; p++) {
            if (!taken.contains(p)) {
                output[q++] = p;
            }
        }
        return output;
    }

    private static int[] nextPosition(char[][] board, int i, int j) {
    	int width = board.length;
    	int curr = i * width + j;
    	curr++;
    	return new int[]{curr / width, curr % width};
    }
}