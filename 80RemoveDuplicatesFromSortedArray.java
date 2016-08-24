/*
80. Remove Duplicates from Sorted Array II

Follow up for "Remove Duplicates":
What if duplicates are allowed at most twice?

For example,
Given sorted array nums = [1,1,1,2,2,3],

Your function should return length = 5, with the first five elements of nums being 1, 1, 2, 2 and 3. It doesn't matter what you leave beyond the new length.

Subscribe to see which companies asked this question
*/

/*
    two pointers :  pre is the last number moved to j.
                    i is the moving pointer. move i to find the next number to move to j. i start from 0
                    j is where the next number i point to is going to move to. everything before j is valid.
                    initialize j.
*/
// Second round
public class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int i = 0, pre = nums[0];
        int j = nums.length >1 && nums[0] == nums[1] ? 2 : 1;
        while (i < nums.length) {
            while (i < nums.length && nums[i] == pre) {
                i ++;
            }
            if ( i < nums.length) {
                pre = nums[i];
                if (i < nums.length - 1 && nums[i] == nums[i + 1]) {
                    swap(nums, j++ , i++);
                }
                swap(nums, j++, i++);
            }
        }
        return j;
    }
    private void swap(int[] nums, int i , int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}

// refactored the code to be more generic: work for any duplicated numbers.
public class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        return helper(nums, 2);
    }

    private int helper(int[] nums, int k) { // 2  1,1,1, 
        int i = 0, pre = nums[0];
        int j = 1;
        while (j < k && j < nums.length && nums[j] == nums[j - 1]) {
            j++;
        }
        while (i < nums.length) {
            while (i < nums.length && nums[i] == pre) {
                i ++;
            }
            if ( i < nums.length) {
                pre = nums[i];
                int count = 1;
                while (count < k && i < nums.length - 1 && nums[i] == nums[i + 1]) {
                    swap(nums, j++, i++);
                    count ++;
                }
                if (i < nums.length)    swap(nums, j++, i++);
            }
        }
        return j;
    }
    private void swap(int[] nums, int i , int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}


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