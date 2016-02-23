/*
230. Kth Smallest Element in a BST
Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.

Note: 
You may assume k is always valid, 1 ≤ k ≤ BST's total elements.

Follow up:
What if the BST is modified (insert/delete operations) often and you need to find the kth smallest frequently? How would you optimize the kthSmallest routine?
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
	ArrayList<TreeNode> 
    public int kthSmallest(TreeNode root, int k) {
    	Stack<TreeNode> stack = new Stack<TreeNode>();
    	stack.push(root);
    	int i=0;
    	TreeNode tmp=null;
    	stack.push(root);
    	while(i<k){
    		if(root.left!=null){
    			stack.push(root.left);
    			root = root.left;
    		}
    		else{
    			tmp = stack.pop();
    			i++;
    			if(tmp.right!=null)
    				root = tmp.right;
    		}
    		
    	}
    	return tmp.val;
    }
}