/*
Given two strings s and t, write a function to determine if t is an anagram of s.

For example,
s = "anagram", t = "nagaram", return true.
s = "rat", t = "car", return false.

Note:
You may assume the string contains only lowercase alphabets.
*/


public class 242ValidAnagram {
    //use hashmap
    public boolean isAnagram(String s, String t) {
    	if(s.length() != t.length() )
		    return false;
		HashMap<Character,Integer> map = new HashMap<Character, Integer>();
	    char[] a = s.toCharArray();
    	for( char x: a )
    	{
    		if(!map.containsKey(x))
    			map.put(x,0);
    		else
    			map.put(x,map.get(x)+1 );
    	}
    	char[] b = t.toCharArray();
    	for( char x: b )
    	{
    		if(!map.containsKey(x))
    			return false;
    		if(map.get(x)==0)
    			map.remove(x);
    		else
    			map.put(x,map.get(x)-1);
    	}
    	if(map.isEmpty())
    		return true;
    	return false;
    }
    //bitwise
    public boolean isAnagram2(String s, String t) {
    	if(s==null||t==null||s.length()!=t.length())
    		return false;
    	HashMap<Character,Integer>  map = new HashMap<Character,Integer>();
    	for(int i=0;i<s.length();i++){
    		char c = s.charAt(i);
    		if(map.containsKey(c))
    			map.put(c,map.get(c)+1);
    		else
    			map.put(c,0);

    	}
    	for(int i=0;i<t.length();i++){
    		char c = t.charAt(i);
    		if(!map.containsKey(c))
    			return false;
    		if(map.get(c)==0)
    			map.remove(c);
    		else
    			map.put(c,map.get(c)-1);
    	}
    	return map.isEmpty();
    }
}