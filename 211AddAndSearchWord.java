/*
211. Add and Search Word - Data structure design

Design a data structure that supports the following two operations:

void addWord(word)
bool search(word)
search(word) can search a literal word or a regular expression string containing only letters a-z or .. A . means it can represent any one letter.

For example:

addWord("bad")
addWord("dad")
addWord("mad")
search("pad") -> false
search("bad") -> true
search(".ad") -> true
search("b..") -> true
Note:
You may assume that all words are consist of lowercase letters a-z.
*/

public class WordDictionary {
	Set<String> set = new HashSet<String>();

    // Adds a word into the data structure.
    public void addWord(String word) {
        set.add(word);
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        if(!word.contains("."))
        	return set.contains(word);
        for(String s : set){
        	if(s.length() == word.length()){
        		int i = 0;
        		for(; i < s.length(); i++){
        			if(word.charAt(i) == '.')
        				continue;
        			if(word.charAt(i) != s.charAt(i))
        				break;
        		}
        		if(i == s.length())
        			return true;
        	}
        }
        return false;
    }
}

// Your WordDictionary object will be instantiated and called as such:
// WordDictionary wordDictionary = new WordDictionary();
// wordDictionary.addWord("word");
// wordDictionary.search("pattern");