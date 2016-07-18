/*
14  Longest Common Prefix
Write a function to find the longest common prefix string amongst an array of strings
*/

/*
    pick the first one in the array as the string that all other strings compare with.
    be careful of special cases when the first string is ""
*/
public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        if (strs.length == 1 || strs[0].length() == 0) return strs[0];
        String prefix = "";
        int i = 0;
        while (i < strs[0].length()) {
            for (int j = 1; j < strs.length; j ++) {
                if ( i == strs[j].length() || strs[j].charAt(i) != strs[0].charAt(i)) return prefix;
            }
            prefix += strs[0].substring(i, i + 1);
            i++;
        }
        return prefix;
    }
}