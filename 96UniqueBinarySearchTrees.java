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

public class Solution {
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