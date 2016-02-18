/*
Leetcode: Shortest Word Distance III

This is a follow up of Shortest Word Distance. The only difference is now word1 could be the same as word2.
Given a list of words and two words word1 and word2, return the shortest distance between these two words in the list.
word1 and word2 may be the same and they represent two individual words in the list.
For example,
Assume that words = ["practice", "makes", "perfect", "coding", "makes"].
Given word1 = “makes”, word2 = “coding”, return 1.
Given word1 = "makes", word2 = "makes", return 3.
Note:
You may assume word1 and word2 are both in the list.
*/
public class 245ShortestWordDistance{
	public int getShortestWordDistance(String[] list, String w1, String w2){
		int i1=-1;
		int i2=-1;
		int d = Math.MAX_VALUE;
		for(int i=0;i<list.length;i++){
			if(w1.euqals(w2)&&i1!=i2)
				i2=i1;
			if(w1.euqals(list[i]))
				i1=i;
			else if(w2.equals(list[i]))
				i2=i;
			else
				 continue;
			if(i1!=-1&&i2!=-1&&i1!=i2&&d>Math.abs(i2-i1))
				d = Math.abs(i2-i1);

		}
		return d;
	}
}