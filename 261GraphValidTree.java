/*
261	Graph Valid Tree

Given n nodes labeled from 0 to n - 1 and a list of undirected edges (each edge is a pair of nodes), write a function to check whether these edges make up a valid tree.

 Notice

You can assume that no duplicate edges will appear in edges. Since all edges are undirected, [0, 1] is the same as [1, 0] and thus will not appear together in edges.


Example
Given n = 5 and edges = [[0, 1], [0, 2], [0, 3], [1, 4]], return true.

Given n = 5 and edges = [[0, 1], [1, 2], [2, 3], [1, 3], [1, 4]], return false.
*/


public class Solution {
    /**
     * @param n an integer
     * @param edges a list of undirected edges
     * @return true if it's a valid tree, or false
     */
    class UnionFind{
        int[] fathers;
        int count = 0;
        public UnionFind(int i){
            fathers = new int[i];
            count = i;
            for(int k = 0 ;k < i; k++)
                fathers[k] = k;
        }
        
        public boolean union(int i, int j){
            int f1 = find(i);
            int f2 = find(j);
            if(f1 == f2)
                return false;
            fathers[f2] = f1;
            count--;
            return true;
        }
        
        public int find(int i){
            while(fathers[i]!=i){
                fathers[i] = fathers[fathers[i]];
                i = fathers[i];
            }
            return i;
        }
    }
    public boolean validTree(int n, int[][] edges) {
        // Write your code here
        if(n == 0 || n == 1)
            return true;
        if(edges == null || edges.length == 0 || edges[0].length == 0)
            return false;
        UnionFind uf = new UnionFind(n);
        for(int i = 0; i < edges.length; i++)
            if(!uf.union(edges[i][0], edges[i][1]))
                return false;
        return uf.count == 1;
    }
}