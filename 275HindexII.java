/*
275. H-Index II   My Submissions QuestionEditorial Solution
Total Accepted: 21950 Total Submissions: 67546 Difficulty: Medium
Follow up for H-Index: What if the citations array is sorted in ascending order? Could you optimize your algorithm?

Hint:

Expected runtime complexity is in O(log n) and the input is sorted.
*/

/*
    understand what h index means: 
    	in a sorted array [2 7 8 9], 
        if(citations[i] >= l-i) , h index = l - i;
	
*/
public class Solution {
	//front to end
    public int hIndex(int[] citations) {
    	if(citations == null || citations.length == 0)
    		return 0;
        int l = citations.length;
        for(int i = 0; i < l; i++ ){
            if(citations[i] >= l-i)
                return l - i;
        }
        return 0;
    }
    //end to front
    public int hIndex(int[] citations) {
        int count = 0;
        for(int i = citations.length - 1; i >= 0; i-- ){
            if(citations[i] > count)
                count++;
            else
                break;
        }
        return count;
    }    
}