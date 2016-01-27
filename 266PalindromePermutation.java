/*
Given a string, determine if a permutation of the string could form a palindrome.
For example,
"code" -> False, "aab" -> True, "carerac" -> True.
*/

public class 266PalindromePermutation {
    public boolean canPermutePalindrome(String s) {
    	if(s==null)
    		return false;
    	HashSet<Character> set = new HashSet<Character>();
    	for(int i = 0;i<s.length();i++){
    		char c = s.charAt(i);
    		if(!set.contains(c))
    			set.add(c);
    		else
    			set.remove(c);
    	} 
    	return (set.size()==1||set.size()==0);
    }
}	