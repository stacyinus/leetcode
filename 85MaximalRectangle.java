/*
85. Maximal Rectangle
Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle containing all ones and return its area.
*/
/*
	this is similar to 84.

*/

public class Solution {
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0) {
        	return 0;
        }
        int[][] height = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < height.length; i++ ) {
        	for (int j = 0; j < height[i].length; j++){
        		if (i == 0) {
        			height[0][j] = matrix[0][j] - '0';
        		}
        		else if (matrix[i][j] == '0'){
        			height[i][j] = 0;
        		}
        		else{
        			height[i][j] = height[i-1][j] + 1;
        		}
        		//System.out.print(height[i][j]);
        	}
        	//System.out.println();
        }
        int max = 0;
        for (int i = 0; i < matrix.length; i++) {
        	Stack<Integer> stack = new Stack<Integer>();
        	for (int j = 0; j <= matrix[i].length; j ++) {
	        	int cur = j == matrix[i].length ? -1 : height[i][j];
	        	while (!stack.isEmpty() && cur <= height[i][stack.peek()]) {
	        		int h = height[i][stack.pop()];
	        		int w = stack.isEmpty() ? j : j - stack.peek() - 1;
	        		max = Math.max(h*w, max);
	        	}        		
	        	stack.push(j);
        	}
        }
        return max;
    }
}