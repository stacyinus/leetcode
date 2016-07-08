/*
97. Interleaving String

Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.

For example,
Given:
s1 = "aabcc",
s2 = "dbbca",

When s3 = "aadbbcbcac", return true.
When s3 = "aadbbbaccc", return false.
*/

/*
	dp = new booelan[s1.length() + 1][s2.length() + 1]
	dp[i][j] meaning: whether s1.substring(0, i) , and s2.substring(0, j) can interleave to s3.substring(0, i + j) or not
	initialization: dp[0][0] = true 
					dp[i][0] : whether s1.substring(0, i) can interleave to s3.substring(0, i), since there's no s2, interleave should be equal to.
					dp[0][j] : whether s2.substring(0, j) can interleave to s3.substring(0, j), since there's no s1, interleave should be equal to.
	transition: dp[i][j] = ??? I dont quite understand this part...see code...
	s1 = "aabcc",  i 
	s2 = "dbbca",  j
	aadbbcbcac 
		d b b c a  s2
	  1 0 0 0 0 0 
	a 1 0 0 0 0 0
	a 1 1 1 1 1 0
	b 0 1 
	c 0
	c 0
	s1
*/
public class Solution {
	//this is etl

    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) return false;
        boolean[][] dp = new boolean[s1.length() + 1][s2.length() + 1];
        dp[0][0] = true;
        for (int i = 1; i <= s1.length(); i++) {
        	dp[i][0] = (s1.charAt(i - 1) == s3.charAt(i - 1) && dp[i-1][0]);
        }
        for (int i = 1; i <= s2.length(); i++) {
        	dp[0][i] = (s2.charAt(i - 1) == s3.charAt(i - 1) && dp[0][i-1]);
        }
        for (int i = 1; i <= s1.length();i++){
        	for (int j = 1; j <= s2.length();j++) {
        		if (s1.charAt(i - 1) == s3.charAt(i + j - 1) && dp[i-1][j] || s2.charAt(j - 1) == s3.charAt(i + j - 1) && dp[i][j-1])
        			dp[i][j] = true;
        	}
        }
        return dp[s1.length()][s2.length()];
    }

	//this is etl
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) return false;
        int i = 0, j = 0, k = 0;
        while ( k < s3.length()) {	
        	if (i == s1.length())  return s2.substring(j).equals(s3.substring(k));
        	if (j == s2.length())  return s1.substring(i).equals(s3.substring(k));            
        	if (s1.charAt(i) != s3.charAt(k) && s2.charAt(j) != s3.charAt(k)) return false;
        	else if (s1.charAt(i) == s2.charAt(j)) {
        		if (isInterleave(s1.substring(i + 1), s2.substring(j), s3.substring(k+1))) return true;
        			return isInterleave(s1.substring(i), s2.substring(j + 1), s3.substring(k + 1));
        	}
        	else if (s1.charAt(i) == s3.charAt(k)) {
        		i++;
        	}
        	else {
        		j++;
        	}
        	k++;
        }
        return true;
    }
}