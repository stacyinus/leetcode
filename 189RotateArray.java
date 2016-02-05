/*
189. Rotate Array
Rotate an array of n elements to the right by k steps.

For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].

Note:
Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.

[show hint]

Related problem: Reverse Words in a String II
*/

public class Solution {
	//becareful here, java function is pass be reference
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        if(k>=n)
        	k=k%n;
        int[] copy = nums.clone();
        for(int i=0;i<n;i++){
        	if(k>=n)
        		k = k-n;
        	nums[k++]=copy[i];
        }        
    }
    public void rotate(int[] nums, int k) {
        if(k>=nums.length)
        	k=k%nums.length;    
        //to be continued....
    }    
}