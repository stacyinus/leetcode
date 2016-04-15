/*
90. Subsets II
Given a collection of integers that might contain duplicates, nums, return all possible subsets.

Note:
Elements in a subset must be in non-descending order.
The solution set must not contain duplicate subsets.
For example,
If nums = [1,2,2], a solution is:

[
  [2],
  [1],
  [1,2,2],
  [2,2],
  [1,2],
  []
]
*/


public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> list = new ArrayList<Integer>();
        helper(result, list, nums, 0);
        return result;
    }
    
    public void helper(List<List<Integer>> result, List<Integer> list, int[] nums, int pos){
        result.add(new ArrayList<Integer>(list));
        for(int i = pos;i < nums.length;i++){
            if(i>pos&&nums[i]==nums[i-1])
                continue;
            List<Integer> tmp = new ArrayList<Integer>(list);
            tmp.add(nums[i]);
            helper(result, tmp, nums, i+1);
        }
    }
}