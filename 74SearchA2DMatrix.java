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
//second round with refactor.
public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int[] cols = new int[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            cols[i] = matrix[i][0];
        }
        int row = bsearch(cols, target);
        if (row == -1) return false;
        System.out.println("row is " + row);
        int[] rows = new int[matrix[row].length];
        for (int i = 0; i < matrix[row].length; i++) {
            rows[i] = matrix[row][i];
        }
        int col = bsearch(rows, target);
        System.out.println("col is " + col);
        return matrix[row][col] == target;
    }

    private int bsearch(int[] nums, int target) {
        System.out.println("searching " + target + " from " + Arrays.toString(nums));
        int s = 0, e = nums.length - 1;
        while (s + 1 < e) {
            int m = s + (e - s)/2;
            if (nums[m] == target) return m;
            else if (nums[m] < target) s = m;
            else e = m;
        }
        if (nums[e] <= target) return e;
        if (nums[s] <= target) return s;
        return -1;
    }
}

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
}