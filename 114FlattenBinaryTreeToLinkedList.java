/*
114. Flatten Binary Tree to Linked List
Given a binary tree, flatten it to a linked list in-place.

For example,
Given

         1
        / \
       2   5
      / \   \
     3   4   6
The flattened tree should look like:
   1
    \
     2
      \
       3
        \
         4
          \
           5
            \
             6
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
    public void flatten(TreeNode root) {
        if(root == null || root.left == null && root.right == null)
            return;
        while(root != null){
            if(root.left == null){
                root = root.right;
                continue;
            }
            TreeNode left = root.left;
            while(left.right != null)
                left = left.right;
            left.right = root.right;
            root.right = root.left;
            root.left = null;
            root = root.right;
        }
    }

    public void flatten(TreeNode root) {
        if(root == null || root.left == null && root.right == null)
            return;
        TreeNode left = root.left;
        TreeNode right= root.right;
        if(left != null){
            while(left.right != null)
                left = left.right;
            root.right = root.left;
            left.right = right;
            root.left = null;
        }   
        flatten(root.right);      
    }
}