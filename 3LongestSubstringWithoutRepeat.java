/*
Given a string, find the length of the longest substring without repeating characters. 
For example, the longest substring without repeating letters for "abcabcbb" is "abc", which the length is 3.
For "bbbbb" the longest substring is "b", with the length of 1.
*/

/*
    Two Pointers:
    i , j starts at the beginning, and form a window of current substring(i is the beginning , j is end), 
    when catch a duplicate, move i forward.
*/

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        // write your code here
        if(s == null || s.length() == 0)
            return 0;
        int i = 0, j = 0, len = 1;
        boolean[] set = new boolean[256];
        while(j < s.length()){ //use j the end point beacuase we are looking for the longest substring, 
                                // so when end point hit the end, there's no need to move the start point.
            while(j < s.length() && !set[s.charAt(j)])
                set[s.charAt(j++)] = true;
            len = Math.max(len, j-i);
            set[s.charAt(i++)] = false;
        }
        return len;
    }
}