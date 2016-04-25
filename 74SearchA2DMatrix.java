/*
74. Search a 2D Matrix 
Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

Integers in each row are sorted from left to right.
The first integer of each row is greater than the last integer of the previous row.
For example,

Consider the following matrix:

[
  [1,   3,  5,  7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
]
Given target = 3, return true.
*/

public class Solution {
	public boolean searchMatrix(int[][] matrix, int target) {	
		//second round
		int s = 0, e = matrix.length-1, row = 0, col = 0;
		while(s + 1 < e){
			int m = s + ( e - s ) / 2;
			if(matrix[m][0] == target)
				return true;
			else if(matrix[m][0] < target)
				s = m;
			else
				e = m;
		}
		row = matrix[e][0] <= target? e: s;
		s = 0, e = matrix[row].length-1;
		while(s + 1 < e){
			int m = s + ( e - s ) / 2;
			if(matrix[row][m] == target)
				return true;
			else if(matrix[row][m] < target)
				s = m;
			else
				e = m;
		}
		return (matrix[row][s] == target) || (matrix[row][e] == target);
	
	}

    public boolean searchMatrix(int[][] matrix, int target) {	
    	int s = 0, e = matrix.length-1;
    	while(s<=e){
    		int m = s+(e-s)/2;
    		if(matrix[m][0]==target)
    			return true;
    		if(matrix[m][0]>target)
    			e=m-1;
    		else
    			s=m+1;
    	}
    	if(e<0) return false;
    	int row = e;
    	s = 0;
    	e = matrix[row].length-1;
    	while(s<=e){
    		int m = s+(e-s)/2;
    		if(matrix[row][m] == target)
    			return true;
    		if(matrix[row][m]>target)
    			e=m-1;
    		else
    			s=m+1;
    	}
    	return false;
    }
}