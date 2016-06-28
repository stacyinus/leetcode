/*
46. Permutations

Given a collection of distinct numbers, return all possible permutations.

For example,
[1,2,3] have the following permutations:
[1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], and [3,2,1].
*/
/*
	can be solved using BFS(iterative) or Backtracking(recursive). 
*/
public class Solution {
	//iterative: BFS
    public List<List<Integer>> permute(int[] nums) {
    	List<List<Integer>> result = new ArrayList<List<Integer>>();
    	if (nums == null || nums.length == 0 ) {
    		return result;
    	}
    	List<Integer> init = new ArrayList<Integer>();
    	init.add(nums[0]);
    	result.add(init);
    	for (int i = 1; i < nums.length ; i++) {
    		List<List<Integer>> newResult = new ArrayList<List<Integer>>();
    		for (List<Integer> list : result) {
    			for (int j = 0; j <= list.size(); j++) {
    				List<Integer> copy = new ArrayList<Integer>(list);
    				copy.add(j, nums[i]);
    				newResult.add(copy);
    			}
    		}
    		result = newResult;
    	}
    	return result;
    }	

    //backtracking
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        helper(result, nums, new ArrayList<Integer>());
        return result;
    }
    /*
        1, [2,3,4]
        2, [1,3,4]
    */
    private void helper(List<List<Integer>> result, int[] nums, List<Integer> tmp) {
        if (tmp.size() == nums.length) {
            result.add(new ArrayList<Integer>(tmp));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (tmp.contains(nums[i])) {
                continue;
            }
            tmp.add(nums[i]); // you can also make a copy of the current tmp, add nums[i], and pass in the new tmp list.
            helper(result, nums, tmp);
            tmp.remove(new Integer(nums[i])); 
        }
    }
}