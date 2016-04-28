/*
105. Construct Binary Tree from Preorder and Inorder Traversal

Given preorder and inorder traversal of a tree, construct the binary tree.

Note:
You may assume that duplicates do not exist in the tree.
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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(inorder.length == 0)
        	return null;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0; i < inorder.length; i++)
        	map.put(inorder[i],i);
        return helper(map, 0 , inorder.length - 1, preorder, 0);
    }
    private TreeNode helper(HashMap<Integer, Integer> map, int s, int e, int[] preorder, int p){
    	TreeNode root = new TreeNode(preorder[p]);
    	int index = map.get(preorder[p]);
    	int leftSize = index - s;
    	if(index > s)
    		root.left = helper(map, s, index - 1 , preorder, p + 1);
    	if(index < e)
    		root.right = helper(map, index + 1, e, preorder, p + leftSize + 1 );
    	return root;
    }
}