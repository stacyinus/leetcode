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
	1,3,2 -> 2,1,3
	1,2,3 ->1,3,2
	1,2,3,4,5 --> 1,2,3,5,4
	3,2,1  (all descending)  reverse, 123
	3,1,2  -->3, 2 ,1
	5,4,2,3,0,1 --> 5,4,2,3,1,0
	5,4,0,1,2,3 --> 

	revert the last acending 2. 
*/

public class Solution {
    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length == 0) {
        	return;
        }
        int i = nums.length - 1;
        while (i > 0) {
        	if(nums[i] > nums[i - 1]) {
        		int tmp = nums[i];
        		nums[i] = nums[i - 1];
        		nums[i - 1] = tmp;
        		return;
        	}
        	i--;
        }
        int j = nums.length - 1;
        while (i < j) {
        	int tmp = nums[i];
        	nums[i] = nums[j];
        	nums[j] = tmp;
        	i++;
        	j--;
        }
    }
}