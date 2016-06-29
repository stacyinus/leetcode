/*
214. Shortest Palindrome 

Given a string S, you are allowed to convert it to a palindrome by adding characters in front of it. 
Find and return the shortest palindrome you can find by performing this transformation.

For example:

Given "aacecaaa", return "aaacecaaa".

Given "abcd", return "dcbabcd".

*/
/*
	abacd	
	aabbcc 
	abcaacba
	dp[i][j] meaining whether s.substring(i, j+1) is a parlindrome.
	dp[0][0] = true;
	dp[0][1] = 
	dp
	dp[i] represent wheather s.substring(i,j) is a palindrome.
	dp[1] = true;
	dp[i] =  if dp[i-1] == true, dp[i] = false;
			else if dp[i-2] == true and char[i] == char[i-1], dp[i] = true;
	1. find the longest palindrome from the beginning.
*/
public class Solution {
    public String shortestPalindrome(String s) {
        if(s == null || s.length() == 0 || s.length() == 1)
            return s;
        int index = findLongestParlindromeFromBeginning(s);
        StringBuilder sb = new StringBuilder(s.substring(index + 1)).reverse();
        sb.append(s);
        return sb.toString();

    }
    private int dp(String s) {
    	int max = 0;
    	boolean[][] dp = new boolean[s.length()][s.length()];
    	for(int i = 0; i < s.length(); i++) {
    		dp[i][i] = true;
    	}
    	for(int i = 1; i < s.length(); i++) {
    		dp[i - 1][i] = s.charAt(i - 1) == s.charAt(i);
    	}
    	if(dp[0][1]) max = 1;
    	for(int m = 2; m < s.length(); m++) {
    		int i = 0, j = m;
	     	while (j < s.length()) {
	    		dp[i][j] = dp[i+1][j-1] && s.charAt(i) == s.charAt(j);
	    		i++;
	    		j++;
	    	}
	    	if(dp[0][m]) max = m;  		
    	}
    	return max;
    }
    private int findLongestParlindromeFromBeginning(String s) {
    	for (int cur = s.length() - 1; cur > 0; cur--) {
    		int i = 0;
    		int j = cur;
    		while(i < j) {
    			if(s.charAt(i) != s.charAt(j))
    				break;
    			i++;
    			j--;
    		}
    		if (i >= j) return cur;
    	}
    	return 0;
    }
}