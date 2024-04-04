/*Q1: Merge two arrays by satisfying given constraints
Given two sorted arrays X[] and Y[] of size m and n each where m >= n and X[] has exactly n vacant cells,
 merge elements of Y[] in their correct position in array X[], i.e., merge (X, Y) by keeping the sorted order.

For example,

Input: X[] = { 0, 2, 0, 3, 0, 5, 6, 0, 0 }
Y[] = { 1, 8, 9, 10, 15 } The vacant cells in X[] is represented by 0 
Output: X[] = { 1, 2, 3, 5, 6, 8, 9, 10, 15 }


expected output - 1 2 3 5 6 8 9 10 15   */

import java.util.ArrayList;
import java.util.List;

public class Q1_MergeArrays {
    public static void mergeArray(List<Integer> x, List<Integer> y) {
        int m = x.size() - 1;
        int n = y.size() - 1;

        // Move all non-zero elements of X to the end
        int k = 0;
        for (int i = 0; i <= m; i++) {
            if (x.get(i) != 0) {
                x.set(k++, x.get(i));
            }
        }
        int i = k - 1; // index of last non-zero element
        while (k <= m) {
            x.set(k++, 0);
        }
        while (n >= 0) {
            if (m > 0 && x.get(i) > y.get(n)) {
                x.set(m--, x.get(i--));
            } else {
                x.set(m--, y.get(n--));
            }
        }
    }

    public static void print(List<Integer> x) {
        for (int e : x) {
            System.out.print(e + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        List<Integer> x = new ArrayList<>(List.of(0, 2, 0, 3, 0, 5, 6, 0, 0));
        List<Integer> y = new ArrayList<>(List.of(1, 8, 9, 10, 15));
        mergeArray(x, y);
        print(x);
    }
}