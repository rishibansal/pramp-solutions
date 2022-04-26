import java.io.*;
import java.util.*;

//Uber TPS Question
public class MergeKSortedArrays {
    public static void main(String[] args) {
        int[][] arrOfArr = new int[][]{
            {0, 1, 6}, 
            {2, 6, 7, 34, 56},
            {4, 6},
            {9, 21, 32, 43, 51, 64}
        };
        System.out.println(Arrays.toString(mergeKSortedArrays(arrOfArr)));
    }
    
    private static int[] mergeKSortedArrays(int[][] arrOfArr) {
        int m = arrOfArr.length;
        int[] indexes = new int[m];
        MyHeap heap = new MyHeap(m);
        for (int i = 0; i < m; i++) {
            heap.offer(new Tuple(arrOfArr[i][0], i));
        }
        int outputSize = 0;
        for (int i = 0; i < m; i++) {
            outputSize += arrOfArr[i].length;
        }
        int[] output = new int[outputSize];
        int j = 0;
        while (!heap.isEmpty()) {
            // System.out.println(heap);
            Tuple min = heap.poll();
            output[j++] = min.number;
            indexes[min.arrayIndex]++;
            if (indexes[min.arrayIndex] < arrOfArr[min.arrayIndex].length) {
                heap.offer(new Tuple(arrOfArr[min.arrayIndex][indexes[min.arrayIndex]], min.arrayIndex));
            }            
        }
        return output;
    }
    
    static class Tuple {
        int number;
        int arrayIndex;
        
        public Tuple(int number, int arrayIndex) {
            this.number = number;
            this.arrayIndex = arrayIndex;
        }
        
        public String toString() {
            return "Tuple(" + number + ", " + arrayIndex + ")";
        }
    }
    
    static class MyHeap {
        Tuple[] array;
        int size = 0;
        
        public MyHeap(int arraySize) {
            array = new Tuple[arraySize];
        }
        
        void offer(Tuple tup) {
            if (size == array.length) {
                throw new RuntimeException("heap is full!");
            }
            int curr = size;
            array[curr] = tup;
            while (curr != 0 && array[curr / 2].number > tup.number) {
                swap(curr / 2, curr);
                curr = curr / 2;
            }
            size++;
        }
        
        void swap(int left, int right) {
            Tuple temp = array[left];
            array[left] = array[right];
            array[right] = temp;
        }
        
        Tuple poll() {
            if (isEmpty()) {
                throw new RuntimeException("heap is empty!");
            }
            int last = size - 1;
            swap(0, last);
            int curr = 0;
            while (true) {
                if (2 * curr < last && array[2 * curr].number < array[curr].number) {
                    swap(curr, 2 * curr);
                    curr = 2 * curr;
                } else if (2 * curr + 1 < last && array[2 * curr + 1].number < array[curr].number) {
                    swap(curr, 2 * curr + 1);
                    curr = 2 * curr + 1;
                } else {
                    break;
                }
            }
            size--;
            return array[last];
        }
        
        boolean isEmpty() {
            return size == 0;
        }
        
        public String toString() {
            String output = "";
            for (int i = 0; i < size; i++) {
                output = output + array[i].toString() + ", ";
            }
            return output;
        }
    }
}
