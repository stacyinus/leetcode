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


//This is a BFS problem because you are trying to find the shortest path. 
public class Solution {
	//Version  2 : 2 sides BFS
    public int ladderLength(String start, String end, Set<String> dict) {
        // write your code here
        Set<String> s1 = new HashSet<String>();
        Set<String> s2 = new HashSet<String>();
        if(start.equals(end))
            return 1;
        s1.add(start);
        s2.add(end);
        return helper(s1,s2,dict,1);
    }
    
    private int helper( Set<String> s1,  Set<String> s2,  Set<String> dict, int len){
        if(s1.isEmpty()||s2.isEmpty())
            return 0;
        Set<String> tmp = new HashSet<String>();
            for(String s: s1){
                for(int i = 0; i < s.length(); i++){
                    char[] array = s.toCharArray();
                    for(char c = 'a';c<'z';c++){
                        if(array[i] == c)
                            continue;
                        array[i] = c;
                        String stmp = new String(array);
                        if(s2.contains(stmp))
                            return len+1;
                        if(dict.contains(stmp)){
                            dict.remove(stmp);
                            tmp.add(stmp);    
                        }
                    }    
                }
            }
            return helper(s2, tmp, dict, len+1);
    }

    //Version 1 : BFS
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