/*
22. Generate Parentheses
Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

For example, given n = 3, a solution set is:

"((()))", "(()())", "(())()", "()(())", "()()()"
*/

public class Solution {
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
        	HashSet<String> set = new HashSet<String>();
        	set.add(s+"()");
        	set.add("()"+s);
        	set.add("("+s+")");
        	for(String t: set){
        		if(!list.contains(t))
        			list.add(t);
        	}
        }
        return list;
    }
}