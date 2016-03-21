/*
40. Combination Sum II

Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

Each number in C may only be used once in the combination.

Note:
All numbers (including target) will be positive integers.
Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
The solution set must not contain duplicate combinations.
For example, given candidate set 10,1,2,7,6,1,5 and target 8, 
A solution set is: 
[1, 7] 
[1, 2, 5] 
[2, 6] 
[1, 1, 6] 
*/

public class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        return combinationSum2(candidates,target,0);
    }
    private List<List<Integer>> combinationSum2(int[] candidates, int target, int startIndex) {
    	List<List<Integer>> result = new ArrayList<List<Integer>>();
    	for(int i=startIndex;i<candidates.length;i++){
    	    if(i!=startIndex&&i!=0&&candidates[i]==candidates[i-1])
    			continue;
    		if(target-candidates[i]<=0){
    			if(target-candidates[i]==0){
    				ArrayList<Integer> l = new ArrayList<Integer>();
    				l.add(candidates[i]);
    				result.add(l);
    			}
    			return result;
    		}
    		List<List<Integer>> lists = combinationSum2(candidates,target-candidates[i],i+1);
    		if(lists.size()==0) continue;
    		for(List<Integer> list:lists)
    			list.add(0,candidates[i]);
    		result.addAll(lists);
    	}
    	return result;
    }
}