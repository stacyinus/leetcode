/*
75. Sort Colors 
Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent, 
with the colors in the order red, white and blue.

Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

Note:
You are not suppose to use the library's sort function for this problem.

click to show follow up.

Follow up:
A rather straight forward solution is a two-pass algorithm using counting sort.
First, iterate the array counting number of 0's, 1's, and 2's, then overwrite array with total number of 0's, then 1's and followed by 2's.

Could you come up with an one-pass algorithm using only constant space?
*/

/*
    Two Pass Solution O(n): count each number, and repopulate the array
    One Pass solution O(n): use 2 pointers, low tracks the last index of
                            0, high track the first index of 2, and use 
                            a moving index i to move the numbers.
*/


public class Solution {
	//two pass solution
	public void sortColors(int[] nums) {
		int[] t = new int[3];
		for(int i=0;i<nums.length;i++)
			t[nums[i]]++;
		int j=0;
		for(int i=0;i<3;i++)
			while(t[i]-->0&&j<nums.length)
				nums[j++]=i; 
	}
	//one pass solution
    public void sortColors(int[] nums) {
    	int low = 0,i=0;
    	int high = nums.length-1;
    	while(i<=high){
    		if(nums[i]==0){
    			int tmp = nums[low];
    			nums[low]=nums[i];
    			nums[i]=tmp;
    			i++;
    			low++;
    		}
    		else if(nums[i]==2){
    			int tmp = nums[high];
    			nums[high]=nums[i];
    			nums[i]=tmp;
    			high--;
    		}
    		else
    			i++;
    	}

    }
}