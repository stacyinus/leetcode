/*
115. Distinct Subsequences 

Given a string S and a string T, count the number of distinct subsequences of T in S.

A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of the characters 
without disturbing the relative positions of the remaining characters. (ie, "ACE" is a subsequence of "ABCDE" while "AEC" is not).

Here is an example:
S = "rabbbit", T = "rabbit"

Return 3.
*/
/*
	dp problem: dp[i][j] representing the distinct subsequences of T.substring(0,i) in S.substring(0,j). dp array size [T.length + 1][S.length + 1]
				eg. S = "rabbbit", T = "rabbit", dp[3][2] meaning the distinct subsequences of "ra" in "rab"
				dp[i][j] should at least equal to dp[i][j - 1] because if "abc" contains "bc", then "abcb" should at least contain the same amount of "bc'
				and if(s.char[i] == t. char[j])
					r a b b b i t
				  1 1 1 1 1 1 1 1   // why this has to be initialized to 1?
 				r 0 1 1 1 1 1 1 1
				a 0 0 1 1 1 1 1 1   
				b 0 0 0 1 2 3 3 3   
				b 0 0 0 0 1 3 3 3
				i 0 0 0 0 0 0 3 3
				t 0 0 0 0 0 0 0 3

				c c c   
			  1 1 1 1
			c 0 1 2 3
			c 0 0 1 
*/
public class Solution {
    public int numDistinct(String s, String t) {
        if ( s == null || s.length() == 0 ) {
        	return 0;
        }
        if (t.length() == 0) {
            return 1;
        }
        int[][] dp = new int[t.length() + 1][s.length() + 1];
        for ( int i = 0; i < dp[0].length; i++) {
        	dp[0][i] = 1;
        }
        for (int i = 1; i < dp.length; i++) {
        	for (int j = i; j < dp[i].length; j ++) {
        	    dp[i][j] = dp[i][j - 1];
        		if (s.charAt(j - 1) == t.charAt(i - 1)){
        			dp[i][j] += dp[i - 1][j - 1];
        		}
        	}
        }
        return dp[t.length()][s.length()];
    }
}