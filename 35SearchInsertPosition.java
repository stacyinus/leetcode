/*
35. Search Insert Position
Given a sorted array and a target value, return the index if the target is found. 
If not, return the index where it would be if it were inserted in order.

You may assume no duplicates in the array.

Here are few examples.
[1,3,5,6], 5 → 2
[1,3,5,6], 2 → 1
[1,3,5,6], 7 → 4
[1,3,5,6], 0 → 0
*/

public class 35SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        return searchInsert(nums,target,0,nums.length-1);
    }
	private int searchInsert(int[] nums, int target, int s, int e){
		if(s==e)
			return nums[s]>=target?s:s+1;
		int mid = s+(e-s)/2;
		if(nums[mid]==target)
			return mid;
		if(nums[mid]>target)	
			return searchInsert(nums,target,s,mid);
		else
			return searchInsert(nums,target,mid+1,nums.length-1);
	}
}