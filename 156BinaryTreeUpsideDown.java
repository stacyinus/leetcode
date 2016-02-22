/*
156. Binary Tree Upside Down
Given a binary tree where all the right nodes are either leaf nodes with a sibling 
(a left node that shares the same parent node) or empty, flip it upside down and turn 
it into a tree where the original right nodes turned into left leaf nodes. 
Return the new root.
For example:
Given a binary tree {1,2,3,4,5},
    1
   / \
  2   3
 / \
4   5
return the root of the binary tree [4,5,2,#,#,3,1].
   4
  / \
 5   2
    / \
   3   1  
confused what "{1,#,2,3}" means? > read more on how binary tree is serialized on OJ.
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
	//iterative
    public TreeNode upsideDownBinaryTree(TreeNode root) {
       	TreeNode right,tmp=null;
       	TreeNode left;
    	while(root!=null){
			left = root.left;
    		root.left = right;
    		right=root.right;
    		root.right = tmp;
    		tmp = root;
    		root = left;
    	}
    	return tmp;
    }

    //recursive
    public TreeNode upsideDownBinaryTree(TreeNode root){
    	if(root==null||root.left==null)
    		return root;
    	return helper(root, null, null);

    }
    private TreeNode helper(TreeNode root, TreeNode left, TreeNode right ){
    	TreeNode l = root.left;
    	TreeNode r = root.right;
    	root.left = left;
    	root.right = right;
    	if(l==null)
    		return root;
    	return helper(l,r,root);
    	
    }
}