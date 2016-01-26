/*
Given a binary tree, find its maximum depth.

The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
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
public class 104MaximumDepthOfBTree {

	//recursive
    public int maxDepth(TreeNode root) {
        if(root == null)
            return 0;
        int leftDepth =  1 + maxDepth(root.left);
        int rightDepth = 1 +maxDepth(root.right);
        if( leftDepth > rightDepth )
            return leftDepth;
        return rightDepth;
    }   
    //Todo: do it iteratively
    public int maxDepth1(TreeNode root) {

    }     
}