/*
The Smallest Difference

Given two array of integers(the first array is array A, the second array is array B),
now we are going to find a element in array A which is A[i], 
and another element in array B which is B[j], so that the difference 
between A[i] and B[j] (|A[i] - B[j]|) is as small as possible, 
return their smallest difference.

Example
For example, given array A = [3,6,7,4], B = [2,8,9,3], return 0
*/

/*
    Time O(nlogn)
    Space O(1)
    Method 1. Sort, and use 2 pointers for each array.
    Method 2. Sort, and use binary search. 
*/

public class Solution {
    /**
     * @param A, B: Two integer arrays.
     * @return: Their smallest difference.
     */

    public int smallestDifference(int[] A, int[] B) {
        Arrays.sort(A);
        Arrays.sort(B);
        int val = Integer.MAX_VALUE;
        int i = 0, j = 0;
        while( i < A.length && j < B.length){        
            if(A[i]>B[j]){
                val = Math.min(val, A[i] - B[j]);
                j++;
            }
            else{
                val = Math.min(val, B[j] - A[i]);
                i++;
            }
        }
        return val;
    }    
    public int smallestDifference(int[] A, int[] B) {
        Arrays.sort(A);
        Arrays.sort(B);
        int val = Integer.MAX_VALUE;
        for(int i = 0; i < A.length; i++)
        	val = Math.min(val, findSmallestDiff(B,A[i]));
        return val;
    }
    public int findSmallestDiff(int[] a, int v){
    	int i = 0, j = a.length - 1, m = i + ( j - i )/2;
    	while( i + 1 < j ){
    		if(a[m] == v)
    			return 0;
    		if(a[m] > v)
    			j = m;
    		else
    			i = m;
    		m = i + ( j - i )/2;
    	}
    	int diff = Math.abs(a[i] - v);
    	if( diff > Math.abs(a[j] - v))
    		return Math.abs(a[j] - v);
    	return diff;
    }
}
