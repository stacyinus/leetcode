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
        boolean calc = false;
        Stack<Integer> nums = new Stack<Integer>();
        Stack<Character> signs = new Stack<Character>();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c >= '0' && c <= '9'){ // 0, + , )
                int tmp = c - '0';
                while(i + 1 < s.length() && s.charAt(i + 1) >= '0' && s.charAt(i + 1) <= '9'){
                    tmp = 10 * tmp + s.charAt(i + 1) - '0';     
                    i++;
                }
                if( !calc )
                    nums.push(tmp);     
                else{
                    nums.push( signs.pop() == '+' ? nums.pop() + tmp : nums.pop() - tmp );
                    calc = false;
                }
            }
            else if(c == '+' || c == '-'){ // ' ', 0, (
                signs.push(c);
                while(i+1 < s.length() && s.charAt(i+1) == ' ')
                    i++;               
                if(i+1 < s.length() && s.charAt(i+1) >= '0' && s.charAt(i+1) <= '9')
                    calc = true;
            }
            else if( c == ')' && !nums.isEmpty() && !signs.isEmpty()){
                int num = nums.isEmpty() ? 0 : nums.pop();
                char sign = signs.pop();
                if(sign == '+')
                    num = nums.pop() + num;
                else
                    num = nums.pop() - num;
                nums.push(num);           
            }
        }
        return nums.isEmpty() ? 0 : nums.pop();
    }
}