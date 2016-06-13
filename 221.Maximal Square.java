/*
221. Maximal Square

Given a 2D binary matrix filled with 0's and 1's, find the largest square containing all 1's and return its area.

For example, given the following matrix:

1 0 1 0 0
1 0 1 1 1
1 1 1 1 1
1 0 0 1 0
Return 4.
*/
/*
	DP: use dp[i][j] to track, from current point to the left most part of the matrix(current point must be included),
		dp[i][j] is the maximum length of the edge of squre it can form.
		dp[i][j] = min(dp[i-1][j], dp[i][j-1], dp[i-1][j-1]) + 1
	Time O(m*n)
	Space O(m*n)  can be optimized to O(1)
*/
public class Solution {
    /**
     * @param matrix: a matrix of 0 and 1
     * @return: an integer
     */
    public int maxSquare(int[][] matrix) {
        // write your code here
        if(matrix == null || matrix.length == 0||matrix[0].length == 0)
            return 0;
        int[][] dp = new int[matrix.length][matrix[0].length];
        int max=0;
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[i].length; j++){
                if(i == 0 || j == 0)
                    dp[i][j] = matrix[i][j];
                else{
                    if(matrix[i][j] == 0)
                        dp[i][j] = 0;
                    else{
                        dp[i][j] = Math.min(Math.min(dp[i-1][j],dp[i][j-1]), dp[i-1][j-1]) + 1;
                    }
                }
                max = Math.max(max, dp[i][j]);
            }
        }
        return max*max;
    }
}