/*
140. Word Break II 

Given a string s and a dictionary of words dict, add spaces in s to construct a sentence where each word is a valid dictionary word.

Return all such possible sentences.

For example, given
s = "catsanddog",
dict = ["cat", "cats", "and", "sand", "dog"].

A solution is ["cats and dog", "cat sand dog"].
*/

/*
	DP memory search: recursively search 

*/


public class Solution {
	HashMap<String, List<String>> map = new HashMap<String, List<String>>();
    public List<String> wordBreak(String s, Set<String> wordDict) {
        if(s == null|| s.length() == 0 || wordDict == null || wordDict.size() == 0)
        	return new ArrayList<String>();
    	int min = Integer.MAX_VALUE, max = 0;// get the min length of word and max length of word in dict
    										// this is used to optimize the search function. 
        for(String str : wordDict) {
            min = Math.min(min, str.length());
            max = Math.max(max, str.length());
        }
        return helper(s, wordDict, min, max);
    }

    public List<String> helper(String s, Set<String> wordDict, int min, int max){
    	if(map.containsKey(s))
    		return map.get(s);
    	List<String> list = new ArrayList<String>();
    	if(wordDict.contains(s))
    		list.add(s);
    	for(int i = min; i <= s.length() && i <= max; i++){
    		if(wordDict.contains(s.substring(0,i))){
    			List<String> tmp = helper(s.substring(i), wordDict, min, max);
    			for(String sen : tmp){
    				list.add(s.substring(0,i) + " " + sen);
    			}
	    	}
   		}
   		map.put(s, list);
   		return list;
    }
}