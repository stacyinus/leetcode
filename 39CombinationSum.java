/*
39. Combination Sum

Given a set of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

The same repeated number may be chosen from C unlimited number of times.

Note:
All numbers (including target) will be positive integers.
Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
The solution set must not contain duplicate combinations.
For example, given candidate set 2,3,6,7 and target 7, 
A solution set is: 
[7] 
[2, 2, 3] 
*/

public class Solution {
	HashMap<Integer,Integer> map;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        int k = findIndex(candidates,target);
        List<List<Integer>> result = new ArrayList<List<Integer>>();

        if(k==candidates.length-1) return result;
        if(map==null){
        	map = 
        }
        for(int i=k;i>=0;i--){

        }

    }
    //find the element in array that is most closer to target 
    private int findIndex(int[] candidates,int target){

    }


}