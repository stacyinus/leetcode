/*
22. Generate Parentheses
Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

For example, given n = 3, a solution set is:

"((()))", "(()())", "(())()", "()(())", "()()()"
*/

public class Solution {
    //recursive:5 ms, so freaking slow....
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<String>();
        if(n<1)
        	return list;
        if(n==1){
        	list.add("()");
        	return list;
        }
        List<String> base = generateParenthesis(n-1);
        for(String s: base){
            int i=0;
            for(int j=0;j<s.length();j++){
                if(i==0)
                    list.add("("+s.substring(0,j)+")"+s.subString(j));
                if(s.charAt(j)=='(')
                    i++;
                else
                    i--;
            }
            list.add("("+s+")");
        }
        return list;
    }
    //use dp.
    public List<String> generateParenthesis(int n) {
    
    }
}