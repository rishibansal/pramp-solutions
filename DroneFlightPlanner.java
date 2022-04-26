import java.io.*;
import java.util.*;

public class DroneFlightPlanner {
	
	public static void main(String[] args) {
		int[][] route = new int[][]{ 
				{0,   2, 10},
                {3,   5,  0},
                {9,  20,  6},
                {10, 12, 15},
                {10, 10,  8} };
        System.out.println("min energy: " + calcDroneMinEnergy(route));
	}

	private static int calcDroneMinEnergy(int[][] route) {
		if (route.length < 2) {
			return 0;
		}
		int min = 0, curr = 0;
		for (int i = 1; i < route.length; i++) {
			curr = curr + route[i-1][2] - route[i][2];
			if (curr < min) {
				min = curr;
			}
		}
		return -1 * min;
	}
}