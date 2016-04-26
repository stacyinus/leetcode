/*
144. Binary Tree Preorder Traversal

Given a binary tree, return the preorder traversal of its nodes' values.

For example:
Given binary tree {1,#,2,3},
   1
    \
     2
    /
   3
return [1,2,3].

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
public class 144BinaryTreePreorderTraversal {
	//recursive
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        if(root==null)
        	return list;
        list.add(root.val);
        if(root.left!=null)
	        list.addAll(preorderTraversal(root.left));
	    if(root.right!=null)
	    	list.addAll(preorderTraversal(root.right));
	    return list;
    }
    //iterative
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        while(root != null || !stack.isEmpty() ){
            if( root != null ){
                list.add(root.val);
                if( root.right != null )
                    stack.push(root.right);
                root = root.left;
            }
            else
                root = stack.pop();
        }
        return list;
    }
}