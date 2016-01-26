/*
Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.

For example, given nums = [0, 1, 0, 3, 12], after calling your function, nums should be [1, 3, 12, 0, 0].

Note:
You must do this in-place without making a copy of the array.
Minimize the total number of operations.
*/

public class 283MoveZeros {
    public void moveZeroes(int[] nums) {
        int firstZeroIndex=-1;
        for(int i =0; i<nums.length;i++){
            //Initialize firstZeroIndex
            if(nums[i]==0&&firstZeroIndex==-1)
                firstZeroIndex = i;
            else if(nums[i]!=0&&firstZeroIndex!=-1){
                nums[firstZeroIndex] = nums[i];
                nums[i] = 0;
                firstZeroIndex++;
            }
        }
    }
    public void moveZeroes2(int[] nums) {
        int firstZero = 0;
        int current = 0;
        while(current<nums.length){
        	if(nums[current]!=0){
        		if(firstZero!=current){
	        		int temp=nums[current];
	        		nums[firstZero]=nums[current];
	        		nums[current] = 0;
        		}
				firstZero ++; 
        	}
			current++;
        }
    }    
}