import java.io.*;
import java.util.*;

public class RootOfNumber {
	
	private static double root(double x, int n) {
        double low, high;
        if (x < 1) {
            low = 0;
            high = 1;
        } else {
            low = 1;
            high = x;
        }
        double mid = (low + high) / 2;
        double midPower = power(mid, n);
        while (abs(midPower - x) >= 0.000001) {
            if (midPower > x) {
                high = mid;
            } else {
                low = mid;
            }
            mid = (low + high) / 2;
            midPower = power(mid, n);
        }
        return mid;
    }

    private static double power(double x, int n) {
        if (n == 0) return 1;
        if (n == 1) return x;
        double mid = power(x, n / 2);
        if (n % 2 == 0) {
        	return mid * mid;
        } else {
        	return x * mid * mid;
        }
    }

    private static double abs(double x) {
        return x < 0 ? -x : x;
    }

    public static void main(String[] args) {
        System.out.println(root(7, 3));
        System.out.println(root(9, 2));
    }
}
