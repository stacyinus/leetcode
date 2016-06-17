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
    public int minCut(String s)  {
        // write your code here
        boolean[][] isParlindrome = findMatrix(s);

        int[] dp = new int[s.length() + 1];
        for(int i = 0; i <= s.length();i++)
            dp[i] = i - 1;
        for(int i = 1;i <= s.length(); i++)
            for(int j = 0; j < i; j++){
                if(isParlindrome[j][i-1])
                    dp[i] = Math.min(dp[i], dp[j]+1);
            }
        return dp[s.length()];
    }
    // public boolean isPalindrome(String s, int j, int i){ //inclusive
    //  while(j < i){
    //      if(s.charAt(j) != s.charAt(i))
    //          return false;
    //      j++;
    //      i--;
    //  }
    //  return true;
    // }
    public boolean[][] findMatrix(String s){
        boolean[][] isParlindrome = new boolean[s.length()][s.length()];
        for(int i = 0; i < s.length(); i++ )
            isParlindrome[i][i] = true;
        for(int i = 0; i < s.length()-1; i++ )
            isParlindrome[i][i+1] = s.charAt(i) == s.charAt(i+1);
        for(int j = 2; j < s.length(); j++){
            for(int i = 0; i + j < s.length(); i++ ){
                isParlindrome[i][i+j] = isParlindrome[i+1][i+j-1] && s.charAt(i) == s.charAt(i+j);
            }
        }
        return isParlindrome;
    }
}		