/*
64. Minimum Path Sum

Given a m x n grid filled with non-negative numbers, 
find a path from top left to bottom right which 
minimizes the sum of all numbers along its path.

Note: You can only move either down or right at any point in time.
*/
/*
    DP: use the dp array to track from top left to the current point, w
        what is the minimum path. 
    Time : O(mn)
    Space: O(1) we can use the input array to be the dp array.
*/
public class Solution {
    public int minPathSum(int[][] grid) {
    	if(grid.length==0||grid[0].length==0) return 0;
        for(int i=1;i<grid.length;i++)
        	grid[0][i]+=grid[0][i-1];
        for(int i=1;i<grid[0].length;i++)
        	grid[i][0]+=grid[i-1][0];
        for(int i=1;i<grid.length;i++)
        	for(int j=1;j<grid[0].length;j++)
        		grid[i][j]=grid[i-1][j]>grid[i][j-1]?grid[i-1][j]+grid[i][j]:grid[i][j-1]+grid[i][j];
        return grid[grid.length-1][grid[0].length-1];
    }
}