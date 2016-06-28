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

*/
/*
  [2,2,1,1]
   i = 0, [2] 
   i = 1, [2,2] 
   i = 2, [1,2,2] [2,1,2] [2,2,1]
   i = 3, [1,1,2,2] [1,2,1,2],[2,1,1,2], [2,1,2,1], [1,2,2,1],
          [2,1,2,1]
*/

public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (nums == null || nums.length == 0) {
        	return result;
        }
        boolean[] visited = new boolean[nums.length];
        List<Integer> list = new ArrayList<Integer>();
        list.add(nums[0]);
        result.add(list);
        for (int i = 1; i < nums.length; i++) {
        	List<List<Integer>> newResult = new ArrayList<List<Integer>>();
        	for(List<Integer> l : result) {
        		for(int j = 0; j <= l.size(); j ++) {//1,2   + 1
        			if (j == 0 || j > 0 && nums[i] != l.get(j - 1)) {   
                List<Integer> copy = new ArrayList<Integer>(l);      
        			  copy.add(j, nums[i]);  	
                if(!newResult.contains(copy))
    						  newResult.add(copy);
    					}     			
        		}
        		result = newResult;
        	}
        }
        return result;
    }
    //back tracking
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        Arrays.sort(nums);
        boolean[] visited = new boolean[nums.length];
        Arrays.fill(visited, false);
        helper(result, nums, new ArrayList<Integer>(), visited);
        return result;
    }
    private void helper(List<List<Integer>> result, int[] nums, List<Integer> tmp, boolean[] visited ) {
        if (tmp.size() == nums.length) {
            result.add(new ArrayList<Integer>(tmp));
            return;
        }
        for (int i = 0; i < nums.length; i++) { //1, [1,2]
            if( visited[i] || (i > 0 && nums[i] ==  nums[i-1] && !visited[i-1])){
                continue;
            }
            visited[i] = true;
            tmp.add(nums[i]);
            helper(result, nums, tmp, visited);
            visited[i] = false;
            tmp.remove(tmp.size()-1);
        }
    }    
}