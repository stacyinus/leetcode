/*
60. Permutation Sequence

The set [1,2,3,…,n] contains a total of n! unique permutations.

By listing and labeling all of the permutations in order,
We get the following sequence (ie, for n = 3):

"123"    1
"132"    2
"213"    3
"231"    4
"312"
"321"
Given n and k, return the kth permutation sequence.

Note: Given n will be between 1 and 9 inclusive.
*/
/*
	DFS backtracking is too slow for this problem, we can skip many cases based on the number k, and i!
	For example: n = 4, k = 15 (4!= 24) f[i] store (i!), so f[1] = 1, f[2] = 2, f[3] = 6, f[4] = 24.
				if k = 24, return 4321;
				else starting f[3], k/f[3] = 2. there are 6 permutations for numbers start with 1, same cases for 
				numbers start with 2,3,4. 
				k/f[3] = 0 meaning the number will start from 1;
				k/f[3] = 1, meaning  the number will start from 2;
				...
				Here k/f[3] = 2, number will start from 3.    ------3 (1,2,4) 
				now k = k%f[3] = 3, same logic, k / f[2] = 1, meaning the next number will be 2(we can't conside 3 since it's added already)
				now k = k%f[2] = 1, same logic, k / f[1] = 1, meaning the next number will be 2(we can't conside 2,3 since they're added already) 1, 4


*/

public class Solution {
	//this is a math solution...
    public String getPermutation(int n, int k) {
        StringBuilder sb = new StringBuilder();
        boolean[] used = new boolean[n];

        k = k - 1;
        int factor = 1;
        for (int i = 1; i < n; i++) {
            factor *= i;
        }

        for (int i = 0; i < n; i++) {
            int index = k / factor;
            k = k % factor;
            for (int j = 0; j < n; j++) {
                if (used[j] == false) {
                    if (index == 0) {
                        used[j] = true;
                        sb.append((char) ('0' + j + 1));
                        break;
                    } else {
                        index--;
                    }
                }
            }
            if (i < n - 1) {
                factor = factor / (n - 1 - i);
            }
        }
        return sb.toString();
    }
    //back tracking, time exceed limit
    public String getPermutation(int n, int k) {
    	List<String> permutations = new ArrayList<String>();
    	helper(permutations, n , k , "");
    	return permutations.size() == 0? "" : permutations.get(k - 1);
    }
    private void helper(List<String> list, int n, int k, String tmp) {
    	if(list.size() >= k) {
    		return;
    	}
    	if(tmp.length() == n) {
    		list.add(tmp);
    		return;
    	}
    	for (int i = 1; i <= n; i++) {
    		if(!tmp.contains(Integer.toString(i))) {
    			helper(list, n, k, tmp + Integer.toString(i));
    		}
    	}

    }
}