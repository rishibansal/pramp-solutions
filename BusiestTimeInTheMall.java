import java.io.*;
import java.util.*;

public class BusiestTimeInTheMall {
	
    private static int findBusiestPeriod(int[][] data) {
        int count = 0, maxCount = 0, maxTime = 0;
        int prevTime = data[0][0];
        int prevCount = data[0][2] == 1 ? data[0][1] : -data[0][1];
        for (int i = 1; i < data.length; i++) {
            if (prevTime == data[i][0]) {
                prevCount += data[i][2] == 1 ? data[i][1] : -data[i][1];
            } else {
                count += prevCount;
                if (maxCount < count) {
                    maxCount = count;
                    maxTime = prevTime;
                }
                prevTime = data[i][0];
                prevCount = data[i][2] == 1 ? data[i][1] : -data[i][1];
            }
        }
        count += prevCount;
        if (maxCount < count) {
            maxCount = count;
            maxTime = prevTime;
        }
        return maxTime;
    }

    public static void main(String[] args) {
        int[][] data = new int[][] {
                {1487799425, 14, 1},
                {1487799425, 4,  0},
                {1487799425, 2,  0},
                {1487800378, 10, 1},
                {1487801478, 18, 0},
                {1487801478, 18, 1},
                {1487901013, 1,  0},
                {1487901211, 7,  1},
                {1487901211, 7,  0}
        };
        System.out.println("busiest time in the mall: " + findBusiestPeriod(data));
    }
}
