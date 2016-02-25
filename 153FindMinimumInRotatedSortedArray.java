/*
153. Find Minimum in Rotated Sorted Array

Suppose a sorted array is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

Find the minimum element.

You may assume no duplicate exists in the array.
*/

public class Solution {
	//this is a stupid O(n) solution that you can think of using your ass....
    public int findMin(int[] nums) {
    	int min = nums[0];
        for(int i=0;i<nums.length-1;i++){
        	if(nums[i+1]<nums[i])
        		return nums[i+1];
        }
        return min;
    }
    //Now O(nlogn)
    public int findMin(int[] nums) {
    	int s = 0;
    	int e = nums.length-1;
    	while(s<=e){
    		if(nums[s]<=nums[e])
    			return nums[s];
    		int mid = s+(e-s)/2;
    		if(nums[s]>nums[mid])
    			e=mid;
    		else
    			s = mid+1;
    	}
    	return Integer.MIN_VALUE;
    }
}