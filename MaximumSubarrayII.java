/*
Maximum Subarray II

Given an array of integers, find two non-overlapping subarrays which have the largest sum.
The number in each subarray should be contiguous.
Return the largest sum.

The subarray should contain at least one number

Example
For given [1, 3, -1, 2, -1, 2], the two subarrays are [1, 3] and [2, -1, 2] or [1, 3, -1, 2] and [2], they both have the largest sum 7.
*/


/*
	DP: use 2 dp arrays to sovle this problem. 
		dp1: start from beginning of the array, at each position i, the largest sum it can get(doesn't have to include value at i)
		dp2: start from end of the array, at each position i, the largest sum it can get(doesn't have to include value at i)
		loop through dp1 and dp2, find the sum that is biggest.
	Time: O(n)
	Space: O(n)
*/	
public class Solution {
    /**
     * @param nums: A list of integers
     * @return: An integer denotes the sum of max two non-overlapping subarrays
     */
    public int maxTwoSubArrays(ArrayList<Integer> nums) {
        if( nums == null || nums.size() == 0 )
        	return 0;
        int[] maxFront = new int[nums.size()];
        int sumFront = nums.get(0);
        maxFront[0] = nums.get(0);
        int[] maxEnd = new int[nums.size()];
        int sumEnd = nums.get(nums.size()-1);
        maxEnd[nums.size()-1] = nums.get(nums.size()-1);
        for(int i = 1; i < nums.size(); i++){
        	sumFront = Math.max(sumFront+nums.get(i), nums.get(i));
        	maxFront[i] = Math.max(sumFront, maxFront[i-1]);
        }
        System.out.println(Arrays.toString(maxFront));
        for(int i = nums.size() - 2; i >= 0; i--){
        	sumEnd = Math.max(sumEnd+nums.get(i), nums.get(i));
        	maxEnd[i] = Math.max(sumEnd, maxEnd[i+1]);
        }
        System.out.println(Arrays.toString(maxEnd));
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < nums.size() - 1; i++)
        	max = Math.max(max,maxFront[i] + maxEnd[i+1]);
        return max;
    }
}