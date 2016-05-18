/*
162. Find Peak Element

A peak element is an element that is greater than its neighbors.

Given an input array where num[i] ≠ num[i+1], find a peak element and return its index.

The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.

You may imagine that num[-1] = num[n] = -∞.

For example, in array [1, 2, 3, 1], 3 is a peak element and your function should return the index number 2.
*/

public class Solution {
    //second round using template.
    public int findPeakElement(int[] nums) {
        int s = 0, e = nums.length - 1;
        while(s + 1 < e){
            int m = s + (e - s)/2;
            if(nums[m] > nums[m-1] && nums[m] > nums[m+1])
                return m;
            else if(nums[m] > nums[m-1])
                s = m;
            else
                e = m;
        }
        if( nums[s] > nums[e] )
            return s;
        return e;
    }

    public int findPeakElement(int[] nums) {
        int s=0, e=nums.length-1, mid=0;
        while(s<=e){
        	if(s==e)
        		return s;
        	mid = s+ (e-s)/2;
        	if(mid ==0 )
        		return nums[mid+1]>nums[mid]?mid+1:mid;
        	if(nums[mid+1]<nums[mid]&&nums[mid-1]<nums[mid])
        		return mid;
        	if(nums[mid-1]>nums[mid])
        		e = mid-1;
        	else
        		s = mid+1;
        }
        return -1;
    }
}