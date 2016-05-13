/*
208. Implement Trie (Prefix Tree)  

Implement a trie with insert, search, and startsWith methods.

Note:
You may assume that all inputs are consist of lowercase letters a-z.
*/


class TrieNode {
    TrieNode[] children;
    boolean isWord;
    public TrieNode() {
        children = new TrieNode[26];
        isWord = false;
    }
}

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        TrieNode node = root;
        int i = 0;
        while(i < word.length()){
        	char c = word.charAt(i);
        	if(node.children[c - 'a'] == null)
        		node.children[c - 'a'] = new TrieNode();
        	node = node.children[c - 'a'];
        	i++;
        }
        node.isWord = true;
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        return search(root, word, 0, false);
    }

    public boolean search(TrieNode node, String word, int i, boolean searchPrefix){
    	if(word.length() == i )
    		return searchPrefix || node.isWord;
    	char c = word.charAt(i);
    	if(node.children[c-'a'] == null)
    		return false;
    	return search(node.children[c-'a'], word, i + 1, searchPrefix);
    }
    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        return search(root, prefix, 0, true); 
    }
}

// Your Trie object will be instantiated and called as such:
// Trie trie = new Trie();
// trie.insert("somestring");
// trie.search("key");