/*
34. Search for a Range
Given a sorted array of integers, find the starting and ending position of a given target value.

Your algorithm's runtime complexity must be in the order of O(log n).

If the target is not found in the array, return [-1, -1].

For example,
Given [5, 7, 7, 8, 8, 10] and target value 8,
return [3, 4].
*/
public class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] range = new int[2];
       	if(nums == null||nums.length == 0)
       		return new int[]{-1,-1};
        int s = 0, e = nums.length-1;
        //find start
        while(s+1<e){
        	int m = s+ (e-s)/2;
        	if(nums[m]>=target)
        		e = m;
        	else
        		s = m;
        }
        if(nums[s] == target)
        	range[0] = s;
        else if(nums[e]==target)
        	range[0] = e;
        else{
        	return new int[]{-1,-1};
        }
        //find end
        s = 0, e = nums.length-1;
        while(s+1<e){
        	int m = s+ (e-s)/2;
        	if(nums[m]<=target)
        		s = m;
        	else
        		e = m;
        }
        if(nums[e] == target)
        	range[1] = e;
        else if(nums[s]==target)
        	range[1] = s;
        return range;
    }
}