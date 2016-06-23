/*
329. Longest Increasing Path in a Matrix 

Given an integer matrix, find the length of the longest increasing path.

From each cell, you can either move to four directions: 
left, right, up or down. You may NOT move diagonally or move 
outside of the boundary (i.e. wrap-around is not allowed).

Example 1:

nums = [
  [9,9,4],   [1,1,2]
  [6,6,8],	 [2,2,1]
  [2,1,1]	 [3,4,2]
]
Return 4
The longest increasing path is [1, 2, 6, 9].

Example 2:

nums = [
  [3,4,5],
  [3,2,6],
  [2,2,1]
]
Return 4
The longest increasing path is [3, 4, 5, 6]. 
Moving diagonally is not allowed.
*/
/*
	DP dynamic memory search: define dp array, dp[i][j] representing the longest increasing path at [i,j]
							Plese be sure to set the value in the helper function. 
	Time Complexity: O(m*n)

*/
`public class Solution {
    public int longestIncreasingPath(int[][] matrix) {
    	if (matrix == null || matrix.length == 0) {
    		return 0;
    	}
        int[][] dp = new int[matrix.length][matrix[0].length];
        int max = 0;
        for (int i = 0; i < matrix.length; i++) {
        	for( int j = 0; j < matrix[i].length; j++ ) {
        		helper(matrix, dp, i, j);
        		max = Math.max(max, dp[i][j]);
        	}
        }
        return max;
    }

    public int helper(int[][] matrix, int[][] dp, int i, int j ) { //search for longest increasing path for i j
    	if(dp[i][j] != 0)
    		return dp[i][j];
    	int max = 0;
    	if(i > 0 && matrix[i - 1][j] > matrix[i][j])
    		max = Math.max(max, helper(matrix, dp , i - 1, j));
    	if(i < matrix.length - 1 && matrix[i + 1][j] > matrix[i][j])
    		max = Math.max(max, helper(matrix, dp , i + 1, j));
    	if(j > 0 && matrix[i][j - 1] > matrix[i][j])
    		max = Math.max(max, helper(matrix, dp , i, j - 1));
    	if(j < matrix[i].length - 1 && matrix[i][j + 1] > matrix[i][j])
    		max = Math.max(max, helper(matrix, dp , i, j + 1));
    	dp[i][j] = max + 1;// it is very important to set the value here, otherwise will run too slow.
    	return max + 1;
    }
}