/*
124. Binary Tree Maximum Path Sum

Given a binary tree, find the maximum path sum.

For this problem, a path is defined as any sequence of nodes from some starting node to any node in the tree along the parent-child connections. 
The path does not need to go through the root.

For example:
Given the below binary tree,

       1
      / \
     2   3
Return 6.
*/


/*
  

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
    public int maxPathSumFromRoot(TreeNode root) {
        if (root == null) return 0;
        int left = maxPathSumFromRoot(root.left);
        int right = maxPathSumFromRoot(root.right);
        return Math.max(Math.max(left, right), 0 ) + root.val;
    }
    public int maxPathSum(TreeNode root){
      if(root == null)
        return Integer.MIN_VALUE;
      int left = maxPathSumFromRoot(root.left);
      int right = maxPathSumFromRoot(root.right);
      int crossOver = Math.max(left, 0) + Math.max(0, right) + root.val;
        //System.out.println("crossOver = " + crossOver);
        int leftOnly = maxPathSum(root.left);
        //System.out.println("leftOnly = " + leftOnly);
        int rightOnly = maxPathSum(root.right);
        //System.out.println("rightOnly = " + rightOnly);
      return Math.max(Math.max(leftOnly, rightOnly), crossOver);
    }
}