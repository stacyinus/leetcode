/*
	305	Number of Islands II 
	 

岛屿的个数II

给定 n，m，分别代表一个2D矩阵的行数和列数，同时，给定一个大小为 k 的二元数组A。起初，2D矩阵的行数和列数均为 0，即该矩阵中只有海洋。
二元数组有 k 个运算符，每个运算符有 2 个整数 A[i].x, A[i].y，你可通过改变矩阵网格中的A[i].x]，[A[i].y] 来将其由海洋改为岛屿。请在每次运算后，返回矩阵中岛屿的数量。

 注意事项

0 代表海，1 代表岛。如果两个1相邻，那么这两个1属于同一个岛。我们只考虑上下左右为相邻。

您在真实的面试中是否遇到过这个题？ Yes
样例
给定 n = 3, m = 3， 二元数组 A = [ (0,1),(2,2),(2,1)].

返回 [1,1,2,2].
*/

/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */
public class Solution {
    /**
     * @param n an integer
     * @param m an integer
     * @param operators an array of point
     * @return an integer array
     */
    
    class UnionFind{
        int[] fathers;
        int[][] grid;
        int row = 0;
        int col = 0;
        int count = 0;
        List<Integer> counts;
        
        public UnionFind(int n, int m){
            fathers = new int[n*m];
            grid = new int[n][m];
            counts = new ArrayList<Integer>();
            row = n;
            col = m;
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
        
        public void turnToLand(int i, int j){
            grid[i][j] = 1;
            int index = i * col + j;
            fathers[index] = index;//this is an island
            count++;
            
            if(i > 0 && grid[i-1][j] == 1)
                union(index, (i - 1) * col + j);
            if(i < row - 1 && grid[i+1][j] == 1)
                union(index, (i + 1) * col + j);
            if(j > 0 && grid[i][j-1] == 1)
                union(index, index - 1);
            if(j < col - 1 && grid[i][j+1] == 1)
                union(index, index + 1);    
            counts.add(count);
        }
    }
    public List<Integer> numIslands2(int n, int m, Point[] operators) {
        // Write your code here
        if(n <= 0 || m <= 0 || operators == null || operators.length == 0)
            return new ArrayList<Integer>();
        UnionFind uf = new UnionFind(n, m);
        for(Point p: operators)
            uf.turnToLand(p.x,p.y);
        return uf.counts;
    }
}