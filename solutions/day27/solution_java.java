/* 
 *  Count Square Submatrices with All Ones
 * 
 * Given a m * n matrix of ones and zeros, return how many square submatrices have all ones.
 * Example 1:
 * Input: matrix =
[
  [0,1,1,1],
  [1,1,1,1],
  [0,1,1,1]
]
Output: 15
Explanation: 
There are 10 squares of side 1.
There are 4 squares of side 2.
There is  1 square of side 3.
Total number of squares = 10 + 4 + 1 = 15.
 */

class Solution {
    public int countSquares(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        int totalSquares = 0;
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // if current cell in matrix is 1, proceed
                if (matrix[i][j] == 1) {
                    if (i == 0 || j == 0) {

                        // base case for first row / first column
                        dp[i][j] = 1;
                    } else {
                        // calculate size of largest square ending at (i, j)
                        dp[i][j] = Math.min(dp[i-1][j], Math.min(dp[i][j-1], dp[i-1][j-1])) + 1;
                    }
                    totalSquares += dp[i][j]; // total count of squares
                }
            }
        }
        
        return totalSquares;
    }
}