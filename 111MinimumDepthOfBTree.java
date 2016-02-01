/*
111. Minimum Depth of Binary Tree

Given a binary tree, find its minimum depth.

The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
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
public class 111MinimumDepthOfBTree {
	//recursive
    public int minDepth(TreeNode root) {
        if(root==null)
        	return 0;
        if(root.left==null)
        	return minDepth(root.right)+1;
        if(root.right==null)
        	return minDepth(root.right)+1;
        return(Math.min(minDepth(root.right),minDepth(root.left))+1);
    }

}