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
    //bfs
    public List<String> removeInvalidParentheses(String s) {
        List<String> result = new ArrayList<String>();      
        if (isValid(s)) {
            result.add(s);
            return result;
        }
        Queue<String> queue = new LinkedList<String>();
        HashSet<String> set = new HashSet<String>();
        queue.add(s);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int count = 0; count < size; count++) {
                String cur = queue.poll();
                for (int i = 0; i < cur.length(); i++) {
                    if (cur.charAt(i) != '(' && cur.charAt(i) != ')' || i > 0 && cur.charAt(i) == cur.charAt(i - 1)) {
                        continue;
                    }
                    String pre = i == 0 ? "" : cur.substring(0,i);
                    String aft = i == cur.length() - 1 ? "" : cur.substring(i + 1);
                    String tmp = pre + aft;
                    if (set.contains(tmp)) continue;
                    set.add(tmp);
                    if (isValid(tmp)) {
                        result.add(tmp);
                    } 
                    else {
                        queue.add(tmp);
                    }
                }
            }
            if (result.size() >0) {
                break;
            }
        }
        if (result.size() == 0) {
            result.add("");
        }
        return result;
    }

    private boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != '(' && s.charAt(i) != ')' ) {
                continue;
            }
            else if (s.charAt(i) == '(') {
                stack.push('(');
            }
            else if (s.charAt(i) == ')') {
                if (stack.isEmpty()) {
                    return false;
                }
                else {
                    stack.pop();
                }
            }
        }
        return stack.isEmpty();
    }

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