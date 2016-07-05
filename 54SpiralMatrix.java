/*
54. Spiral Matrix 
Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.

For example,
Given the following matrix:

[
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]
*/

/*
    思路: rowlow, rowhigh, collow, colhigh.
        先加入rowlow的每一个元素，rowlow++,再加入colhigh的每一个元素，col++.
        如果此时rowhigh <= rowlow,加入rowhigh的所有元素；
        如果此时collow <= colhigh,加入colhigh的所有元素。
*/

public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<Integer>();
        if (matrix == null || matrix.length == 0) {
            return result;
        }
        int row1 = 0, row2 = matrix.length - 1, col1 = 0, col2 = matrix[0].length - 1;
        while (row1 <= row2 && col1 <= col2) {
            for (int i = col1; i <= col2 ; i++ ){ //add the first row
                result.add(matrix[row1][i]);
            }
            row1++;
            for (int i = row1; i <= row2 ; i++) { //add the last col
                result.add(matrix[i][col2]);
            }
            col2--;
            for (int i = col2; i >= col1 && row1 <= row2; i-- ){ //add the last row
                result.add(matrix[row2][i]);
            }
            row2--;
            for (int i = row2; i >= row1 && col1 <= col2; i--) {
                result.add(matrix[i][col1]);
            }
            col1++;
        }
        return result;
    }
}