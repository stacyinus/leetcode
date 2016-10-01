/*
336. Palindrome Pairs 

Given a list of unique words. Find all pairs of distinct indices (i, j) in the given list, 
so that the concatenation of the two words, i.e. words[i] + words[j] is a palindrome.

Example 1:
Given words = ["bat", "tab", "cat"]
Return [[0, 1], [1, 0]]
The palindromes are ["battab", "tabbat"]
Example 2:
Given words = ["abcd", "dcba", "lls", "s", "sssll"]
Return [[0, 1], [1, 0], [3, 2], [2, 4]]
The palindromes are ["dcbaabcd", "abcddcba", "slls", "llssssll"]
*/

/*
	["abcd", "dcba", "lls", "s", "sssll"]
	"s"
	"lls"
	"abcd" , "dcba"
	"sssll"

	["a","abc","aba",""]
*/
public class Solution {
	class TrieNode {
		TrieNode[] next;
		int i;
		List<Integer> list;

		public TrieNode () {
			next = new TrieNode[256];
			list = new ArrayList<Integer>();
			i = -1;
		}

		public void insert(String s, int i) {
			if (s.length() == 0) {
				this.i = i;
				return;
			}
			if (isPalindrome(s)) {
				list.add(i);
			}
			char c = s.charAt(s.length() - 1);
			if (next[c] == null) next[c] = new TrieNode();
			next[c].insert(s.substring(0, s.length() - 1), i);
		}

		public void search(List<List<Integer>> result, String s, int i) {
			if (s.length() == 0) {
			    if (this.i != -1 && this.i != i) {
					result.add(Arrays.asList(i, this.i));
				}
				for (Integer j : this.list) {
					result.add(Arrays.asList(i, j));
				}
				return;
			} 
			char c = s.charAt(0);
			String rest = s.substring(1);			
			if (this.i != -1) {
				// if (this.list.contains(i)) {
				// 	result.add(Arrays.asList(i, this.i));
				// }
				if (isPalindrome(rest)) {
					result.add(Arrays.asList(i, this.i));
				}
			}
			if (next[c] == null) return;
			next[c].search(result, s.substring(1), i);			
		}

		private boolean isPalindrome (String s) {
			int i = 0, j = s.length() - 1;
			while (i < j) {
				if (s.charAt(i) != s.charAt(j)) return false;
				i++;
				j--;
			}
			return true;
		}		
	}

	class Trie {
		TrieNode root;
		public Trie() {
			root = new TrieNode();
		}
		public void insert(String s, int i) {
			root.insert(s, i);
		}

		public void search(List<List<Integer>> result, String s, int i) {
			root.search(result, s, i);
		}

	}
    public List<List<Integer>> palindromePairs(String[] words) {
    	List<List<Integer>> result = new ArrayList<List<Integer>>();
    	if (words == null) return result;
    	Trie trie = new Trie();
    	for (int i = 0; i < words.length; i++) {
    		trie.insert(words[i], i);
    	}
    	for (int i = 0; i < words.length; i++) {
			trie.search(result, words[i], i );
    	}
    	return result;
    }
}