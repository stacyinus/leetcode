/*
150. Evaluate Reverse Polish Notation

Evaluate the value of an arithmetic expression in Reverse Polish Notation.

Valid operators are +, -, *, /. Each operand may be an integer or another expression.

Some examples:
  ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
  ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
*/
 /*
	思路： 理解什么是reverse  polish notation first....
		  当遇到数字，push to stack.
		  当遇到符号，pop 两个进行运算.注意pop的先后顺序会影响运算。必须贴近栈底的元素+/ - /* / \ 贴近站顶的元素。
 */

public class Solution {
    public int evalRPN(String[] tokens) {
    	if (tokens == null || tokens.length == 0) {
    		return 0;
    	}
 		Stack<Integer> stack = new Stack<Integer>();
 		for (int i = 0; i < tokens.length; i++) {
 			if (tokens[i].equals("+") || tokens[i].equals("-") || tokens[i].equals("*") || tokens[i].equals("/")) {
 				int x = stack.pop(), y = stack.pop();
 				int num = 0;
 				if (tokens[i].equals("+")){
 				    num = y + x;
 				}
 				else if (tokens[i].equals("-")){
 				    num = y - x;
 				}
 				else if (tokens[i].equals("*")){
 				    num = y * x;
 				}
 				else{
 				    num = y / x;
 				}
		 		stack.push(num);
 			}
 			else {
 				stack.push(parseInt(tokens[i]));// here can also use Integer.parseInt()
 			}
 		}       
 		return stack.pop();
    }
    private int parseInt(String s) {
        int result = 0;
        char[] a = s.toCharArray();
        for (int i = 0; i < a.length; i++) {
            if (a[i] != '-') {
                result = result * 10 + a[i] - '0';
            }
        }
        return a[0] == '-' ? result * (-1) : result;
    }
}