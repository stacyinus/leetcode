/*
30. Substring with Concatenation of All Words

You are given a string, s, and a list of words, words, that are all of the same length. Find all starting indices of substring(s) in s that is a concatenation of each word in words exactly once and without any intervening characters.

For example, given:
s: "barfoothefoobarman"
words: ["foo", "bar"]

You should return the indices: [0,9].
(order does not matter).
*/

/*
	bar foo the foo bar man  

*/

public class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<String>();
        int n = words[0].length();
        int totalL = n * words.size();
        int i = 0;
        while ( i <= s - totalL ) {
        	List<String> list = new ArrayList<String>(words);
        	if (list.contains(s.substring(i, i + n)) { //find a potential startpoint
        		int index = helper(s, i, n, list);
        		if (list.size() == 0) {
        			result.add(i);
        		}
        		i = index;
        	}
        	else {
        		i++;
        	}
        }
        return result;
    }
    public int helper(String s, int start, int n, List<String> list) {//return the index where
    	if (list.size() == 0) return start;
    	if (!list.contains(s.substring(start, start + n))) return start;
    	list.remove(s.substring(start, start + n));
    	return helper(s, start + n, n, list);
    }


}