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
//second round
public class Solution {
    //1,2,3,4,5
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        helper(result, new ArrayList<Integer>(), n , k, 1);
        return result;
    }
    private void helper(List<List<Integer>> result, List<Integer> list, int n, int k, int start) {
        if (k == 0) {
            result.add(new ArrayList<Integer>(list));
            return;
        }
        for (int i = start; i <= n - k + 1; i++ ) {
            list.add(i);
            helper(result, list, n, k - 1, i + 1);
            list.remove(list.size() - 1);
        }
    }
}
//first round. what the hell did i wrote?
public class Solution {

  public List<List<Integer>> combine(int n, int k) {
      List<List<Integer>> list = new ArrayList<List<Integer>>();
      if(k==0||n<k)
          return list;
        //This will be taken care of in the recursion.
      // if(n==k){
      //     List<Integer> tmp = new ArrayList<Integer>();
      //     for(int i=1;i<=n;i++){
      //       tmp.add(i);
      //     }
      //     list.add(tmp);
      //     return list;
      // }
      if(k==1){
        for(int i=1;i<=n;i++){
            List<Integer> tmp = new ArrayList<Integer>();
            tmp.add(i);
            list.add(tmp);
        }
        return list;
      }
      for(int i=n;i>=k;i--){
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