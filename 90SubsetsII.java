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
    //bfs template: slow
    public List<List<Integer>> subsetsWithDup(int[] nums) {
      List<List<Integer>> result = new ArrayList<List<Integer>>();
      List<Integer> list = new ArrayList<Integer>();
      result.add(list);
      if(nums == null || nums.length == 0)
        return result;          
      Arrays.sort(nums);
      int i = 0;
      while(i < nums.length){
        int size = result.size();
        for(int j = 0; j<size ; j++){
          List<Integer> l = new ArrayList<Integer>(result.get(j));
          l.add(nums[i]);
          if(i > 0 && nums[i] == nums[i-1] && (!l.contains(nums[i]) || result.contains(l)))
            continue;
          result.add(l);
        }
        i++;
      }
      return result;
    } 
    // dfs template
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