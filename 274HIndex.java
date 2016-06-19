/*
274. H-Index

Given an array of citations (each citation is a non-negative integer) of a researcher, write a function to compute the researcher's h-index.

According to the definition of h-index on Wikipedia: "A scientist has index h if h of his/her N papers have at least h citations each, 

and the other N − h papers have no more than h citations each."

For example, given citations = [3, 0, 6, 1, 5], which means the researcher has 5 papers in total and each of them 

had received 3, 0, 6, 1, 5 citations respectively. Since the researcher has 3 papers with at least 3 citations each 

and the remaining two with no more than 3 citations each, his h-index is 3.

Note: If there are several possible values for h, the maximum one is taken as the h-index.

Hint:

An easy approach is to sort the array first.
What are the possible values of h-index?
A faster approach is to use extra space.
*/
/*
    understand what h index means: in a sorted array [2 7 8 9], 
                                    if(citations[i] >= l-i) , h index = l - i;

*/

public class Solution {
    //no sort: O(n)
    public int hIndex(int[] citations) {
        if(citations == null || citations.length == 0)
            return 0;
        int max = 0, l = citations.length;
        int[] tmp = new int[l+1];
        for(int i = 0; i < l; i++ ){
            if(citations[i] > l)
                tmp[l] += 1;
            else
                tmp[citations[i]] += 1;
        }
        int h = 0;
        for(int i = l; i >= 0; i--){
            if(i < l)
                tmp[i] += tmp[i+1];
            if(tmp[i] >= i)
                return i;
        }
        return 0;
    }    
    //Sort: O(nlogn)
    public int hIndex(int[] citations) {
    	if(citations == null || citations.length == 0)
    		return 0;
        Arrays.sort(citations);
        int l = citations.length;
        for(int i = 0; i < l; i++ ){
            if(citations[i] >= l-i)
                return l - i;
        }
        return 0;
    }
}