/*
222. Count Complete Tree Nodes
Given a complete binary tree, count the number of nodes.

Definition of a complete binary tree from Wikipedia:
In a complete binary tree every level, except possibly the last, is completely filled, and all nodes in the last level are as far left as possible. It can have between 1 and 2h nodes inclusive at the last level h.
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
    public int countNodes(TreeNode root) {
        int k = height(root);
        return countNodes( root, k );
    }
    private int countNodes(TreeNode root, int k){
        if(root == null)
            return 0;
        int r = height(root.right);
        if( r == k - 1 )
            return (1 << r) + countNodes(root.right, r);
        return (1 << r)  + countNodes(root.left, k-1 );        
    }
    private int height(TreeNode root){
        int i = 0;
        while(root != null){
            root = root.left;
            i++;
        }
        return i;
    }
}