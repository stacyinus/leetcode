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
	// this is an optimized method from the first version below.  any better idea to further optimize this one? cause it only beats 4%..
	class Result {
		int maxCrossRoot; // include root, maxLeft, maxRight
		int maxFromRoot; // include root, max single path from root to a node.
		public Result(int x, int y) {
			maxCrossRoot = x;
			maxFromRoot = y;
		}
	}
    public Result maxPathSumFromRoot(TreeNode root) {
        if (root == null) {
        	return new Result(Integer.MIN_VALUE, 0);
        }
        Result left = maxPathSumFromRoot(root.left);
        Result right = maxPathSumFromRoot(root.right);
    	int maxFromRoot = Math.max(Math.max(left.maxFromRoot, right.maxFromRoot), 0 ) + root.val; // have to have root as start point
    	int crossRoot = left.maxFromRoot + right.maxFromRoot + root.val;// have to have root as middle
    	int maxCrossRoot = Math.max( Math.max(Math.max(left.maxCrossRoot, right.maxCrossRoot), crossRoot ),maxFromRoot);// doesn't have to have root.
    	return new Result(maxCrossRoot, maxFromRoot);
    }
    public int maxPathSum(TreeNode root){
    	Result result = maxPathSumFromRoot(root);
    	return Math.max(result.maxCrossRoot, result.maxFromRoot);   
    }

    // this is etl, so i optimized this to the upper one
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