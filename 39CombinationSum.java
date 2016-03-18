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
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        return combinationSum(candidates,target,candidates.length-1);
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target, int e) {
        int k = findIndex(candidates,target);
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(k==0&&candidates[0]>target) return result;
        for(int i=e;i>=0;i--){
            if(target==candidates[i]){
                ArrayList<Integer> list = new ArrayList<Integer>();
                list.add(candidates[i]);
                result.add(list);
            }
            else{
                List<List<Integer>> lists = combinationSum(candidates,target-candidates[i],i);
                if(lists.size()!=0){
                    for(List<Integer> list: lists)
                        list.add(candidates[i]);
                    result.addAll(lists);
                }
            }
        }
        return result;
    }   
    //find the element in array that is most closer to target 
     public int findIndex(int[] candidates,int target){
        int s=0, e= candidates.length-1,mid=s+(e-s)/2;
        while(s<=e){
            mid=s+(e-s)/2;
            if(candidates[mid]==target)
                return mid;
            else if(target>candidates[mid])
                s = mid+1;
            else
                e = mid-1;
        }
        return s==0?s:s-1;
    }
}