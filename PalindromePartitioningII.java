/*
Palindrome Partitioning II

Given a string s, cut s into some substrings such that every substring is a palindrome.

Return the minimum cuts needed for a palindrome partitioning of s.

Example
Given s = "aab",

Return 1 since the palindrome partitioning ["aa", "b"] could be produced using 1 cut.
*/


/*
	DP: dp array represents "the minimum cuts needed for a palindrome partitioning for the first
		i characters". 
*/
public class Solution {
    /**
     * @param s a string
     * @return an integer
     */
    public int minCut(String s)	 {
        // write your code here
        boolean[][] isParlindrome = findMatrix(s);

    	int[] dp = new int[s.length() + 1];
    	dp[0] = -1;
    	for(int i = 1; i <= s.length();i++)
    		dp[i] = i - 1;
    	for(int i = 1;i < s.length(); i++)
    		for(int j = 0; j < i; j++){
    			if(isPalindrome(s,j,i))
    				dp[i+1] = Math.min(dp[i+1], dp[j]+1);
    		}
    	return dp(s.length());
    }
    public boolean isPalindrome(String s, int j, int i){ //inclusive
    	while(j < i){
    		if(s.charAt(j) != s.charAt(i))
    			return false;
    		j++;
    		i--;
    	}
    	return true;
    }
    public boolean[][] findMatrix(String s){
		boolean[][] isParlindrome = new boolean[s.length()][s.length()];
    	for(int i = 0; i < s.length(); i++ ){
    		for(int j = 0; j < s.length(); j++){
    			if(i == j || isPalindrome(s, i, j))

    		}
    	}
    }
};			