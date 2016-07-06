/*
214. Shortest Palindrome 

Given a string S, you are allowed to convert it to a palindrome by adding characters in front of it. 
Find and return the shortest palindrome you can find by performing this transformation.

For example:

Given "aacecaaa", return "aaacecaaa".

Given "abcd", return "dcbabcd".

*/
/*
	1. find the longest palindrome from the beginning.
    2. revert the part that is not palindrome and append to head.
    3. be extra aware of the different method for step 1.
*/
public class Solution {
    //beats 96%
    public String shortestPalindrome(String s) {
        if(s == null || s.length() <= 1){
            return s;
        }
        char[] a = s.toCharArray();
        int middle = (s.length() -1)/2;
        int end = getLastPosForPalindrome(a, middle);
        if (end == a.length) {
            return s;
        }
        StringBuilder sb = new StringBuilder(s.substring(end)).reverse();
        sb.append(s);
        return sb.toString();
    }
    
   private int getLastPosForPalindrome(char[] s, int middle){
       int i = middle, j = middle;
       while(i >= 0 && s[i] == s[middle]){
           i--;
        }
        while(j < s.length && s[j] == s[middle]){
            j++;
            
        }
        while(i >=0 && j < s.length && s[i] ==  s[j]){
            i--; 
            j++;
        }
        if(i == -1){
            return j;
        }
        return getLastPosForPalindrome(s, middle -1);
   }
    
    public String shortestPalindrome2(String s) {
        if(s == null || s.length() == 0 || s.length() == 1)
            return s;
        int index = findIndex(s);
        StringBuilder sb = new StringBuilder(s.substring(index)).reverse();
        sb.append(s);
        return sb.toString();
    }
    // this is considered slow by leet code oj
    private int findIndex(String s) {
        int i = s.length() - 1/ 2, j = s.length()/ 2;//i <=j
        while (i >= 0) {
            int s = i, e = j;
            while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
                i--; 
                j++;
            }
            if ( s == 0 ) {
                break;
            }
            if (i == j){
                i --;
            }
            else {
                j--;
            }
        }
        return j + i + 1;
    }
    // this is etl 
    private int findIndex(String s) {
    	for (int cur = s.length() - 1; cur > 0; cur--) {
    		int i = 0;
    		int j = cur;
    		while(i < j) {
    			if(s.charAt(i) != s.charAt(j))
    				break;
    			i++;
    			j--;
    		}
    		if (i >= j) return cur + 1;
    	}
    	return 1;
    }

    //dont use dp to find parlindrome, it's dedicated n2 time complexity
    // private int dp(String s) {
    //  int max = 0;
    //  boolean[][] dp = new boolean[s.length()][s.length()];
    //  for(int i = 0; i < s.length(); i++) {
    //      dp[i][i] = true;
    //  }
    //  for(int i = 1; i < s.length(); i++) {
    //      dp[i - 1][i] = s.charAt(i - 1) == s.charAt(i);
    //  }
    //  if(dp[0][1]) max = 1;
    //  for(int m = 2; m < s.length(); m++) {
    //      int i = 0, j = m;
       //       while (j < s.length()) {
       //       dp[i][j] = dp[i+1][j-1] && s.charAt(i) == s.charAt(j);
       //       i++;
       //       j++;
       //   }
       //   if(dp[0][m]) max = m;       
    //  }
    //  return max;
    // }    
}