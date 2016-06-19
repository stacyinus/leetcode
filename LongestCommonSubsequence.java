/*
Longest Common Subsequence

Given two strings, find the longest common subsequence (LCS).

Your code should return the length of LCS.

Clarification
What's the definition of Longest Common Subsequence?

https://en.wikipedia.org/wiki/Longest_common_subsequence_problem
http://baike.baidu.com/view/2020307.htm
Example
For "ABCD" and "EDCA", the LCS is "A" (or "D", "C"), return 1.

For "ABCD" and "EACB", the LCS is "AC", return 2.

*/

/*
	Two Sequence DP: dp[i][j] represents the longest common subsequence for the first i characters of A
					and the first j characters of B.
					if A.charAt(i) == B.charAt(j)  dp[i][j] ==  dp[i-1][j-1] + 1;
					else dp[i][j] = max(dp[i-1][j],dp[i][j-1])
	Time: O(m*n)
*/

public class Solution {
    /**
     * @param A, B: Two strings.
     * @return: The length of longest common subsequence of A and B.
     */
    public int longestCommonSubsequence(String A, String B) {
        // write your code here
        //f[i][j] represents the longest common
        if(A == null || B == null || A.length() == 0 || B.length() == 0)
            return 0;
        int[][] f = new int[A.length()][B.length()];
        for(int i = 0; i < A.length();i++){
            if((i > 0 && f[i-1][0] == 1) || A.charAt(i) == B.charAt(0))
                f[i][0] = 1; 
        }
        for(int i = 0; i < B.length();i++){
            if((i > 0 && f[0][i-1] == 1) || B.charAt(i) == A.charAt(0))
                f[0][i] = 1; 
        }
        for(int i = 1; i < A.length(); i++){
            for(int j = 1; j < B.length(); j++){
                if(A.charAt(i) == B.charAt(j)){
                    f[i][j] = Math.min(Math.min(f[i-1][j-1], f[i-1][j]), f[i][j-1]) + 1;
                }
                else
                    f[i][j] = Math.max(Math.max(f[i-1][j-1], f[i-1][j]), f[i][j-1]);
            }
        }
        return f[A.length() - 1][B.length() - 1];
    }
}
