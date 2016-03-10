/*
33. Search in Rotated Sorted Array

Suppose a sorted array is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

You are given a target value to search. If found in the array return its index, otherwise return -1.

You may assume no duplicate exists in the array.
*/

public class Solution {
    public int search(int[] nums, int target) {
        int s = findStart(nums,0,nums.length-1);
        return bSearch(nums,target,s,s-1<0?nums.length-1:s-1);
    }

    private int findStart(int[] a, int s, int e){
    	if(a[s]<a[e]||s==e)
    		return s;
    	int mid = s+(e-s)/2;
    	if(s==mid)
    		return a[s]>a[e]?e:s;
    	if(a[s]<a[mid])
    		return findStart(a, mid+1,e);
    	return findStart(a,s,mid);
    }
    private int bSearch(int[] a, int t, int s, int e, int l){
    	if(s==e)
    		return a[s]==t?s:-1;
    	int mid = s+(l-1)/2>a.length-1?s+(l-1)/2-(a.length-1):s+(l-1)/2;	
	    if(a[mid]==t)
    		return mid;
    	if(a[mid]>t){
    		l = mid<s?mid-s+l:mid-s;
    		return l==0||bSearch(a,t,s,mid-1<0?a.length-1:mid-1,l);
    	}
    	else
    		l = e<mid?e-mid+l:e-mid;
    	return l==0||bSearch(a,t,mid+1==a.length?0:mid+1,e,l);
    }
}