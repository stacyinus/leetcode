/*
27. Remove Element 
Given an array and a value, remove all instances of that value in place and return the new length.

The order of elements can be changed. It doesn't matter what you leave beyond the new length.
*/
public class 27RemoveElement {
	//iterative
    public int removeElement(int[] nums, int val) {
        int last = nums.length-1;
        for(int i=0;i<nums.length&&last>=i;i++){
        	if(nums[i]==val){
        		int tmp = nums[i];
        		nums[i] = nums[last];
        		nums[last] = tmp;
        		last--;
        		i--;
        	}	
        }
        return last+1;	
    }  
}