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
    	HashSet<Integer> sum = new HashSet<Integer>();
    	List<List<Integer>> lists = new ArrayList<List<Integer>>();
        for(int i=0;i<nums.length;i++){
        	int target = -nums[i];
        	if(sum.contains(target)) continue;
        	for(int j=0;j<nums.length;j++){		
        		if(i!=j) {
        			HashSet<Integer> set = new HashSet<Integer>();
        			if(set.contains(target-nums[j]))
        				lists.add(getList( nums[i],nums[j],target-nums[j]));
        			else
        				set.add(nums[j]);
        		}
        	}
        }
        return lists;
    }
    private List<Integer> getList(int a, int b, int c){
    	List<Integer> list = new ArrayList<Integer>();
    	int tmp1 = Math.min(Math.min(a,b),c);
    	list.add(tmp1);
    	int tmp2 = 0;
    	int tmp3 = 0;
    	if(a==tmp1){
    		tmp2 = Math.min(b,c);
    		tmp3 = Math.max(b,c);
    	}else if(b==tmp1){
			tmp2 = Math.min(a,c);
    		tmp3 = Math.max(a,c);    		
    	}else{
			tmp2 = Math.min(a,b);
    		tmp3 = Math.max(a,b);        		
    	}
    	list.add(tmp2);
    	list.add(tmp3);
    	return list;
    }
}