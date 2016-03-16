/*
15. 3Sum
Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? 
Find all unique triplets in the array which gives the sum of zero.

Note:
Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ≤ b ≤ c)
The solution set must not contain duplicate triplets.
    For example, given array S = {-1 0 1 2 -1 -4},

    A solution set is:
    (-1, 0, 1)
    (-1, -1, 2)
*/

public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
    	List<List<Integer>> lists = new ArrayList<List<Integer>>();
        for(int i=0;i<nums.length-2;i++){
        	if(i>0&&nums[i]==nums[i-1]) continue;
            int s=i+1, e=nums.length-1;
            while(s<e){
                if(nums[s]+nums[e]+nums[i]==0){
                    lists.add(Arrays.asList(nums[i],nums[s],nums[e]));
                    s++;
                    e--;
                    while(s<e&&nums[s]==nums[s-1])
                        s++;
                    while(s<e&&nums[e]==nums[e+1])
                        e--;
                }
                else if(nums[s]+nums[e]+nums[i]>0)
                    e--;
                else
                    s++;
            }
        }
        return lists;
    }
}