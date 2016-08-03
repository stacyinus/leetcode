/*
31. Next Permutation

Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.

If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).

The replacement must be in-place, do not allocate extra memory.

Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
1,2,3 → 1,3,2
3,2,1 → 1,2,3
1,1,5 → 1,5,1

*/
/*
	1. starting from right side, find the first nums[i] < nums[i+1].
	2. starting from right side again, find the first nums[k] that is greater than nums[i] 
		(the right side of nums[i] are in descending order, so the first greater than nums[i] will be the next permutation)
	3. swap nums[k] with nums[i], now index i became the next greater value, however, this is not the end, you need to revert 
		the array starting from i + 1.
	eg. 1,3,2,0 --> 2,3,1,0 ->2,0,1,3
	
*/


public class Solution {
    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length == 0) {
        	return;
        }
        // start from end, find the first num that is greater than its prior num
        int i = nums.length - 1;
        while (i > 0) {
        	if	(nums[i-1] < nums[i]) {
        		break;
        	}
        	i--;
        }
        // if no one is greater than its prior number, revert the array
        if (i == 0) {
        	reverse(nums, 0 , nums.length - 1);
        }
        else{
        	// starting from end, find the first greather than 
	        int j = nums.length - 1;
	        while (j >= i) {
	        	if (nums[j] > nums[i - 1]) {
	        		break;
	        	}
	      		j--;
	        }
	        //swap
	        int tmp = nums[i - 1];
	        nums[i - 1] = nums[j];
	        nums[j] = tmp;
            reverse(nums, i, nums.length - 1);
	    }
    }
    private void reverse(int[] nums, int i, int j) {
    	while(i < j) {
    		int tmp = nums[i];
	        nums[i] = nums[j];
	        nums[j] = tmp;
	        i++;
	        j--;
    	}
    }
}