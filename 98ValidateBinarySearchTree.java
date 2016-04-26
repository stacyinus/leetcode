/*
98. Validate Binary Search Tree  
Given a binary tree, determine if it is a valid binary search tree (BST).

Assume a BST is defined as follows:

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.
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
    //traverse and see if it is acending order
    public boolean isValidBST(TreeNode root) {
        ArrayList<Integer> list = traverse(root);
        for(int i=0; i<list.size()-1; i++){
            if(list.get(i+1) <= list.get(i))
                return false;
        }
        return true;
    }
    private ArrayList<Integer> traverse(TreeNode root){
        ArrayList<Integer> result = new ArrayList<Integer>();
        if(root == null)
            return result;
        result.addAll(traverse(root.left));
        result.add(root.val);
        result.addAll(traverse(root.right));
        return result;
    }
    
    //get left tree max value and right tree min value
    class ResultType {
        int min;
        int max;
        public ResultType(int min, int max){
            this.min = min;
            this.max = max;
        }
    }
    public boolean isValidBST(TreeNode root) {
        if( root == null )
            return true;
        
    }
    
    private ResultType helper(TreeNode root) {
        if( root == null )
            return new ResultType(Integer.MAX_VALUE, Integer.MIN_VALUE);
        ResultType left = helper(root.left); 
        
        ResultType right = helper(root.right);
    }
}