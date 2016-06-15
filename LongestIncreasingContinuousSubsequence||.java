/*
	Longest Increasing Continuous subsequence II
	Give you an integer matrix (with row size n, column size m)，find the longest increasing continuous subsequence 
	in this matrix. (The definition of the longest increasing continuous subsequence here can start at any row or 
	column and go up/down/right/left any direction).


	Example
Given a matrix:

[
  [1 ,2 ,3 ,4 ,5],
  [16,17,24,23,6],
  [15,18,25,22,7],
  [14,19,20,21,8],
  [13,12,11,10,9]
]
return 25

*/

/*
	DP: dp array stores at each point, the longest increasing continuous subsequence.
		dynamically search for the next value. dynamic search meaning, search and store.
		when the value does not exist, search, after search store it in the array, if it 
		exists, then return.
	Time: O(mn)
	Space: O(mn)

*/


public class Solution {
    /**
     * @param A an integer matrix
     * @return  an integer
     */
    public int longestIncreasingContinuousSubsequenceII(int[][] A) {
        // Write your code here
        if(A == null || A.length == 0)
            return 0;
        int[][] dp = new int[A.length][A[0].length];
        int max = 0;
        for(int i = 0; i < A.length; i++)
            for(int j = 0; j < A[0].length ; j++)
                max = Math.max(max, search(A, dp, i, j));
        return max;
    }
    public int search(int[][] nums, int[][] dp, int i, int j){
        if(dp[i][j] != 0)
            return dp[i][j];
        int max = 0;
        if( i > 0 && nums[i-1][j] < nums[i][j])
            max = Math.max(search(nums, dp, i - 1, j), max);
        if( i < nums.length - 1 && nums[i+1][j] < nums[i][j])
            max = Math.max(search(nums, dp, i + 1, j), max);
        if( j < nums[0].length - 1 && nums[i][j+1] < nums[i][j])
            max = Math.max(search(nums, dp, i, j + 1), max);
        if( j > 0 && nums[i][j-1] < nums[i][j])
            max = Math.max(search(nums, dp, i, j - 1), max);
        dp[i][j] = max == 0? 1 : max + 1;
        return dp[i][j];
    }
}