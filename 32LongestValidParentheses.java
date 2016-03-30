/*
32. Longest Valid Parentheses

Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.

For "(()", the longest valid parentheses substring is "()", which has length = 2.

Another example is ")()())", where the longest valid parentheses substring is "()()", which has length = 4.
*/

public class Solution {
    public int longestValidParentheses(String s) {
        int count = 0;
        int validP = 0;
        int longgest = 0;
        int tmp=0;
        for(int i=0;i<s.length();i++){
        	if(s.charAt(i)=='(')
        		count++;
        	else if(s.charAt(i)==')'){
        		if(count>0){
        			count--;
        			tmp++;
        		}
        		else(count==0){
        			validP+=tmp;
        			tmp=0;
	        		if(i<s.length()-1&&s.charAt(i+1)==')'&&validP>0){
	        			longgest = Math.max(longgest,validP);
	        			validP=0;
	        		}
        		}
        	}
        }
       if(count==0) 
            longgest = Math.max(longgest,validP);
        else
            longgest = validP;
        return longgest*2;
    }
}