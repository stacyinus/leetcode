/*
94. Binary Tree Inorder Traversal

Given a binary tree, return the inorder traversal of its nodes' values.

For example:
Given binary tree {1,#,2,3},
   1
    \
     2
    /
   3
return [1,3,2].

Note: Recursive solution is trivial, could you do it iteratively?
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
public class 94BinaryTreeInorderTraversal {
	//recursive
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        if(root == null)
        	return list;
        if(root.left!=null)
	        list.addAll(inorderTraversal(root.left));
        list.add(root.val);
        if(root.right!=null)
	        list.addAll(inorderTraversal(root.right));
	    return list;
    }
    //iterative: use stack
    public List<Integer> inorderTraversal(TreeNode root) { 
    	Stack<TreeNode> s = new Stack<TreeNode>();
    	List<Integer> list = new ArrayList<Integer>();
    	while(root!=null||!s.empty()){
    		if(root!=null){
    			s.push(root);
    			root = root.left;
    		}
    		else if(!s.empty()){
    			list.add(s.peek().val);
    			root = s.pop().right;
    		}
    	}
    	return list;
    }
}