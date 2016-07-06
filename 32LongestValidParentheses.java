/*
32. Longest Valid Parentheses

Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.

For "(()", the longest valid parentheses substring is "()", which has length = 2.

Another example is ")()())", where the longest valid parentheses substring is "()()", which has length = 4.
*/
/*
    ")()())"
*/
public class Solution {
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