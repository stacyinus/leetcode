/*
212. Word Search II

Given a 2D board and a list of words from the dictionary, find all words in the board.

Each word must be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally 
or vertically neighboring. The same letter cell may not be used more than once in a word.

For example,
Given words = ["oath","pea","eat","rain"] and board =

[
  ['o','a','a','n'],
  ['e','t','a','e'],
  ['i','h','k','r'],
  ['i','f','l','v']
]
Return ["eat","oath"].
Note:
You may assume that all inputs are consist of lowercase letters a-z.

click to show hint.

You would need to optimize your backtracking to pass the larger test. Could you stop backtracking earlier?

If the current candidate does not exist in all words' prefix, you could stop backtracking immediately. 
What kind of data structure could answer such query efficiently? Does a hash table work? 
Why or why not? How about a Trie? If you would like to learn how to implement a basic trie, please work on this problem: Implement Trie (Prefix Tree) first.
*/

public class Solution {
    /**
     * @param board: A list of lists of character
     * @param words: A list of string
     * @return: A list of string
     */
     class TrieNode{
         HashMap<Character, TrieNode> map;
         boolean isword;
         
         public TrieNode(){
             map = new HashMap<Character, TrieNode>(); 
             isword = false;
         }
     }
     class Trie{
         TrieNode root;
         public Trie(TrieNode root){
             this.root = root;
         }
         
         public List<Character> getBeginningChars(){
             return new ArrayList<Character>(root.map.keySet());
         }
         
         public void printTrie(){
            TrieNode tmp = root;
         }
         public void addWord(String word){
             TrieNode tmp = root;
             for(int i = 0; i < word.length(); i++){
                if(!tmp.map.containsKey(word.charAt(i)))
                    tmp.map.put(word.charAt(i), new TrieNode());
                tmp = tmp.map.get(word.charAt(i));
             }
             tmp.isword = true;
         }
        public void search(char[][] board, TrieNode node, ArrayList<String> result, int x , int y, String s){
            if(x < 0 || x > board.length - 1|| y < 0 || y > board[0].length - 1 )
                return;
            Character c = board[x][y];
            if(!node.map.containsKey(c))
                return;
            s += c;
            TrieNode tmp = node.map.get(c);
            if(tmp.isword && !result.contains(s))
                result.add(s);   
            board[x][y] ^= 256;
            search(board, tmp, result, x-1, y, s);
            search(board, tmp, result, x+1, y, s);
            search(board, tmp, result, x, y-1, s);
            search(board, tmp, result, x, y+1, s);
            board[x][y] ^= 256;
        }
     }
    public ArrayList<String> wordSearchII(char[][] board, ArrayList<String> words) {
        ArrayList<String> result = new ArrayList<String>();
        if(board == null || board.length == 0 || board[0].length == 0 || words == null || words.size() == 0)
            return result;
        Trie trie = new Trie(new TrieNode());
        for(String word: words)
            trie.addWord(word);
        List<Character> list = trie.getBeginningChars();   
        for(int i = 0; i < board.length; i++)
            for(int j = 0; j < board[0].length; j++){
                if(list.contains(board[i][j]))
                   trie.search(board, trie.root, result, i, j , "");
            }
        return result;
    }
    

}