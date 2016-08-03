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
// round 2: becareful of boundry cases
public class Solution {
    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        int num = 1, r = 0;
        while ( n - 1 - r >= r) {
            //populate row r from col r ~ n - 1 
            for (int i = r; i < n - r ; i++) {
                result[r][i] = num++;
            }
            //populate col (n - 1 - r) from row r + 1 ~ n - 1
            for (int i = r + 1; i < n -r ; i++) {
                result[i][n - 1 - r] = num++;
            }
            //populate row (n - 1 - r) if need to from row n - r - 2 to r + 1
            for (int i = n - r - 2; i >= r && n - 1 - r > r ; i--) {
                result[n - 1 - r][i] = num++;
            }
            // populat col r if need to from row n - r - 2 to r + 1
            for (int i = n - r - 2; i > r && n - 1 - r > r ; i--) {
                result[i][r] = num++;
            }
            r++;
        }
        return result;
    }
}
