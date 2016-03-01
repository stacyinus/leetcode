/*
216. Combination Sum III
Find all possible combinations of k numbers that add up to a number n, given that only numbers from 1 to 9 can be used 
and each combination should be a unique set of numbers.

Ensure that numbers within the set are sorted in ascending order.


Example 1:

Input: k = 3, n = 7

Output:

[[1,2,4]]

Example 2:

Input: k = 3, n = 9

Output:

[[1,2,6], [1,3,5], [2,3,4]]
*/

public class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        return combinationSum3(1,k,n);
    }
    private List<List<Integer>> combinationSum3(int s, int k, int n) {
    	List<List<Integer>> list = new ArrayList<List<Integer>>();
    	if(k==1&&s<=n){
    		if(n>9) return list;
    		ArrayList<Integer> l = new ArrayList<Integer>();
    		l.add(n);
    		list.add(l);
    		return list;
    	}
    	if(s>=(double)n/k)
    		return list;
    	int i=1;
    	while(k>1){
    		List<List<Integer>> inner = combinationSum3(s+i, k-1, n-(s+i-1));
    		if(inner.size() == 0)
    			break;
    		for(List<Integer> l: inner)
    			l.add(0,s+i-1);
    		list.addAll(inner);
    		i++;
    	}
    	return list;
    }
}