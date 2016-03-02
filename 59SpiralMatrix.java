/*
59. Spiral Matrix II
Given an integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.

For example,
Given n = 3,

You should return the following matrix:
[
 [ 1, 2, 3 ],
 [ 8, 9, 4 ],
 [ 7, 6, 5 ]
]
*/

public class Solution {
    public int[][] generateMatrix(int n) {
    	int[][] matrix = new int[n][n];
    	int last=0;
    	while((n-2*i)>0){
    		int tn = (n-2*i);
    		int row1=i;
    		int row2=n-1-i;
    		int k = 0;
    		for(int j=i;j<tn;j++){
    			matrix[row1][j]=last+k+1;
    			matrix[row2][j]=last+3*tn-2-k++;
    		}
    		for(int j=i+1;j<n-2*(i+1);j++)
    		last = 2*n+2*(n-2);
    	}
        
    }
}