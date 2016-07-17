/*
Given a string S, find the longest palindromic substring in S. 
You may assume that the maximum length of S is 1000, and there exists one unique longest palindromic substring.
*/
/*
    use greedy
*/
public class Solution {
    public String longestPalindrome(String s) {
        String max = "";
        for(int i = 0; i<s.length();i++){
            String temp = maxPalindrome(s,i,i);
            if(temp.length()>max.length())
                max = temp;
            temp = maxPalindrome(s,i,i+1);
            if(temp.length()>max.length())
                max = temp;
        }
        return max;
    }

    private String maxPalindrome(String s, int left, int right){
        while(left>=0&&right<s.length()){
            if(s.charAt(left)!=s.charAt(right))
                break;
            left--;
            right++;
        }
        return s.substring(left+1,right);

    }    
    //use dp: but this is very slow.... shouldn't be using dp to solve palindrome problem.
    public String longestPalindrome(String s) {
        int n = s.length();
        String max = s.substring(0,1);
        boolean[][] dp = new boolean[n][n]; 
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
            if (i > 0) {
                dp[i - 1][i] = s.charAt(i - 1) == s.charAt(i);
               // System.out.println("dp[" + (i - 1) + "][" + i + "] = " + dp[i-1][i]);
                if (dp[i - 1][i] && max.length() < 2) {
                    max = s.substring(i - 1, i + 1);
                    //System.out.println("max = " + max);
                }
            }
        }
        for (int j = 2; j < n; j++) {
            for (int i = 0; i < j - 1; i++) {
                dp[i][j] = (s.charAt(i) == s.charAt(j) && dp[i+1][j-1]);
                //System.out.println("dp[" + i+ "][" + j + "] = " + dp[i][j]);
                if (dp[i][j] && j - i + 1 > max.length()) {
                    max = s.substring(i, j + 1);
                    //System.out.println("max = " + max);
                }
            }
        }
        return max;
    }

}