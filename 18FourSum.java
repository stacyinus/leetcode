/*
18. 4Sum 

Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target? 
Find all unique quadruplets in the array which gives the sum of target.

Note:
Elements in a quadruplet (a,b,c,d) must be in non-descending order. (ie, a ≤ b ≤ c ≤ d)
The solution set must not contain duplicate quadruplets.
    For example, given array S = {1 0 -1 0 -2 2}, and target = 0.

    A solution set is:
    (-1,  0, 0, 1)
    (-2, -1, 1, 2)
    (-2,  0, 0, 2)
 */
//-2,-1,0,0,1,2
public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        for(int i=0;i<nums.length-3;i++){
            if(i>0&&nums[i]==nums[i-1])
                continue;
        	for(int j=i+1;j<nums.length-2;j++){
        		if(j>i+1&&nums[j]==nums[j-1])
        			continue;
        		int s = j+1, e = nums.length-1;
        		while(s<e){
        			if(nums[i]+nums[j]+nums[s]+nums[e]==target){
        				lists.add(Arrays.asList(nums[i],nums[j],nums[s],nums[e]));
        				s++;
        				e--;
        				while(s<e&&nums[s]==nums[s-1])
        					s++;
        				while(s<e&&nums[e]==nums[e+1])
        					e--;
        			}
        			else if(nums[i]+nums[j]+nums[s]+nums[e]<target)
        				s++;
        			else
        				e--;
        		}
        	}
        }
        return lists;        
    }
}