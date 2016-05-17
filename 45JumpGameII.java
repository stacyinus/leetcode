/*
45. Jump Game II

Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Your goal is to reach the last index in the minimum number of jumps.

For example:
Given array A = [2,3,1,1,4]

The minimum number of jumps to reach the last index is 2. (Jump 1 step from index 0 to 1, then 3 steps to the last index.)

Note:
You can assume that you can always reach the last index.

Subscribe to see which companies asked this question
*/

public class Solution {
	//DP: this is not the fastest approach
    public int jump(int[] nums) {
        int[] tmp = new int[nums.length];
        Arrays.fill(tmp , 0);	
        for(int i = nums.length - 2; i >= 0; i--){
        	int j = nums.length - 1;
        	while( j > i ){
        		if((tmp[j] != 0 || j == nums.length - 1 ) && nums[i] +  i >= j)
        			tmp[i] = ( tmp[i] == 0 || tmp[i] > 1 + tmp[j] )? 1 + tmp[j] : tmp[i];
        		j--;
        	}
        }
        return tmp[0]; 
    }
}