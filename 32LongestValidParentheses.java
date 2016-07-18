/*
32. Longest Valid Parentheses

Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.

For "(()", the longest valid parentheses substring is "()", which has length = 2.

Another example is ")()())", where the longest valid parentheses substring is "()()", which has length = 4.
*/
/*
    思路要清晰：3 个变量，max, accumulativeLength, tmpLength
            when '('，push to stack.
            when ')'， 如果stack为空，那么之前累积的length就作废了。
                       如果stack不为空，pop一个出来， 计算出当前的valid length。 
                       如果pop之后为空，那么accumulativeLength应该增加，如果pop之后不为空，那么当前length应该等于i - stack.peek()。 
                       因为"(()(())"这种情况， i = 3时， tmpLength = 2. 当 i=end of string时， stack not empty,但是当前valid length should be 6

    "()(()"
    "(()(((()"
*/
public class Solution {
    public int longestValidParentheses(String s) {
        int max = 0, accumulativeLength = 0;
        Stack<Integer> stack = new Stack<Integer>();
        char[] a = s.toCharArray();
        for (int i = 0; i < a.length; i++) {
            if (a[i] == '(') {
                stack.push(i);
            }    
            else {
                if (!stack.isEmpty()) {
                    int tmpLength = i - stack.pop() + 1;
                    if (stack.isEmpty()) {
                        accumulativeLength += tmpLength;
                        max = Math.max(max, accumulativeLength);
                    }
                    else { // this part is very important!!!!!!!!
                        tmpLength = i - stack.peek();
                        max = Math.max(max, tmpLength);
                    }
                }
                else {
                    accumulativeLength = 0;
                }

            }
        }
        return max;
    }

    //bfs
    public int longestValidParentheses(String s) {
        if (s == null || s.length() == 0) return 0;
        if (isValid(s)) {
            return s.length();
        }
        Queue<String> q = new LinkedList<String>();
        HashSet<String> set = new HashSet<String>();
        q.add(s);
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                String cur = q.poll();
                for (int j = 0; j < cur.length(); j++) {
                    String first = j == 0 ? "" : s.substring(0,j);
                    String second = j == cur.length() - 1 ? "" : s.substring(j + 1);
                    String tmp = first + second;
                    if (set.contains(tmp)) continue;
                    if (isValid(tmp)) return tmp.length();
                    q.add(tmp);
                    set.add(tmp);
                } 
            }
        }
        return 0;
    }
    private boolean isValid(String s) {
        int count = 0;
        char[] a = s.toCharArray();
        for (int i = 0; i < a.length; i++) {
            if (a[i] == '(') count++;
            else if (count == 0) return false;
            else count--;
        }
        return count == 0;
    }
}