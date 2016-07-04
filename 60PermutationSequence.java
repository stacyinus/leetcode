/*
60. Permutation Sequence

The set [1,2,3,…,n] contains a total of n! unique permutations.

By listing and labeling all of the permutations in order,
We get the following sequence (ie, for n = 3):

"123"    1
"132"    2
"213"    3
"231"    4
"312"    5
"321"    6
Given n and k, return the kth permutation sequence.

Note: Given n will be between 1 and 9 inclusive.
*/
/*
	DFS backtracking is too slow for this problem, we can skip many cases based on the number k, and i!
	For example: n = 3, k = 4 (3!= 6) f[i] store the value of i!, so f[1] = 1, f[2] = 2, f[3] = 6
                for the first digit,  it coulde be 1, 2, or 3, and each number has 2! cases
                so k / (n - 1)! can tell us which number it should be. 
                here k should start from k - 1 because it could save us a lot of code to pick the first digit， see:
                
                  use k ,  use k-1
                -------------------
                1/2! = 0, 0/2! = 0;
                2/2! = 1, 1/2! = 0;
                3/2! = 1, 2/2! = 1;
                4/2! = 2, 3/2! = 1;
                5/2! = 2, 4/2! = 2;
                6/2! = 3, 5/2! = 2;


                now we have first digit k / (n - 1)! , in this case 1, this means, we should pick the #1 unused number,which is 2
                (1 is #0, 2 is #1, 3 is #2).  now k = k % (n - 1)!.
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