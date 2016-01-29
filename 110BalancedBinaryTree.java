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
    //recursive
    public boolean isBalanced(TreeNode root) {
        if(root == null)
            return true;
        return depth(root)!=-1;
        
    }
    public int depth(TreeNode t){
        if(t==null)
            return 0;
        int left = depth(t.left);
        int right = depth(t.right);
        if(left==-1||right==-1||Math.abs(left-right)>1)
            return -1;
        return Math.max(left,right)+1;
    }
    //iterative
    public boolean isBalanced2(TreeNode root) {
        return true;
    }

}