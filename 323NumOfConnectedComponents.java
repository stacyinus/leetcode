/*
323. Number of Connected Components in an Undirected Graph
Given n nodes labeled from 0 to n - 1 and a list of undirected edges (each edge is a pair of nodes), 
write a function to find the number of connected components in an undirected graph.
Example 1:
     0          3
     |          |
     1 --- 2    4
Given n = 5 and edges = [[0, 1], [1, 2], [3, 4]], return 2.
Example 2:
     0           4
     |           |
     1 --- 2 --- 3
Given n = 5 and edges = [[0, 1], [1, 2], [2, 3], [3, 4]], return 1.
Note:
You can assume that no duplicate edges will appear in edges. Since all edges are undirected, [0, 1] is the same as [1, 0] 
and thus will not appear together in edges.
*/

public class 323NumOfConnectedComponents{
	int[] id = null;
    public int countComponents(int n, int[][] edges) {
    	id = new int[n];
    	for(int i=0;i<n;i++)
    		id[i]=i;
    	for(int i=0;i<edges.length;i++)
    		union(edges[i][0],edges[i][1]);
    	int r = 0;
    	for(int i=0;i<n;i++)
    		if(id[i]==i)
    			r++;
    	return r;

    }
    private int root(int i){
    	while(id[i]!=i)
    		i=id[i];
    	return i;
    }
    private void union(int p, int q){
    	int rootP = root(p);
    	int rootQ = root(q);
    	id[rootP]=rootQ;
    }
}    