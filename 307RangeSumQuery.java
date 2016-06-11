/*
307. Range Sum Query - Mutable  
Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.

The update(i, val) function modifies nums by updating the element at index i to val.
Example:
Given nums = [1, 3, 5]

sumRange(0, 2) -> 9
update(1, 2)
sumRange(0, 2) -> 8
Note:
The array is only modifiable by the update function.
You may assume the number of calls to update and sumRange function is distributed evenly.
*/

public class NumArray {
	private int[] nums;
	private int[] sums;
    public NumArray(int[] nums) {
    	if(nums == null)
    		this.nums = null;
       	nums = new int[nums.length];
       	this.sums = new int[nums.length];
       	this.nums[0] = nums[0];
       	sums[0] = nums[0];
       	for(int i = 1; i< nums.length; i++){
       		this.nums[i] = nums[i];
       		this.sums[i] = nums[i] + sums[i-1];
       	}
    }

    void update(int i, int val) {
        int tmp = nums[i];
        for(int index = i; index < sums.length; index++)
	        sums[i] += (val - tmp);
        nums[i] = val;

    }

    public int sumRange(int i, int j) {
        return sums[j] - sums[i] + nums[i];
    }
}


// Your NumArray object will be instantiated and called as such:
	// NumArray numArray = new NumArray(nums);
	// numArray.sumRange(0, 1);
	// numArray.update(1, 10);
	// numArray.sumRange(1, 2);