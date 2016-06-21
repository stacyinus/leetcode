/*
47. Permutations II 	
Given a collection of numbers that might contain duplicates,
 return all possible unique permutations.

For example,
[1,1,2] have the following unique permutations:
[
  [1,1,2],
  [1,2,1],
  [2,1,1]
]
1,1,2        1
  [1,1,2],  [1,1,2,1]  [1,1,1,2]
  [1,2,1],  [1,2,1,1]  [1,1,2,1]
  [2,1,1]   [2,1,1,1]  [1,2,1,1]
*/

public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (nums == null || nums.length == 0) {
        	return result;
        }
        List<Integer> list = new ArrayList<Integer>();
        list.add(nums[0]);
        result.add(list);
        for (int i = 1; i < nums.length; i++) {
        	List<List<Integer>> newResult = new ArrayList<List<Integer>>();
        	for(List<Integer> l : result) {
        		for(int j = 0; j <= l.size(); j ++) {
        			List<Integer> copy = new ArrayList<Integer>(l);      
        			copy.add(j, nums[i]);  			
					if (!newResult.contains(copy)) {
						newResult.add(copy);
					}     			
        		}
        		result = newResult;
        	}
        }
        return result;
    }
}