/*
279. Perfect Squares

Given a positive integer n, find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...) which sum to n.

For example, given n = 12, return 3 because 12 = 4 + 4 + 4; given n = 13, return 2 because 13 = 4 + 9.
*/

public class Solution {
    public int numSquares(int n) {
    	int[] tmp = new int[n+1];
    	Arrays.fill(tmp, 0);
        for(int i = 1; i*i <= n; i++){
        	tmp[i*i] = 1;
        	for(int j = i*i+1; j <= n ; j++){
        		if(tmp[j-i*i]!=0)
        			tmp[j] = tmp[j-i*i] + 1 > tmp[j] && tmp[j]!= 0 ? tmp[j] : tmp[j-i*i] + 1;
        	}
        }
        return tmp[n];
    }
}	