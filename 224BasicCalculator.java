/*
224. Basic Calculator

Implement a basic calculator to evaluate a simple expression string.

The expression string may contain open ( and closing parentheses ), the plus + or minus sign -, non-negative integers and empty spaces .

You may assume that the given expression is always valid.

Some examples:
"1 + 1" = 2
" 2-1 + 2 " = 3
"(1+(4+5+2)-3)+(6+8)" = 23
Note: Do not use the eval built-in library function.
*/

public class Solution {
    public int calculate(String s) {
    	int num = 0;
        int count = 0;
        Stack<Integer> nums = new Stack<Integer>();
        Stack<Character> signs = new Stack<Character>();
        Stack<Integer> counts = new Stack<Integer>();
        for(int i = 0; i < s.length()-1; i++){
        	char c = s.charAt(i);
        	if(c == ' ')
        		continue;	
        	else if(c >= '0' && c <= '9'){
        		num += c-'0'; 
        		if(s.charAt(i + 1) >= '0' && s.charAt(i + 1) <= '9')
        			num*=10;
                else{
                    nums.push(num);
                    num = 0;
                    count++;
                }
        	}
            else if(c == '+' || c == '-')
                signs.push(c);
            else if(c == '('){
                counts.push(count);
                count = 0;
            }
            else if(c == ')'){
                int tmp = nums.pop();
                while(count > 1){
                    char sign = signs.pop();
                    if(sign == '+') tmp += nums.pop();
                    if(sign == '-') tmp = nums.pop() - tmp;
                    count--;
                }
                count = counts.pop();
                nums.push(tmp);
                count++;
            }



            

        }
    }
}