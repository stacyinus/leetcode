/*
199. Binary Tree Right Side
Given a binary tree, imagine yourself standing on the right side of it, 
return the values of the nodes you can see ordered from top to bottom.

For example:
Given the following binary tree,
   1            <---
 /   \
2     3         <---
 \     \
  5     4       <---
You should return [1, 3, 4].
*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
	//This is what we say 'slow like a dog'...
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        Stack<Integer> levels = new Stack<Integer>();
        int level = 0;
        while(root!=null||!stack.isEmpty()){
        	if(root!=null){
	        	stack.push(root);
	        	levels.push(level);
	        	root = root.left;
	        	level++;
	        	if(list.size()<level)
	        		list.add(0);
        	}
        	else{
        		TreeNode n = stack.pop();
        		level = levels.pop();	
        		list.set(level,n.val);
        		root = n.right;
        		if(root!=null)
	        		level++;
        	}
        }
        return list;
    }
    //DFS
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        dfs(list,root,1);
        return list;
    }
    private void dfs(List<Integer> list, TreeNode node, int level){
        if(node==null)
            return;
        if(list.size()<level)
            list.add(node.val);
        dfs(list,node.right,level+1);
        dfs(list,node.left,level+1);
    }

    //BFS
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        if(root!=null)
            queue.add(root);
        while(queue.size()>0){
            int size = queue.size();
            for(int i=0;i<size;i++){
                TreeNode n = queue.poll();
                if(i==size-1)
                    list.add(n.val);
                if(n.left!=null)
                    queue.add(n.left);
                if(n.right!=null)
                    queue.add(n.right);
            }
        }
        return list;
    }
}