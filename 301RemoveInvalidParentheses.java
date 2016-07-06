/*
301. Remove Invalid Parentheses 
Difficulty: Hard
Remove the minimum number of invalid parentheses in order to make the input string valid. 
Return all possible results.

Note: The input string may contain letters other than the parentheses ( and ).

Examples:
"()())()" -> ["()()()", "(())()"]
"(a)())()" -> ["(a)()()", "(a())()"]
")(" -> [""]
*/

/*
	()())(() --- ()() (()      (())
	((()(())())  (()(())()) ((()())()) ((()(()))
	()(()()(((
	stack<String> -- do validation. 
	invalid conditions: 1. when stack is empty , incoming is ): remove each ) appeared before 
							current ) and not next to current ) will result into a new string.
						2. when reaching end of the string, stack still left with (
	
	1. find valid pairs, put in string. find invalid
*/
public class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> result = new ArrayList<String>();
        if (s == null || s.length() == 0) {
        	return result;
        }
        i
    }

    private List<String> helper( String s) {//List<String> result,
    	Stack<String> stack = new Stack<String>();
    	char[] arr = s.toCharArray();
    	StringBuilder sb = new StringBuilder();
    	for (int i = 0; i < s.length(); i++) {
    		if (arr[i] == ")") {
    			if (stack.isEmpty()) { //found invalid, case 1
    				List<String> tmp = getPossibleStrings(s, i, true); // s starting from i, to the left, find ")"
    				List<String> rest = helper(s.substring(i + 1));
    			}
    			else {
    				while( stack.peek() != '(' ) {
    					sb.append()
    				}
    			}
    		}
    		else (arr[i] != ')') {
    			continue;
    		}
    	}
    }
    private List<String> getPossibleStrings(String s, int i, boolean right) {

    }
}