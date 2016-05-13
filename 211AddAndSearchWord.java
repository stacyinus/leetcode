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
	class Trie {
		Node root;

		Trie() {
			root = new Node();
		}

		public void addWord(String s) {
			Node tmp = root;
			int i = 0;
			while (i < s.length()) {
				char c = s.charAt(i);
				if (tmp.children[c - 'a'] == null)
					tmp.children[c - 'a'] = new Node();
				tmp = tmp.children[c - 'a'];
				i++;
			}
			tmp.isLeaf = true;
		}

		public boolean search(String s) {
			return search(root, s, 0);
		}

		public boolean search(Node node, String s, int i) {
			if (i == s.length())
				return node.isLeaf;
			char c = s.charAt(i);
			if (c == '.') {
				for (Node tmp : node.children)
					if (tmp != null && search(tmp, s, i + 1))
						return true;
				return false;
			} else if (node.children[c - 'a'] == null)
				return false;
			return search(node.children[c - 'a'], s, i + 1);
		}
	}

	class Node {
		Node[] children;
		boolean isLeaf;

		public Node() {
			children = new Node[26];
			isLeaf = false;
		}
	}

	Trie trie = new Trie();

	// Adds a word into the data structure.
	public void addWord(String word) {
		trie.addWord(word);
	}

	// Returns if the word is in the data structure. A word could
	// contain the dot character '.' to represent any one letter.
	public boolean search(String word) {
		return trie.search(word);
	}
}

// Your WordDictionary object will be instantiated and called as such:
// WordDictionary wordDictionary = new WordDictionary();
// wordDictionary.addWord("word");
// wordDictionary.search("pattern");