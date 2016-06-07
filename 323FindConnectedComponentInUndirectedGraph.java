/*
323. Find the Connected Component in the Undirected Graph

Find the number connected component in the undirected graph. Each node in the graph contains a label and a list of its neighbors. (a connected component (or just component) of an undirected graph is a subgraph in which any two vertices are connected to each other by paths, and which is connected to no additional vertices in the supergraph.)

Example
Given graph:

A------B  C
 \     |  | 
  \    |  |
   \   |  |
    \  |  |
      D   E
Return {A,B,D}, {C,E}. Since there are two connected component which is {A,B,D}, {C,E}

*/

/**
 * Definition for Undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     ArrayList<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    /**
     * @param nodes a array of Undirected graph node
     * @return a connected set of a Undirected graph
     */

    class UnionFind{
    	//a map of label to its father node
    	HashMap<UndirectedGraphNode, UndirectedGraphNode> map;
    	// a map of father to its child node
    	HashMap<UndirectedGraphNode, List<Integer>> connectedSets;
    	
    	//Inintialize all the label to point to
    	public UnionFind(ArrayList<UndirectedGraphNode> nodes){
    		map = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
    		//connectedSets =  new HashMap<UndirectedGraphNode, List<Integer>>();
    		for(UndirectedGraphNode node : nodes){
    			map.put(node, node);
    		}
    	}
    	public void union(UndirectedGraphNode node1, UndirectedGraphNode node2){
    		UndirectedGraphNode father1 = find(node1);
    		UndirectedGraphNode father2 = find(node2);
    		if(father1 != father2)
	    		map.put(father2, father1);
    	}
    	// compressed find
    	public UndirectedGraphNode find(UndirectedGraphNode node){
    		UndirectedGraphNode father = map.get(node);
    		while(father != node){
    			UndirectedGraphNode tmp = node;
    			node = father;
    			father = map.get(node);
    			map.put(tmp, father);
    		}
    		return father;
    	}
    	public List<List<Integer>> getConnectedSet(){
    		HashMap<UndirectedGraphNode, List<Integer>> connectedSets = new HashMap<UndirectedGraphNode, List<Integer>>();   									
   			for(UndirectedGraphNode node : map.keySet()){
   				UndirectedGraphNode father = find(node);	
   				if(connectedSets.containsKey(father)){
   					List<Integer> list  = connectedSets.get(father);
   					list.add(node.label);
   				}
   				else{
					List<Integer> list  = new ArrayList<Integer>();
   					list.add(node.label);
   					connectedSets.put(father, list);
   				} 		
   			}
   			List<List<Integer>> result = new ArrayList<List<Integer>>();
   			for(List<Integer> list : connectedSets.values()){
   				Collections.sort(list);
   				result.add(list);
   			}
   			return result;
    	}
    }
    //Union Find
    public List<List<Integer>> connectedSet(ArrayList<UndirectedGraphNode> nodes) {
        UnionFind uf = new UnionFind(nodes);
        for(UndirectedGraphNode node : nodes){
        	for( UndirectedGraphNode neighbor: node.neighbors)
        		uf.union(neighbor, node);
        }
        return uf.getConnectedSet();
    }

    //bfs
    public List<List<Integer>> connectedSet(ArrayList<UndirectedGraphNode> nodes) {
    	HashMap<UndirectedGraphNode, Boolean> visited = new HashMap<UndirectedGraphNode, Boolean>();
    	for(UndirectedGraphNode node: nodes)
    		visited.put(node, false);
    	List<List<Integer>> result = new ArrayList<List<Integer>>();
    	LinkedList<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
    	for(UndirectedGraphNode node: nodes){
    		if(!visited.get(node)){
	    		queue.push(node);
	    		bfs(queue,result,visited);    			
    		}
    	}
    	return result;
    }
    private void bfs(LinkedList<UndirectedGraphNode> queue, List<List<Integer>> result, HashMap<UndirectedGraphNode, Boolean> visited){
    	List<Integer> list = new ArrayList<Integer>();
    	int size = queue.size();
    	while(!queue.isEmpty()){
    		UndirectedGraphNode node = queue.poll();
    		if(!visited.get(node)){
    			list.add(node.label);
    			visited.put(node, true);
    		}
    		for(UndirectedGraphNode neighbor: node.neighbors)
				if(!visited.get(neighbor))
	    			queue.push(neighbor);
    	}
    	if(list.size() > 0){
    		Collections.sort(list);
    		result.add(list);
    	}
    }
}