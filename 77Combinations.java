/*
77. Combinations
Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.

For example,
If n = 4 and k = 2, a solution is:

[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]
*/

public class Solution {

  public List<List<Integer>> combine(int n, int k) {
      List<List<Integer>> list = new ArrayList<List<Integer>>();
      if(k==0||n<k)
          return list;
      if(k==1){
        for(int i=1;i<=n;i++)
          list.add(new ArrayList<Integer>(i));
        return list;
      }
      for(int i=n;i>=n-k;i--){
        List<List<Integer>> sublist = combine(i-1,k-1);
        for(List<Integer> l: sublist )
             l.add(i);
        list.addAll(sublist) ;
      }
      return list;
  }
    public List<List<Integer>> combine(int n, int k) {
        return helper(1,n,k);
    }
    private List<List<Integer>> helper(int s, int e, int k){
    	List<List<Integer>> l = new ArrayList<List<Integer>>();
    	if(k==0)
    		return l;
    	if(k==1){
    		for(int i=s;i<=e;i++){
    			List<Integer> tmp = new ArrayList<Integer>();
    			tmp.add(i);
    			l.add(tmp);
    		}
    		return l;
    	}
    	for(int i=s;i<=e&&e-i+1>=k;i++){
    		List<List<Integer>> lists = helper(i+1,e,k-1);
    		for(List<Integer> list: lists)
    			list.add(0,i);
    		l.addAll(lists);
    	}
    	return l;
    }
}