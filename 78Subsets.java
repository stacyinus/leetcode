/*
78. Subsets
Given a set of distinct integers, nums, return all possible subsets.

Note:
Elements in a subset must be in non-descending order.
The solution set must not contain duplicate subsets.
For example,
If nums = [1,2,3], a solution is:

[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]
*/

public class Solution {
    //bfs template
    public List<List<Integer>> subsets(int[] nums) {
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
          result.add(l);
        }
        i++;
      }
      return result;
    } 
    //dfs template
    public List<List<Integer>> subsets(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> list = new ArrayList<Integer>();
        subsetsHelper(result, list, nums, 0);
        return result;
    }
    
    public void subsetsHelper(List<List<Integer>> result, List<Integer> list, int[] nums, int pos){
        result.add(new ArrayList<Integer>(list));
        for(int i=pos;i<nums.length;i++){
            List<Integer> tmp = new ArrayList<Integer>(list);
            tmp.add(nums[i]);
            subsetsHelper(result, tmp, nums, i+1);
        }
    }
}