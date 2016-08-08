    /*
55. Jump Game  
Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Determine if you are able to reach the last index.

For example:
A = [2,3,1,1,4], return true.

A = [3,2,1,0,4], return false.

Subscribe to see which companies asked this question

*/

public class Solution {
	//fastest greedy method
    public boolean canJump(int[] nums) {
    	if(nums == null || nums.length <= 1)
    		return true;
    	int i = nums.length -1, j = i - 1;
    	while( j > 0){
    		if(nums[j] + j >= i) 
    			i = j;
    		j--;
    	}
    	return nums[j] >= i;
    }
    //another greedy method
    public boolean canJump(int[] nums) {
        int s = 0, e = 0;
        while (s <= e && e < nums.length - 1) {
            int farthest = e;
            for (int i = s; i <= e; i ++){
                int tmp = i + nums[i];
                if (tmp > farthest) farthest = tmp;
            }
            s = e + 1;
            e = farthest;
        }
        return s <= e;
    }    
    //DP
    public boolean canJump(int[] nums) {
    	if(nums == null || nums.length <= 1)
    		return true;
    	int[] tmp = new int[nums.length];
    	tmp[0] = true;
    	for(int i = 1; i < nums.length; i++){
    		for(int j = i - 1; j >= 0; j++){
    			if(tmp[j] && nums[j] + j >= i)
    				tmp[i] = true;
    		}
    	}
    	return tmp[nums.length - 1];
    }
}