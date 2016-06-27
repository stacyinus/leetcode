/*
49. Group Anagrams
Given an array of strings, group anagrams together.

For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"], 
Return:

[
  ["ate", "eat","tea"],
  ["nat","tan"],
  ["bat"]
]
*/
/*
	keep a HashMap<String, List<String>>. 
	for each string in the array, sort all the chars first, and see if the map contains this key.
	if yes, add in to the list. if no, add a new entry to the map.	

*/
public class Solution {
	public List<List<String>> groupAnagrams(String[] strs) {
		if (strs == null || strs.length == 0) {
        	return new ArrayList<List<String>>();
        }
        HashMap<String, List<String>> map = new HashMap<String, List<String>>();
        for (String s: strs) {
        	char[] chars = s.toCharArray();
        	Arrays.sort(chars);
        	String tmp = new String(chars);
        	if(!map.containsKey(tmp)) {
        		List<String> list = new ArrayList<String>();
        		list.add(s);
        		map.put(tmp, list);
        	}
        	else {
        		List<String>  list = map.get(tmp);
        		list.add(s);
        	}
        }
        return new ArrayList<List<String>>( map.values()); 
	}

}