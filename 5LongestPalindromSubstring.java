/*
Given a string S, find the longest palindromic substring in S. You may assume that the maximum length of S is 1000, and there exists one unique longest palindromic substring.
*/

public class 5LongestPalindromSubstring {
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
}