/*
139. Word Break

Given a string s and a dictionary of words dict, determine if s can be segmented into a space-separated sequence of one or more dictionary words.

For example, given
s = "leetcode",
dict = ["leet", "code"].

Return true because "leetcode" can be segmented as "leet code".
*/
/*
	DP: dp array stores bolean values that represents whether the first i characters can be segmented.
		then dp[i] = for each j from 0 to i, if (dp[j] == true) && substring(j-i) can be found in dict
	
	Time: O(n2)
*/
public class Solution {
    public boolean wordBreak(String s, Set<String> wordDict) {
    	if(s == null || s.length() == 0 || wordDict == null || wordDict.size() == 0)
    		return false;
    	boolean[] dp = new boolean[s.length()+1];
    	dp[0] = true; //this is a dummy value, used to help calculate the real first value, which is dp[1]
    				// becuase to calculate the REAL dp[0], you need to check if the first letter is in the dict
    				// and this is the same way to check the rest of dp[i]
    	for(int i = 1; i <= s.length(); i++){
    		for(int j = 0; j < i; j++){
    			if(dp[j] && wordDict.contains(s.substring(j, i))){
    				dp[i] = true;
    				break;
    			}
    		}
    	}
    	return dp[s.length()];
    }	

    // optimized
    public boolean wordBreak(String s, Set<String> wordDict) {
    	if(s == null || s.length() == 0 || wordDict == null || wordDict.size() == 0)
    		return false;
    	boolean[] dp = new boolean[s.length()+1];
    	dp[0] = true; 
    	int min = Integer.MAX_VALUE, max = 0;// get the min length of word and max length of word in dict
    										// this is used to optimize the function.
        for(String str : wordDict) {
            min = Math.min(min, str.length());
            max = Math.max(max, str.length());
        }
    	for(int i = min; i <= s.length(); i++){
    		for(int j = i - min; j >= 0 && i - j <= max ; j--){
    			if(dp[j] && wordDict.contains(s.substring(j, i))){
    				dp[i] = true;
    				break;
    			}
    		}
    	}
    	return dp[s.length()];
    }    

}