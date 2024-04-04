/* Q2:Find maximum sum path involving elements of given arrays
Given two sorted arrays of integers, find a maximum sum path involving elements of both arrays whose sum is maximum. 
We can start from either array, but we can switch between arrays only through its common elements.

For example,

Input: X = { 3, 6, 7, 8, 10, 12, 15, 18, 100 }
Y = { 1, 2, 3, 5, 7, 9, 10, 11, 15, 16, 18, 25, 50 }  
The maximum sum path is: 1 —> 2 —> 3 —> 6 —> 7 —> 9 —> 10 —> 12 —> 15 —> 16 —> 18 —> 100 
The maximum sum is 199 */

import java.util.ArrayList;
import java.util.List;

public class Q2_MaxSumPath {
    public static int maxSumPath(List<Integer> X, List<Integer> Y) {
        int sumX = 0, sumY = 0, result = 0;
        int i = 0, j = 0;
        int m = X.size(), n = Y.size();

        while (i < m && j < n) {
            if (X.get(i) < Y.get(j))
                sumX += X.get(i++);
            else if (X.get(i) > Y.get(j))
                sumY += Y.get(j++);
            else {
                result += Math.max(sumX, sumY) + X.get(i);
                sumX = 0;
                sumY = 0;
                i++;
                j++;
            }
        }

        // Add remaining elements of X
        while (i < m)
            sumX += X.get(i++);

        // Add remaining elements of Y
        while (j < n)
            sumY += Y.get(j++);

        result += Math.max(sumX, sumY);

        return result;
    }

    public static void main(String[] args) {
        List<Integer> X = new ArrayList<>(List.of(3, 6, 7, 8, 10, 12, 15, 18, 100));
        List<Integer> Y = new ArrayList<>(List.of(1, 2, 3, 5, 7, 9, 10, 11, 15, 16, 18, 25, 50));

        int maxSum = maxSumPath(X, Y);

        System.out.println("Maximum sum path is: " + maxSum);
    }
}