/*
Given a list of words and two words word1 and word2, return the shortest distance between these two words in the list.

For example,
Assume that words = ["practice", "makes", "perfect", "coding", "makes"].

Given word1 = "coding", word2 = "practice", return 3.
Given word1 = "makes", word2 = "coding", return 1.

Note:
You may assume that word1 does not equal to word2, and word1 and word2 are both in the list.
*/

public class 243ShortestWordDistance{
	public int getShortestWordDistance(String[] list, String w1, String w2){
		int[] x = new int[2]{-1,-1};
		int l = Integer.MAX_VALUE;
		for(int i=0;i<list.length;i++){
			if (list[i].equals(w1)) 
				x[0]=i;
			else if (list[i].equals(w2)) 
				x[1]=i;
			else
				continue;
			if(x[0]!=-1&&x[1]!=-1)
				l = Math.min(l,Math.abs(x[0]-x[1]));
		}
		return l;
	}
}