/*
An abbreviation of a word follows the form <first letter><number><last letter>. Below are some examples of word abbreviations:
a) it                      --> it    (no abbreviation)

     1
b) d|o|g                   --> d1g

              1    1  1
     1---5----0----5--8
c) i|nternationalizatio|n  --> i18n

              1
     1---5----0
d) l|ocalizatio|n          --> l10n
Assume you have a dictionary and given a word, find whether its abbreviation is unique in the dictionary. 
A word's abbreviation is unique if no other word from the dictionary has the same abbreviation.
Example: 
Given dictionary = [ "deer", "door", "cake", "card" ]

isUnique("dear") -> false
isUnique("cart") -> true
isUnique("cane") -> false
isUnique("make") -> true
*/
public class ValidWordAbbr {
	HashMap<String,String> map = new HashMap<String,String>();
    public ValidWordAbbr(String[] dictionary) {
    	if(dictionary!=null)
	    	for(int i=0;i<dictionary.length;i++){
	    		String key = getAbbr(dictionary[i]);
	    		if(dictionary.containsKey(key))
	    			map.put(key,"");
	    		else
	    			map.put(key,dictionary[i]);
	    	}
    }
    public boolean isUnique(String word) {	
    	String key = getAbbr(word);
    	if(map.containsKey(key))
    		return key.equals(map.get(key));
    	return false;
    }
    private String getAbbr(String s){
    	if(s==null||s.length()<=2)
    		return s;
    	StringBuilder sb = new StringBuilder();
    	return sb.append(s.charAt(0)).append(Integer.toString(s.length()-2)).append(s.charAt(s.length-1));
    }
// Your ValidWordAbbr object will be instantiated and called as such:
// ValidWordAbbr vwa = new ValidWordAbbr(dictionary);
// vwa.isUnique("Word");
// vwa.isUnique("anotherWord");    
}    