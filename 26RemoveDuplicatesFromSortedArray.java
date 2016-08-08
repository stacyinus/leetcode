/*
26. Remove Duplicates from Sorted Array

Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.

Do not allocate extra space for another array, you must do this in place with constant memory.

For example,
Given input array nums = [1,1,2],

Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively. 
It doesn't matter what you leave beyond the new length.
*/

public class Solution {
    //Second Round
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int i = 0, j = 1, tmp = nums[0];
        while ( j < nums.length) {
            while ( j < nums.length && tmp == nums[j]) {
                j++;
            }
            if (j == nums.length) break;
            nums[i + 1] = nums[j];
            tmp = nums[j++];
            i++;
        }
        return i + 1;
    }    
    // first  round
    public int removeDuplicates(int[] nums) {
    	if(nums==null)
    		return 0;
    	if(nums.length==1)
    		return 1;
        int i = 0;//index of the last element in the nonduplicated array
        int j = 1;//moving index;
        int l = 1;//length of the array
        while(j<nums.length){
        	if(nums[i]!=nums[j]){
        		if(j!=i+1){
        			int tmp = nums[i+1];
        			nums[i+1]=nums[j];
        			nums[j]=tmp;
        		}
        		i++;
        		l++;
        	}
        	j++;
        }   
        return l;
    }
}