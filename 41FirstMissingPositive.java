/*
41. First Missing Positive 
Given an unsorted integer array, find the first missing positive integer.

For example,
Given [1,2,0] return 3,
and [3,4,-1,1] return 2.

Your algorithm should run in O(n) time and uses constant space.
*/
/*
    思路： 目的是将数组变成[1,2,3,4,....]来找到first missing positive.
         move num[i] to index i + 1
*/

public class Solution {
    public int firstMissingPositive(int[] nums) {
        if (nums == null ) return 1;
        for (int i = 0; i < nums.length ; i ++) {
            int cur = nums[i];
            while (cur <= nums.length && cur >= 1 && nums[cur - 1] != cur) {
                int tmp = nums[cur - 1];
                nums[cur - 1] = cur;
                cur = tmp;
            }
        }
        int i = 0;
        for (; i < nums.length; i ++) {
            if (nums[i] != i + 1) break;
        } 
        return i + 1;
    }
}