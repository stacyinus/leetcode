/*
133. Clone Graph

Clone an undirected graph. Each node in the graph contains a label and a list of its neighbors.


OJ's undirected graph serialization:
Nodes are labeled uniquely.

We use # as a separator for each node, and , as a separator for node label and each neighbor of the node.
As an example, consider the serialized graph {0,1,2#1,2#2,2}.

The graph has a total of three nodes, and therefore contains three parts as separated by #.

First node is labeled as 0. Connect node 0 to both nodes 1 and 2.
Second node is labeled as 1. Connect node 1 to node 2.
Third node is labeled as 2. Connect node 2 to node 2 (itself), thus forming a self-cycle.
Visually, the graph looks like the following:

       1
      / \
     /   \
    0 --- 2
         / \
         \_/
*/

/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
/*
	graph traveral:  tree和graph的区别在于，当traverse的时候，tree的child只可能从current node走到，但是graph的neighbor可能在遍历其他node的时候已经走过了。
					因此需要keep一个HashMap<Integer, UndirectedGraphNode>，把已经创建的node放到map里面，避免创建duplicated node。
			DFS： keep一个全局变量map， 或者pass in map。
			BFS： 永远遍历/创建neighbors， not current node.

*/
public class Solution {
	HashMap<Integer,UndirectedGraphNode> allNodes = new HashMap<Integer,UndirectedGraphNode>();
	//bfs
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null)
        	return null;
        Queue<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
        HashMap<Integer, UndirectedGraphNode> map = new HashMap<Integer, UndirectedGraphNode>();
        queue.add(node);
        UndirectedGraphNode graph = new UndirectedGraphNode(node.label);
        map.put(node.label, graph );
        while (!queue.isEmpty()) {
        	UndirectedGraphNode cur = queue.poll();
        	for (UndirectedGraphNode neighbor : cur.neighbors) {
        		if (!map.containsKey(neighbor.label)) {
        			map.put(neighbor.label, new UndirectedGraphNode(neighbor.label));
        			queue.add(neighbor);
        		}
        		map.get(cur.label).neighbors.add(map.get(neighbor.label));
        	}
        }
        return graph;
    }
	//dfs
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null)
            return null;
        if (allNodes.containsKey(node.label)) {
            return allNodes.get(node.label);
        }
        UndirectedGraphNode cur = new UndirectedGraphNode(node.label);
        allNodes.put(cur.label, cur);
        for (UndirectedGraphNode neighbor: node.neighbors){
            UndirectedGraphNode child = cloneGraph(neighbor);
            cur.neighbors.add(child);
        }
        return cur;
    }

}