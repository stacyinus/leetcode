/*
80. Remove Duplicates from Sorted Array II

Follow up for "Remove Duplicates":
What if duplicates are allowed at most twice?

For example,
Given sorted array nums = [1,1,1,2,2,3],

Your function should return length = 5, with the first five elements of nums being 1, 1, 2, 2 and 3. It doesn't matter what you leave beyond the new length.

Subscribe to see which companies asked this question
*/

public class Solution {
    public int removeDuplicates(int[] nums) {
        int count = 0;
        int i=0,j=1;
        while(j<nums.length){
        	if(nums[i]!=nums[j]){
        		if(i+1!=j){
        			int tmp = nums[i+1];
        			nums[i+1]=nums[j];
        			nums[j]=tmp;
				}
				count=0;
				j++;
        		i++;
        	}
        	else if(count == 0){
        		if(i+1!=j){
        			int tmp = nums[i+1];
        			nums[i+1]=nums[j];
        			nums[j]=tmp;
				}
				count++;
				j++;
        		i++;
        	}
        	else{
        		count++;
        		j++;
        	}
        }
        return i+1;
    }
}