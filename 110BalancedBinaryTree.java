/*
110. Balanced Binary Tree

Given a binary tree, determine if it is height-balanced.

For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
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
public class 110BalancedBinaryTree {
    public boolean isBalanced(TreeNode root) {
        
    }
    private int depth(TreeNode root){
    	if(root == null)
    		return 0;
    	return Math.max(depth(root.left),depth(root.right))	+1;
    }

}