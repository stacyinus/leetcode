/*
41. First Missing Positive 
Given an unsorted integer array, find the first missing positive integer.

For example,
Given [1,2,0] return 3,
and [3,4,-1,1] return 2.

Your algorithm should run in O(n) time and uses constant space.
*/


public class Solution {
    public int firstMissingPositive(int[] nums) {
        if(nums == null || nums.length == 0)
            return 1;
        for(int i = 0; i < nums.length; i++){
            //System.out.println(i);
            while(nums[i] > 0 && nums[i] <= nums.length && nums[i] != i + 1){
                int tmp = nums[nums[i]-1];
                if(tmp == nums[i]) // this is a very important case, think about [1,1]
                    break;
                nums[nums[i]-1] = nums[i];
                nums[i] = tmp;
            }
        }
        //System.out.println(Arrays.toString(nums));
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != i + 1)
                return i+1;
        }
        return nums.length + 1;
    }
}