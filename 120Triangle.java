/*
120. Triangle 

Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.

For example, given the following triangle
[
     [2],
    [3,4],
   [6,5,7],
  [4,1,8,3]
]
The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).

Note:
Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the triangle.
*/


public class Solution {
	//Divide and conquer
    public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle == null || triangle.size() == 0 )
            return Integer.MAX_VALUE;
        return helper(triangle,0,0);
    }
    private int helper(List<List<Integer>> triangle, int x, int y){
        int sum = (triangle.get(x)).get(y); 
        if(x == triangle.size() -1)
            return sum;
        int left = helper(triangle, x+1, y);
        int right= helper(triangle, x+1, y+1);
        return left > right? (right + sum) : (left+sum);
    }

	//DP：recursive
    public int minimumTotal(List<List<Integer>> triangle) {
    	int[][] min = new int[triangle.size()][triangle.size()]; 
    	for(int[] a : min)
    	    Arrays.fill(a, Integer.MAX_VALUE);
        if(triangle == null || triangle.size() == 0)
            return Integer.MAX_VALUE;
        return helper(triangle,min,0,0);
    }
    private int helper(List<List<Integer>> triangle, int[][] min, int x, int y){
        int sum = (triangle.get(x)).get(y);         
        if(x == triangle.size() -1)
            return sum;     
        int left = 0, right = 0;
        if( min[x+1][y] == Integer.MAX_VALUE ){
            left = helper(triangle,min,x+1,y);
            min[x+1][y] = left;
        }
        else 
            left = min[x+1][y];
        if(min[x+1][y+1] == Integer.MAX_VALUE){
            right = helper(triangle,min,x+1,y+1);
            min[x+1][y+1] = right;
        }
        else
            right = min[x+1][y+1];
        return left > right? (right + sum) : (left+sum);
    }       

    //DP：iterative top down
    public int minimumTotal(List<List<Integer>> triangle) {
        int[][] min = new int[triangle.size()][triangle.size()]; 
        if(triangle == null || triangle.size() == 0)
            return Integer.MAX_VALUE;
        for(int i = 0; i < triangle.size() ; i++){
            for(int j = 0; j < triangle.get(i).size(); j++){
                if()
                min[i][j] = triangle.get
            }
        }

    }
}