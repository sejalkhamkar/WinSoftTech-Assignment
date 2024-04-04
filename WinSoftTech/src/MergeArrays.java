/*Q1: Merge two arrays by satisfying given constraints
Given two sorted arrays X[] and Y[] of size m and n each where m >= n and X[] has exactly n vacant cells,
 merge elements of Y[] in their correct position in array X[], i.e., merge (X, Y) by keeping the sorted order.

For example,

Input: X[] = { 0, 2, 0, 3, 0, 5, 6, 0, 0 }
Y[] = { 1, 8, 9, 10, 15 } The vacant cells in X[] is represented by 0 
Output: X[] = { 1, 2, 3, 5, 6, 8, 9, 10, 15 }*/

import java.util.Arrays;

public class MergeArrays {
    
    // Function to merge two sorted arrays X and Y
    // assuming X has vacant cells represented by 0
    public static void mergeArrays(int[] X, int[] Y) {
        int m = X.length;
        int n = Y.length;
        
        // Move non-zero elements of X to the end
        int j = m - 1;
        for (int i = m - 1; i >= 0; i--) {
            if (X[i] != 0) {
                X[j] = X[i];
                j--;
            }
        }
        
        // Merge X and Y
        int k = 0;
        int i = j + 1;
        int l = 0;
        while (l < n && i < m) {
            if (X[i] < Y[l]) {
                X[k++] = X[i++];
            } else {
                X[k++] = Y[l++];
            }
        }
        
        // If elements in Y are remaining, copy them to X
        while (l < n) {
            X[k++] = Y[l++];
        }
    }

    public static void main(String[] args) {
        int[] X = { 0, 2, 0, 3, 0, 5, 6, 0, 0 };
        int[] Y = { 1, 8, 9, 10, 15 };
        
        mergeArrays(X, Y);
        
        System.out.println("Merged array: " + Arrays.toString(X));
    }
}
