/*Q2:Find maximum sum path involving elements of given arrays
Given two sorted arrays of integers, find a maximum sum path involving elements of both arrays whose sum is maximum. 
We can start from either array, but we can switch between arrays only through its common elements.

For example,

Input: X = { 3, 6, 7, 8, 10, 12, 15, 18, 100 }
Y = { 1, 2, 3, 5, 7, 9, 10, 11, 15, 16, 18, 25, 50 }  
The maximum sum path is: 1 —> 2 —> 3 —> 6 —> 7 —> 9 —> 10 —> 12 —> 15 —> 16 —> 18 —> 100 
The maximum sum is 199
*/

public class MaximumSumPath {
    
    // Function to find the maximum sum path
    public static int maxSumPath(int[] X, int[] Y) {
        int m = X.length;
        int n = Y.length;
        
        int sumX = 0, sumY = 0, result = 0;
        int i = 0, j = 0;
        
        // Traverse both arrays
        while (i < m && j < n) {
            // If current elements of both arrays are same
            if (X[i] == Y[j]) {
                // Add maximum of current sum of X and Y to result
                result += Math.max(sumX, sumY) + X[i];
                
                // Reset sumX and sumY for next common element
                sumX = 0;
                sumY = 0;
                
                // Move to next elements in both arrays
                i++;
                j++;
            } else if (X[i] < Y[j]) {
                // If current element of X is smaller, add it to sumX
                sumX += X[i++];
            } else {
                // If current element of Y is smaller, add it to sumY
                sumY += Y[j++];
            }
        }
        
        // Add remaining elements of X, if any
        while (i < m) {
            sumX += X[i++];
        }
        
        // Add remaining elements of Y, if any
        while (j < n) {
            sumY += Y[j++];
        }
        
        // Add the maximum of remaining sums to the result
        result += Math.max(sumX, sumY);
        
        return result;
    }

    public static void main(String[] args) {
        int[] X = { 3, 6, 7, 8, 10, 12, 15, 18, 100 };
        int[] Y = { 1, 2, 3, 5, 7, 9, 10, 11, 15, 16, 18, 25, 50 };

        int maxSum = maxSumPath(X, Y);
        System.out.println("Maximum sum path: " + maxSum);
    }
}
