/*
227. Basic Calculator II

Implement a basic calculator to evaluate a simple expression string.

The expression string contains only non-negative integers, +, -, *, / operators and empty spaces . The integer division should truncate toward zero.

You may assume that the given expression is always valid.

Some examples:
"3+2*2" = 7
" 3/2 " = 1
" 3+5 / 2 " = 5
Note: Do not use the eval built-in library function.
*/

public class Solution {
    public int calculate(String s) {
    	Stack<Integer> nums = new Stack<Integer>();
    	Stack<Character> signs = new Stack<Character>();
    	for(int i = 0; i < s.length(); i++){
    		char c = s.charAt(i);
    		if(c >= '0' && c <= '9'){
    			int num = c - '0';
    			while( i + 1 < s.length() && s.charAt(i+1) >= '0' && s.charAt(i+1) <= '9' ){
    				num = 10 * num + s.charAt(i+1) - '0';
    				i++;
    			}
    			if(!signs.isEmpty() && (signs.peek() == '*' || signs.peek() == '/')){
    				char sign = signs.pop();
					nums.push(sign == '*' ? nums.pop() *  num : nums.pop() /  num);
    			}
    			else
    				nums.push(num);
    		}
    		else if( c == '*' || c == '/'|| c == '+' || c == '-' ){
    			if(!signs.isEmpty() && ( c == '+' || c == '-') ){
    				int num = nums.pop();
    				char sign = signs.pop();
					nums.push(sign == '+' ? nums.pop() +  num : nums.pop() -  num);
    			}
    			signs.push(c);
    		}
    	}
    	int result = nums.pop();
    	return signs.isEmpty()? result : (signs.pop() == '+' ? nums.pop() +  result : nums.pop() -  result);
    }
}