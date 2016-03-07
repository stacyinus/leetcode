/*
73. Set Matrix Zeroes
Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in place.

click to show follow up.

Follow up:
Did you use extra space?
A straight forward solution using O(mn) space is probably a bad idea.
A simple improvement uses O(m + n) space, but still not the best solution.
Could you devise a constant space solution?
*/

public class Solution {
	//O(m + n) space
    public void setZeroes(int[][] matrix) {
    	Set<Integer> rows = new HashSet<Integer>();
    	Set<Integer> cols = new HashSet<Integer>();
		for(int i=0;i<matrix.length;i++){
			for(int j=0;j<matrix[0].length;j++)
				if(matrix[i][j]==0){
					rows.add(i);
					cols.add(j);
				}
		}
		for(Integer i: rows)
			for(int j=0;j<matirx[i].length;j++)
				matrix[i][j]=0; 
		for(Integer i: cols)
			for(int j=0;j<matirx.length;j++)
				matrix[j][i]=0;  				       
    }

    //O(1) Space
    public void setZeroes(int[][] matrix) {
    	boolean firstR=false;
    	boolean firstC=false;
		for(int i=0;i<matrix.length;i++){
			for(int j=0;j<matrix[0].length;j++)
				if(matrix[i][j]==0){
					if(i==0)
						firstR = true;
					if(j==0)
						firstC = true;
					matrix[0][j]=0;
					matrix[i][0]=0;
				}
		}	
		for(int i=1;i<matrix[0].length;i++){
			if(matrix[0][i]==0)
				for(int j=0;j<matrix.length;j++)
					matrix[j][i]=0;
    	}
    	for(int i=1;i<matrix.length;i++){
			if(matrix[i][0]==0)
				for(int j=0;j<matrix[i].length;j++)
					matrix[i][j]=0;
    	}
    	if(firstR)
    		for(int i=0;i<matrix[0].length;i++)
					matrix[0][i]=0;
		if(firstC)
    		for(int i=0;i<matrix.length;i++)
					matrix[i][0]=0;				
}