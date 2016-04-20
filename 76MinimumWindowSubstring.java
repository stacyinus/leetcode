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
    public String minWindow(String s, String t) {
        int start = 0, end = 0, start_m = 0, end_m = 0;
       	HashMap<Character, Integer> map = new HashMap<Character, Integer>();
       	char[] tChar = t.toCharArray();
       	for(char c : tChar){
       		if(map.containsKey(c))
       			map.put(c, map.get(c)+1);
       		else
       			map.put(c,1);
       	}
        while(start <= s.length()-t.length()){
        	while(end<s.length() && !map.isEmpty()){
        		char c = s.charAt(end++);
        		if(!map.containsKey(c))
        			continue;
        		if(map.get(c) == 1)
        			map.remove(c);
        		else
        			map.put(c,map.get(c)-1);
        	}
        	if(end == s.length() && !map.isEmpty())
        		break;
        	if(result.equals("")) result = s.substring(start, end);   
        	if(result.length() > end - start)
        		result = s.substring(start, end);      	
        	if(t.indexOf(s.charAt(start)) != -1 && s.substring(start+1,end).indexOf(s.charAt(start)) == -1)
        		tmp = s.substring(start,start+1);
        	start++;
        }
        return result;
    }
}