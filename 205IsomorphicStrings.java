/*
205. Isomorphic Strings

Given two strings s and t, determine if they are isomorphic.

Two strings are isomorphic if the characters in s can be replaced to get t.

All occurrences of a character must be replaced with another character while preserving the order of characters. 
No two characters may map to the same character but a character may map to itself.

For example,
Given "egg", "add", return true.

Given "foo", "bar", return false.

Given "paper", "title", return true.
*/
public class 205IsomorphicStrings {
	//use hashmap(33ms):idea is to convert s to t with the map.
    public boolean isIsomorphic(String s, String t) {
	        if(s==null||t==null||s.length()!=t.length())
	        	return false;
	        HashMap<Character,Character> map = new HashMap<Character,Character>();
	        for(int i=0;i<s.length();i++){
	        	if(!map.containsKey(s.charAt(i)))
	        		if(!map.values().contains(t.charAt(i)))
	        			map.put(s.charAt(i),t.charAt(i));
	        		else
	        			return false;
	        	if(map.containsKey(s.charAt(i))&&map.get(s.charAt(i))!=t.charAt(i))
	        			return false;
	        }
	        return true;        
    }	  
    //find the next apperence of the current char 
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) return false;
        if (s.length() == 0) return true;
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.indexOf(s.charAt(i), i + 1) != t.indexOf(t.charAt(i), i + 1)) {
                return false;
            }
        }
        return true;
    }    
}