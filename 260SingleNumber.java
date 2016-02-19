/*
260. Single Number III
Given an array of numbers nums, in which exactly two elements appear only once and all the other elements appear exactly twice. Find the two elements that appear only once.

For example:

Given nums = [1, 2, 1, 3, 2, 5], return [3, 5].

Note:
The order of the result is not important. So in the above example, [5, 3] is also correct.
Your algorithm should run in linear runtime complexity. Could you implement it using only constant space complexity?
*/

public class 260SingleNumber {
    public int[] singleNumber(int[] nums) {
        int x = 0;
        for(int i=0;i<nums.length;i++)
        	x^=nums[i];
        //find the first bit equals to 1 starting from left;
        int j = 1;
        while((x&j)==0)
        	j=j<<1;
        int x1=0;
        int x2=0;
        for(int i=0;i<nums.length;i++){
        	if((nums[i]&j)==0) 
        		x1^=nums[i];
        	else
        		x2^=nums[i];
        }
        return new int[]{x1,x2};
    }
}