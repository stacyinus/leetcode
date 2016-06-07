/*
200. Number of Islands

Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by 
connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

Example 1:

11110
11010
11000
00000
Answer: 1

Example 2:

11000
11000
00100
00011
Answer: 3
*/

public class Solution {
	class UnionFind{
		int[] fathers;
		int count = 0;
		public UnionFind(char[][] grid){
			fathers  = new int[grid.length * grid[0].length];
			for(int i = 0; i < grid.length; i++)
    			for(int j = 0; j < grid[0].length; j++){
    				if(grid[i][j] == '1'){
    					fathers[i*grid[0].length+j] = i*grid[0].length+j;	
    					count++;
    				}
				}
		}

		public void union(int i, int j){
			int f1 = find(i);
			int f2 = find(j);
			if(f1 != f2){
				fathers[f2] = f1;
				count--;
			}
		}
		public int find(int i){
			while(fathers[i] != i){
				fathers[i] = fathers[fathers[i]];	
				i = fathers[i];			
			}
			return i;
		}
	}
	//union find: very slow
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0)
    		return 0;
    	UnionFind uf = new UnionFind(grid);
    	int result = 0;
    	for(int i = 0; i < grid.length; i++)
    		for(int j = 0; j < grid[0].length; j++){
    			if(grid[i][j] == '1'){
    				if(i > 0 && grid[i-1][j] == '1')
    					uf.union(i*grid[0].length + j, (i-1)*grid[0].length + j);
    				if(i < grid.length - 1 && grid[i+1][j] == '1')
    					uf.union(i*grid[0].length + j, (i+1)*grid[0].length + j);
    				if(j > 0 && grid[i][j-1] == '1')
    					uf.union(i*grid[0].length + j, i*grid[0].length + j - 1);
    				if(j < grid[0].length - 1 && grid[i][j+1] == '1')
    					uf.union(i*grid[0].length + j, i*grid[0].length + j + 1);
    			}
    		}
    	return uf.count;
    }
	//dfs
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0)
    		return 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int count = 0;
        for(int i = 0 ; i < grid.length; i++)
        	for(int j = 0; j < grid[i].length; j++){
        		if(!visited[i][j]){
	        		if(grid[i][j] == '1'){
	        			count++;
	        	        dfs(grid, visited, i, j);
	        		}
        		}
        	}
        return count;
    }
    private void dfs(char[][] grid, boolean[][] visited, int i, int j){
    	if(i < 0 || i > grid.length - 1 || j < 0 || j > grid[i].length - 1 || visited[i][j])
    		return;        
    	visited[i][j] = true;
        if(grid[i][j] == '1'){
            dfs(grid, visited, i-1, j);  
            dfs(grid, visited, i+1, j);
            dfs(grid, visited, i, j-1);
            dfs(grid, visited, i, j+1);
        }
    }
}