/*
20. Valid Parentheses

Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.

 */

 public class 20ValidParentheses {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        if(s.length()%2!=0) return false;
        for(int i=0;i<s.length();i++){
        	char c = s.charAt(i);
        	if(c=='['||c=='('||c=='{')
        		stack.push(c);
        	else if(!stack.empty()&&(c==']'&&stack.peek()=='['||c==')'&&stack.peek()=='('||c=='}'&&stack.peek()=='{'))
 		       		stack.pop();
        	else
        		return false;
        }	
        return stack.isEmpty();
    }
}