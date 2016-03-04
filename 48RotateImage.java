/*
48. Rotate Image

You are given an n x n 2D matrix representing an image.

Rotate the image by 90 degrees (clockwise).

Follow up:
Could you do this in-place?
*/

public class Solution {
    public void rotate(int[][] matrix) {
    	if(matrix.length==0) return;
        for(int i=0;i<matrix.length;i++)
        	for(int j=0;j<matrix[0].length/2;j++){
        		int tmp = matrix[i][j];
        		matrix[i][j] = matrix[i][matrix.length-1-j];
        		matrix[i][matrix.length-1-j] = tmp;
        	}
        for(int i=0;i<matrix.length-1;i++)
        	for(int j=0;j<matrix.length-1-i;j++){
        		int tmp = matrix[i][j];
        		matrix[i][j] = matrix[matrix.length-1-j][matrix.length-1-i];
        		matrix[matrix.length-1-j][matrix.length-1-i] = tmp;
        	}
    }
}