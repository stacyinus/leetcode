/*
198. House Robber

You are a professional robber planning to rob houses along a street. 

Each house has a certain amount of money stashed, 

the only constraint stopping you from robbing each of them is that adjacent houses have 

security system connected and it will automatically contact the police if two adjacent houses 

were broken into on the same night.

Given a list of non-negative integers representing the amount of money of each house, 

determine the maximum amount of money you can rob tonight without alerting the police.
*/

public class 198HouseRobber {
    //exceed time limit.....
    public int rob2(int[] nums) {
    	return rob(nums,0);
    }
    private int rob(int[] nums, int i){
    	if(i>nums.length-1)
    		return 0;
    	if(i==nums.length-1)
    		return nums[i];
    	return(Math.max(nums[0]+rob(nums, i+2), nums[1]+rob(nums,i+3));
    }
    //Method 2
    public int rob(int[] nums) {
    	if(nums ==null||nums.length==0)
    		return 0;
    	if(nums.length==1)
    		return nums[0];
    	if(nums.length==2)
    		return Math.max(nums[0],nums[1]);
    	int[] x = new int[nums.length];
    	int max = 0;
    	x[0]=nums[0];
    	x[1]=nums[1];
    	x[2]=nums[0]+nums[2];
    	for(int i=3;i<nums.length;i++){
    		x[i]= nums[i]+Math.max(x[i-2],x[i-3]);
    	}
    	return(Math.max(x[nums.length-1],x[nums.length-2]));
    }
}