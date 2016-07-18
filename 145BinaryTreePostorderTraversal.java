/*
145. Binary Tree Postorder Traversal  

Given a binary tree, return the postorder traversal of its nodes' values.

For example:
Given binary tree {1,#,2,3},
   1
    \
     2
    /
   3
return [3,2,1].
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
	//recursive
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        if( root == null )
            return list;
        list.addAll(postorderTraversal(root.left));
        list.addAll(postorderTraversal(root.right));
        list.add( root.val );
        return list;        
    }
    //iterative
    public List<Integer> postorderTraversal(TreeNode root) {
        Stack
    }
    //iterative
    public List<Integer> postorderTraversal(TreeNode root) {
    	List<Integer> list = new ArrayList<Integer>();
    	if(root == null)
    		return list;
    	Stack<TreeNode> rights = new Stack<TreeNode>();
    	Stack<TreeNode> roots = new Stack<TreeNode>();
    	while( root != null ){
    			if( root.left == null && root.right == null ){
    				list.add(root.val);
    				while( !roots.isEmpty() && ( roots.peek().right == null || roots.peek().right == root || rights.isEmpty() ) ){
    					TreeNode tmp = roots.pop();
    					list.add(tmp.val);
    					root = tmp;	
    				}
    				root = !rights.isEmpty() ? rights.pop() : null;
   
    			}
    			else if( root.left != null ){
    				if( root.right != null )
	    				rights.push(root.right);   
	    			roots.push(root);	 				
    				root = root.left;	
    			}
    			else{
    				roots.push(root);
		    		root = root.right;   
		    	}		
    	}
    	return list;
    }
}