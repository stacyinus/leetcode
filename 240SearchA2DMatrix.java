/*
240. Search a 2D Matrix II
Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

Integers in each row are sorted in ascending from left to right.
Integers in each column are sorted in ascending from top to bottom.
For example,

Consider the following matrix:

[
  [1,   4,  7, 11, 15],
  [2,   5,  8, 12, 19],
  [3,   6,  9, 16, 22],
  [10, 13, 14, 17, 24],
  [18, 21, 23, 26, 30]
]
Given target = 5, return true.

Given target = 20, return false.
*/

public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {    	
    	int r = 0;
    	boolean[] row = new boolean[matrix.length];
    	boolean[] col = new boolean[matrix[0].length];
    	while(r<matrix.length){
    		int s=0,e=matrix[r].length-1, mid =0;
    		if(row[r]) return false;
			while(s<=e){
				row[r]=true;
				mid = s+(e-s)/2;
				if(matrix[r][m]==target)
					return true;	
				if(matrix[r][m]>target)
					e=m-1;
				else
					s=m+1;
			}
			int c = e;
			if(c<0||col[c])return false;
			s=0;
			e= matrix.length-1;
			while(s<=e){
				col[c]=true;
				mid = s+(e-s)/2;
				if(matrix[m][c]==target)
					return true;
				if(matrix[m][c]>target)
					e=m-1;
				else
					s=m+1;
			}	
			r = s;		
    	}
    	return false; 
    }
}