import java.io.*;
import java.util.*;

public class ArrayQuadruplet {
	
	public static void main(String[] args) {
		System.out.println(Arrays.toString(findArrayQuadruplet(new int[]{2, 7, 4, 0, 9, 5, 1, 3}, 20)));
		System.out.println(Arrays.toString(findArrayQuadruplet(new int[]{2, 7, 4}, 20)));
		System.out.println(Arrays.toString(findArrayQuadruplet(new int[]{}, 20)));
	}

	private static int[] findArrayQuadruplet(int[] arr, int s) {
		Arrays.sort(arr);
		// System.out.println(Arrays.toString(arr));
		int i = 0, j = arr.length - 1;
		while (i < j - 2) {
			int partialSum = arr[i] + arr[j];
			int remainingSum = s - partialSum;
			int p = i + 1, q = j - 1;
			while (p < q) {
				int nextPartialSum = arr[p] + arr[q];
				if (nextPartialSum == remainingSum) {
					// System.out.println("i=" + i + ",p=" + p + ",q=" + q + ",j=" + j);
					return new int[]{arr[i], arr[p], arr[q], arr[j]};
				} else if (nextPartialSum < remainingSum) {
					p++;
				} else {
					q--;
				}
			}
			if (q == j - 1) {
				// System.out.println("i=" + i + ",p=" + p + ",q=" + q + ",j=" + j + ", decreasing j");
				j--;
			} else {
				// System.out.println("i=" + i + ",p=" + p + ",q=" + q + ",j=" + j + ", increasing i");
				i++;
			}
		}
		return new int[0];
	}
}