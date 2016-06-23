/*
96. Unique Binary Search Trees
Given n, how many structurally unique BST's (binary search trees) that store values 1...n?

For example,
Given n = 3, there are a total of 5 unique BST's.

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3
*/
/*
    DP: DP array dp[i] representing the num of unique BSTs from 1 to i. dp[1] = 1
        return dp[n]. 
        dp[i] = num of BSTs with root being 1 + num of BSTs with root being 2 + .... + 
                num of BSTs with root being i
        num of BSTs with root being i = dp[i-1] (left subtree has i - 1 nodes) * dp[n - i] (right subtree has i - 1 nodes)
        hence we know how to get dp[n] using dp[1] -- dp[n-1]
        
        eg: dp[i] = num of unique BSTs given i numbers
            f[i] = num of unique BSTs with i being root
        dp[5] = f[5]    +      f[4]     +   f[3]        +       f[2]    + f[1]
              = dp[4]   + dp[3] * dp[1] + dp[2] * dp[2] + dp[1] * dp[3] + dp[4]
 
    Time Complexity : O(n2)
*/

public class Solution {
    public int numTrees(int n) {
        if (n < 0) {
            return -1;
        }
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i ++) {
            int tmp = dp[i-1];
            for (int j = i - 1; j > 1; j--) {
                tmp += dp[j - 1] * dp[i - j];
            }
            tmp += dp[i-1];
            dp[i] = tmp;
        }
        return dp[n];
    } 
    //fxxk, I spent fxxking whole day trying to think about how I came up 
    //with this method by myself but I cant' remember!!!!!!

    //DP, define 2 arrays int[n] a1 and a2, a1 is storing the number of unique binary search trees for given i. 
    //looping through a1 and, a2 is storing the number of bst with i being the root
    public int numTrees(int n) {
    	int[] num = new int[n+1];
    	int[] count = new int[n+1];
    	num[0] = 0;
    	num[1] = 1;
    	count[0] = 0;
    	count[1] = 1;
    	for(int i = 2; i <= n ; i++ ){
    		count[i] = num[i-1];
    		for(int j = i - 1; j > 1; j--){
    			count[j] = num[i-j] * num[j-1];
    		}
    		count[1] = num[i-1];
    		for(int j = 1; j <= i; j++ )
    			num[i] += count[j];
    	} 	   
    	return num[n];
    }
}