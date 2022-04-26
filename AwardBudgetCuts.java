import java.io.*;
import java.util.*;

public class AwardBudgetCuts {

	private static double findGrantsCap(double[] grantsArray, double newBudget) {
        Arrays.sort(grantsArray); // 2, 50, 100, 120, 1000
        double[] sumArray = new double[grantsArray.length];
        double sum = 0;
        for (int i = 0; i < grantsArray.length; i++) {
            sum += grantsArray[i];
            sumArray[i] = sum;
        } // 2, 52, 152, 272, 1272
        int capPos = sumArray.length; // 5
        if (newBudget >= sumArray[capPos - 1]) {
        	return grantsArray[capPos - 1];
        }
        while (capPos > 0) {
            if (sumArray[capPos - 1] + grantsArray[capPos - 1] * (grantsArray.length - capPos) > newBudget) {
                capPos--;
            } else {
                return (newBudget - sumArray[capPos - 1]) / (grantsArray.length - capPos);
            }
        }
        return newBudget / grantsArray.length;
    }

    public static void main(String[] args) {
        double[] grantsArray = new double[]{2, 100, 50, 120, 1000};
        System.out.println(findGrantsCap(grantsArray, 1273));
        System.out.println(findGrantsCap(grantsArray, 190));
        System.out.println(findGrantsCap(grantsArray, 5));
    }	
}
