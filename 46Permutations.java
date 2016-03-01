/*
46. Permutations

Given a collection of distinct numbers, return all possible permutations.

For example,
[1,2,3] have the following permutations:
[1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], and [3,2,1].
*/

public class Solution {
    public List<List<Integer>> permute(int[] nums) {
    	if(nums==null||nums.length==0)
    		return null;    	
    	List<List<Integer>> list = new ArrayList<List<Integer>>();
    	List<Integer> l = new ArrayList<Integer>();
    	l.add(nums[0]);
    	list.add(l);
    	for(int i=1;i<nums.length;i++)
    		list = permute(list, nums[i]);
    	return list;
        
    }
	private List<List<Integer>> permute(List<List<Integer>> list, int num) {
		List<List<Integer>> r = new ArrayList<List<Integer>>();
		for(List<Integer> l : list)
			for(int i=0;i<=l.size();i++){
				List<Integer> newL = new ArrayList<Integer>();
				newL.addAll(l);
				newL.add(i, num);
				r.add(newL);
			}
		return r;
	}
}