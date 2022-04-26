import java.io.*;
import java.util.*;

public class TimePlanner {
	
	public static void main(String[] args) {
        int[][] slotsA = new int[][]{
            {10, 50}, {60, 120}, {140, 210}
        };
        int[][] slotsB = new int[][]{
            {0, 15}, {60, 70}, 
        };
        System.out.println(Arrays.toString(meetingPlanner(slotsA, slotsB, 8)));
        System.out.println(Arrays.toString(meetingPlanner(slotsA, slotsB, 12)));
    }

    private static int[] meetingPlanner(int[][] slotsA, int[][] slotsB, int dur) {
        int i = 0, j = 0;
        while (i < slotsA.length && j < slotsB.length) {
            int overlapLength = getOverlapLength(slotsA[i], slotsB[j]);
            if (overlapLength >= dur) {
                return new int[]{Math.max(slotsA[i][0], slotsB[j][0]), Math.max(slotsA[i][0], slotsB[j][0]) + dur};
            } else {
                if (slotsA[i][1] < slotsB[j][1]) {
                    i++;
                } else {
                    j++;
                }
            }
        }
        return new int[]{};
    }

    private static int getOverlapLength(int[] slotA, int[] slotB) {
        int startA = slotA[0], endA = slotA[1], startB = slotB[0], endB = slotB[1];
        if ((startA >= startB && startA <= endB) || (startB >= startA && startB <= endA)) {
            return Math.min(endA, endB) - Math.max(startA, startB);
        }
        return 0;
    }
}