/*
287. Find the Duplicate Number  

Given an array nums containing n + 1 integers where each integer is between 1 and n (inclusive), prove that at least one duplicate number must exist. Assume that there is only one duplicate number, find the duplicate one.
Note:
You must not modify the array (assume the array is read only).
You must use only constant, O(1) extra space.
Your runtime complexity should be less than O(n2).
There is only one duplicate number in the array, but it could be repeated more than once.

5,6,3,4,3,1,2 (n = 6)
s=1, e=6, mid = (1+6)/2=3,there are 4 numbers smaller or equal to 3, so e = mid;
s=1, e=3, mid = (1+3)/2=2,there are 2 numbers smaller or equal to 2, so s = mid+1;
s=3, e=3, stop
*/

public class Solution {
    public int findDuplicate(int[] nums) {
    	int s = 1, e = nums.length-1;
    	while(s < e){
    		int m = s + (e - s)/2, count = 0;
    		for(int i = 0; i < nums.length; i++){
    			if(nums[i] <= m)
    				count++;
    		}
    		if(count > m)
    			e = m;
    		else
    			s = m + 1;
    	}    
    	return s;
    }
}