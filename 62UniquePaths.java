/*
62. Unique Paths

A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).

How many possible unique paths are there?


Above is a 3 x 7 grid. How many possible unique paths are there?

Note: m and n will be at most 100.

*/

public class Solution {
	//first thought...but this is too slow
    public int uniquePaths(int m, int n) {
    	if(m==0||n==0)
    		return 0;
        if(m==1||n==1)
        	return 1;
        return uniquePaths(m-1,n)+uniquePaths(m,n-1);       
    }

    //Second thought:p[i][j] represents the total number of paths to a particular grid(i,j). then we know, p[i][j]=p[i-1][j]+p[i][j-1]
    // we also know that p[i][0] =1 because the robot can only go down
    //p[0][j]=1 because the robot can only go right.
    //T: O(m*n), S: O(m*n)
    public int uniquePaths(int m, int n) {
    	int[][] p = new int[m][n];
    	for(int i=0;i<m;i++)
    		p[i][0]=1;
    	for(int i=0;i<n;i++)
    		p[0][i]=1;
    	for(int i=1;i<m;i++)
    		for(int j=1;j<n;j++)
    			p[i][j]=p[i-1][j]+p[i][j-1];
    	return p[m-1][n-1];
    }
    //Third thought:
    //T: O(m*n), S: O(m+n)
    public int uniquePaths(int m, int n) {
    	int[] p1 = new int[m];
    	for(int i=0;i<m;i++)
    		p1[i]=1;
    	int[] p2 = new int[n];
    	for(int i=0;i<n;i++)
    		p2[i]=1;
    	for(int i=1;i<m;i++)
    		for(int j=1;j<n;j++){
    			p1[i]+=p2[j];
    			p2[j]=p1[i];
    		}
    	return p1[m-1];
    }
    //Fourth thought:
    //T: O(m*n), S: O(min(m,n))
    public int uniquePaths(int m, int n) {
    	if(m<n) return uniquePaths(n, m);
    	int[] p1 = new int[n];
    	for(int i=0;i<n;i++)
    		p1[i]=1;
    	for(int i=1;i<m;i++)
    		for(int j=1;j<n;j++){
    			p1[j]+=p1[j-1];
    		}
    	return p1[n-1];
    }
}