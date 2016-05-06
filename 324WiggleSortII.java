/*
324. Wiggle Sort II

Given an unsorted array nums, reorder it such that nums[0] < nums[1] > nums[2] < nums[3]....

Example:
(1) Given nums = [1, 5, 1, 1, 6, 4], one possible answer is [1, 4, 1, 5, 1, 6]. 
(2) Given nums = [1, 3, 2, 2, 3, 1], one possible answer is [2, 3, 1, 3, 1, 2].

Note:
You may assume all input has valid answer.

Follow Up:
Can you do it in O(n) time and/or in-place with O(1) extra space?
*/

public class Solution {
    public void wiggleSort(int[] nums) {
        if(nums == null || nums.length == 0)
        	return;
        for(int i = 1; i < nums.length -1; i += 2){
        	if(nums[i] > nums[i-1] && nums[i] < nums[i+1])
        		continue;
        	if(nums[i] < nums[i-1]){
        		int tmp = nums[i];
        		nums[i] = nums[i-1];
        		nums[i-1] = tmp;
	        }
	        else if(nums[i] == nums[i-1]){
	        	int tmpi = i + 1;
	        	while(tmpi < nums.length){
	        		if(nums[tmpi] > nums[i] && nums[tmpi] > nums[])
	        			break;
	        		tmpi++;
	        	}
	        	if(tmpi < nums.length){
		        	int tmp = nums[tmpi];
	        		nums[tmpi] = nums[i];
	        		nums[i] = tmp;
	        	}
	        }
	        if(nums[i] > nums[i+1]){
	        	int tmp = nums[i];
        		nums[i] = nums[i+1];
        		nums[i+1] = tmp;
	        }
	        else if(nums[i] == nums[i+1]){
	        	int tmpi = i + 1;
	        	while(tmpi < nums.length){
	        		if(nums[tmpi] > nums[i])
	        			break;
	        		tmpi++;
	        	}
	        	if(tmpi < nums.length){
		        	int tmp = nums[tmpi];
	        		nums[tmpi] = nums[i];
	        		nums[i] = tmp;
	        	}	        	
	        }
       	}
    }
}