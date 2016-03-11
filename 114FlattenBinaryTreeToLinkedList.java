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
		if(root==null)
        	return;
        TreeNode left = root.left;
        if(left!=null){
			TreeNode right = root.right;
	        root.right = left; 
	        while(left.right!=null)
	        	left = left.right;
	        left.right = right;        	
        }
        flatten(root.right);
    }
}