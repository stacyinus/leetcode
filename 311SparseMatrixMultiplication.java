/*
311. Sparse Matrix Multiplication
Given two sparse matrices A and B, return the result of AB.
You may assume that A's column number is equal to B's row number.
Example:
A = [
  [ 1, 0, 0],
  [-1, 0, 3]
]

B = [
  [ 7, 0, 0 ],
  [ 0, 0, 0 ],
  [ 0, 0, 1 ]
]


     |  1 0 0 |   | 7 0 0 |   |  7 0 0 |
AB = | -1 0 3 | x | 0 0 0 | = | -7 0 3 |
                  | 0 0 1 |
*/

public class 311SparseMatrixMultiplication {

    public int[][] multiply(int[][] A, int[][] B) {
    	if(A==null||B==null)
    		return null;
    	int[][] result = new int[A.length][B[0].length];//here A.length==B[0].length
    	int col = 0;
    	for(int i=0;i<A.length;){
    		int sum = 0;
    		for(int j=0;j<B[0].length;j++)
    			sum+=A[i][j]*B[j][col];
    		result[i][col++] = sum;
    		if(col==A.length){
    			col=0;
    			i++;
    		}
    	}
    	return result;
    }
    
    public int[][] multiply2(int[][] A, int[][] B) {
    	if(A==null||B==null)
    		return null;
    	int[][] result = new int[A.length][B[0].length];//here A.length==B[0].length
    	for(int i=0;i<A.length;){
    		for(int j=0;j<A[0].length;j++)
    			if(A[i][j]!=0){
    				for(int k=0;k<B[0].length;k++)
 		   				result[int][k]+=A[i][j]*B[j][k];
    			}
    			
    	}
    	return result;
    }
}