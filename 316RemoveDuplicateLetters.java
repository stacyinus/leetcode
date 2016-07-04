/*
316. Remove Duplicate Letters 
Given a string which contains only lowercase letters, remove duplicate letters so that every letter appear once and only once. 
You must make sure your result is the smallest in lexicographical order among all possible results.

Example:
Given "bcabc"
Return "abc"

Given "cbacdcbc"
Return "acdb"
*/
/*
	思路： 注意lexicographical order，不可以sort。必须keep character in place。
		  1. loop ，count所有的characters。
		  2. add char if not already exist，repeatedly remove previous char c1 if current char is smaller than 
		  	 c1 and c1 has more than（>=） 1 left. 
*/
public class Solution {
    public String removeDuplicateLetters(String s) {
    	if (s == null || s.length() == 0 || s.length() == 1) {
    		return s;
    	}
    	char[] a = s.toCharArray();
    	int[] count = new int[26];
    	for (int i = 0; i < a.length; i++) {
    		count[a[i] - 'a']++;
    	}
    	StringBuilder sb = new StringBuilder();
    	HashSet<Character> set = new HashSet<Character>();
    	for (int i = 0; i < a.length; i++) {
    	    count[a[i] - 'a']--;
    	    if (set.contains(a[i])) continue;
    		while (sb.length() > 0 && a[i] < sb.charAt(sb.length() - 1) && count[sb.charAt(sb.length() - 1) - 'a'] >= 1) {
    			set.remove(sb.charAt(sb.length() - 1));
    			sb.deleteCharAt(sb.length() - 1);
    		}
    		sb.append(a[i]);
            set.add(a[i]);
    	}
    	return sb.toString();
    }
}