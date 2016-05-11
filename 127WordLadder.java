/*
127. Word Ladder

Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest transformation sequence 

from beginWord to endWord, such that:

Only one letter can be changed at a time
Each intermediate word must exist in the word list
For example,

Given:
beginWord = "hit"
endWord = "cog"
wordList = ["hot","dot","dog","lot","log"]
As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
return its length 5.

Note:
Return 0 if there is no such transformation sequence.
All words have the same length.
All words contain only lowercase alphabetic characters.
*/


//This is a BFS problem because: 
public class Solution {
    public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
    	int len = 1;
    	Queue<String> q = new LinkedList<String>();
    	q.offer(beginWord);
    	wordList.remove(beginWord);
   		while(!q.isEmpty()){
   			int size = q.size();
	   		for(int k = 0; k < size; k++){
	    		String str = q.poll();
	    		for(int i = 0; i < str. length() ;i++){
	    			for(char c = 'a' ; c < 'z'; c+=1){
	    				if(str.charAt(i) == c) continue;
	    				String tmp = replace(str, i, c);
	    				if(endWord.equals(tmp))
	    					return len + 1;
	    				if(wordList.contains(tmp)){
	    					q.offer(tmp);
	    					wordList.remove(tmp);
	    				}
	    			}
	    		}
	    	}
	    	len += 1;	
   		}
   		return 0;
    }

    private String replace(String str, int pos, char c){
    	char[] a = str.toCharArray();
    	a[pos] = c;
    	return new String(a);
    }
}	