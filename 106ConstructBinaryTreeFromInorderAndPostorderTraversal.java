/*
106. Construct Binary Tree from Inorder and Postorder Traversal
Given inorder and postorder traversal of a tree, construct the binary tree.

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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder.length == 0)
            return null;
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        //this map is used for quickly search for the index of a value.
    	for(int i = 0; i< inorder.length; i++)
    		map.put(inorder[i], i);
    	return helper( map, 0, inorder.length - 1, postorder, postorder.length -1 );
    }

    private TreeNode helper(HashMap<Integer,Integer> map, int s, int e, int[] postorder, int p){
    	TreeNode root = new TreeNode( postorder[p] );
    	int index = map.get(postorder[p]);
    	int rightSize = e - index;
    	if(index < e)
    		root.right = helper(map, index + 1, e, postorder, p-1);
    	if(index > s)
    		root.left = helper(map, s, index - 1, postorder, p-1-rightSize);
    	return root;
    }
}