/*
290. Word Pattern
Given a pattern and a string str, find if str follows the same pattern.

Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in str.

Examples:
pattern = "abba", str = "dog cat cat dog" should return true.
pattern = "abba", str = "dog cat cat fish" should return false.
pattern = "aaaa", str = "dog cat cat dog" should return false.
pattern = "abba", str = "dog dog dog dog" should return false.
Notes:
You may assume pattern contains only lowercase letters, and str contains lowercase letters separated by a single space.
*/

public class 290WordPattern {
    public boolean wordPattern(String pattern, String str) {
     	HashMap<Character,String> map = new HashMap<Character,String>();
     	String[] words = str.trim().split(" ");
     	if(words.length<pattern.length()) return false;
     	int i=0;
     	int j=0;
     	while(i<words.length&&j<pattern.length()){
     		if(words[i]==""){
     			i++;
     			continue;
     		} 
     		char c = pattern.charAt(j);
     		if(!map.containsKey(c)){
     			if(map.values().contains(words[i]))
     				return false;
				map.put(c,words[i]);
	     		i++;
	     		j++;     					
     		}
     		else{
     			if(!map.get(c).equals(words[i]))
     				return false;
     			i++;
     			j++;
     		}
     	}
     	return (i==words.length&&j==pattern.length());   
    }
    
}