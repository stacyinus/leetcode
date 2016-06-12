/*
76. Minimum Window Substring

Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).

For example,
S = "ADOBECODEBANC"
T = "ABC"
Minimum window is "BANC".

Note:
If there is no such window in S that covers all characters in T, return the empty string "".

If there are multiple such windows, you are guaranteed that there will always be only one unique minimum window in S.
*/

public class Solution {
  //Two Pointers: Starting from the same point.
    public String minWindow(String s, String t) {
        int start = 0, end = 0;
        HashMap<Character, Integer> count = new HashMap<Character, Integer>();
        char[] tChar = t.toCharArray();
        String result = "";
        for(char c : tChar)
          count.put(c, count.containsKey(c)?count.get(c)+1:1);  
        int num = count.size(); 
        while(start <= s.length()-t.length()){
            while(end<s.length() && num > 0 ){
              char c = s.charAt(end++);
              if(count.containsKey(c)){
                count.put(c,count.get(c)-1);
                if(count.get(c) == 0) num --;
              }
            }
            if(end == s.length() && num > 0)
              break;
            if(result.equals("") || result.length() > end - start) 
              result = s.substring(start, end);        
            if(count.containsKey(s.charAt(start))){
              if(count.get(s.charAt(start)) == 0 )
                num++;
              count.put(s.charAt(start),count.get(s.charAt(start))+1);
            }
            start++;
        }
        return result;        
    }
    
}