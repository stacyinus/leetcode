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
	//iterative : find formula...You are nuts if you choose this method during an interview...
    public int[][] generateMatrix(int n) {
    	int[][] matrix = new int[n][n];
    	int beginning=0;
    	int last=0;
    	int i=0;
    	while((n-2*i)>0){
    		beginning = last+1;
    		int tn = (n-2*i);
    		int k = 0;
    		for(int j=i;j<tn+i;j++){
    			matrix[i][j]=beginning+k;
    			matrix[n-1-i][j]=last+3*tn-2-k;
    			k++;
    		}
    		k=0;
    		last += 2*tn+2*(tn-2);
    		for(int j=i+1;j<=n-1-i;j++){
    			matrix[j][i]= last-k;
    			matrix[j][n-1-i]=beginning+tn+k;
    			k++;
    		}	
    		i++;
    	}
       	return matrix;
    }
    //iterative: not working...
    public int[][] generateMatrix(int n) {
    	if(n==1) 
    		return new int[][]{{1}};
    	int num = 1;
    	int i = 0;
    	int[][] matrix = new int[n][n];
    	while((n-2*i)>0){
    		int j=i;
    		for(;j<n-1-i;j++){
    			matrix[i][j]=num;
    			matrix[j][n-1-i]=num+n-1-i;
    			num++;
    		}
    		num = num+n-1-i;
    		for(;j>0;j--){
    			matrix[n-1-i][j]=num;
    			matrix[j][i]=num+n-1-i;
    			num++;
    		}
    		num = num+n-1-i;
    		i++;
    	}
    	return matrix;
    }
}

