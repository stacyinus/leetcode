/*

44. Wildcard Matching

Implement wildcard pattern matching with support for '?' and '*'.

'?' Matches any single character.
'*' Matches any sequence of characters (including the empty sequence).

The matching should cover the entire input string (not partial).

The function prototype should be:
bool isMatch(const char *s, const char *p)

Some examples:
isMatch("aa","a") → false
isMatch("aa","aa") → true
isMatch("aaa","aa") → false
isMatch("aa", "*") → true
isMatch("aa", "a*") → true
isMatch("ab", "?*") → true
isMatch("aab", "c*a*b") → false
*/

/*
	DP: dp[i][j] representing whether the first i chars(from index 0 to i-1) in s 
		and first j chars(from index 0 to j - 1) in p matches.
		returning dp[s.length()][p.length()]
		update dp[i][j] : if current char match, then dp[i][j] = dp[i-1][j-1]
						  else if current char in p is '*', dp[i][j] = dp[i - 1][j] || dp[i][j - 1]
						  else dp[i][j] = false;
		initialization of dp[0][j] and dp[i][0]				  
	
*/
public class Solution {
	//DP Solution
	public boolean isMatch(String s, String p) {
		char[] a1 = s.toCharArray();
        char[] a2 = p.toCharArray();
        int m = a1.length, n = a2.length;
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        //initialize dp[0][i]:  match "" with pattern
        for (int i = 1; i <= n; i++) {
        	dp[0][i] = dp[0][i - 1] && a2[i - 1] == '*';
        }
        // no need to initialize dp[i][0] because it's defaulted to false already.
        //update dp[i][j]
        for (int i = 1; i <= m; i++) {
        	for(int j = 1; j <= n; j++) {
        		if (a1[ i- 1] == a2[j - 1] || a2[j - 1] == '?') {
        			dp[i][j] = dp[i-1][j-1];
        		}
        		else if(a2[j - 1] == '*') {
        			dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
        		}
        	}	
        }
        return dp[m][n];
	}
    // normal recursive solution, Time Exceed Limitation for case
    //"abbabaaabbabbaababbabbbbbabbbabbbabaaaaababababbbabababaabbababaabbbbbbaaaabababbbaabbbbaabbbbababababbaabbaababaabbbababababbbbaaabbbbbabaaaabbababbbbaababaabbababbbbbababbbabaaaaaaaabbbbbaabaaababaaaabb"
	//"**aa*****ba*a*bb**aa*ab****a*aaaaaa***a*aaaa**bbabb*b*b**aaaaaaaaa*a********ba*bbb***a*ba*bb*bb**a*b*bb"
    public boolean isMatch(String s, String p) {
    }
        char[] a1 = s.toCharArray();
        char[] a2 = p.toCharArray();
        int i = 0, j = 0;
        return match(a1,0,a2,0);
    }
    private boolean match(char[] a1, int s1, char[] a2, int s2) {
    	while (s1 < a1.length && s2 < a2.length) {
    		if (a1[s1] == a2[s2] || a2[s2] == '?') {
    			s1++;
    			s2++;
    		}
    		else if(a2[s2] != '*') {
    			return false;
    		}
    		else {
    			while (s2 < a2.length && a2[s2] == '*') {
    				s2++;
    			}
    			int newStart = s1;
    			while (newStart < a1.length) {
    				if(match(a1, newStart, a2, s2 + 1)) {
    					return true;
    				}
    				newStart++;
    			}
    			return false;
    		}
    	}
    	if(s1 == a1.length && s2 == a2.length) {
	    	return true;
    	}
    	if(s1 < a1.length && a2.charAt(a2.length - 1) == '*') {
    		return true;
    	}
    	return false;
    }
}