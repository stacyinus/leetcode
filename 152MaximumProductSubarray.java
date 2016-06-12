/*
152. Maximum Product Subarray 

Find the contiguous subarray within an array (containing at least one number) which has the largest product.

For example, given the array [2,3,-2,4],
the contiguous subarray [2,3] has the largest product = 6.



*/

public class Solution {
    public int maxProduct(int[] nums) {
        int p1 = 1, p2 = 1, max = 0;
        for(int i = 0; i < nums.length ; i++){
            if(nums[i] > 0){
                p1 *= nums[i];
            }
            else{
                max = Math.max(p1, max);
                p1 = 1;
                p2 = 
            }                
        }
    }
}