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
    //traverse and see if it is acending order, this traverse only once.
    TreeNode prev = null;
    public boolean isValidBST(TreeNode root) {
        if( root == null )
            return true;
        if( !isValidBST(root.left) ) return false;
        if( prev == null || root.val <= prev.val ) return false;
        prev = root;
        return (isValidBST(root.right));
    }


    //traverse and see if it is acending order, this will traverse twice.
    public boolean isValidBST2(TreeNode root) {
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
        int min; //current node's min value
        int max;//current node's max value
        boolean isBST;//current subtree is BST or not
        public ResultType(int min, int max, boolean isBST){
            this.min = min;
            this.max = max;
            this.isBST = isBST;
        }
    }
    public boolean isValidBST3(TreeNode root) {
        if( root == null )
            return true;
        ResultType result = helper(root);
        return result.isBST;
    }
    
    private ResultType helper(TreeNode root) {
        if( root == null )
            return new ResultType(Integer.MAX_VALUE, Integer.MIN_VALUE, true);
        ResultType left = helper(root.left); 
        ResultType right = helper(root.right);
        if(left.isBST && right.isBST){
            if( ( root.left == null || ( root.left != null && root.val > root.left.val && root.val > left.max ) ) 
                && ( root.right == null || ( root.right != null && root.val < root.right.val && root.val < right.min ) ) )
                    return new ResultType(Math.min(left.min,root.val), Math.max( right.max, root.val), true);
            else 
                return new ResultType(Integer.MIN_VALUE, Integer.MAX_VALUE, false); 
        }
        return new ResultType(Integer.MIN_VALUE, Integer.MAX_VALUE, false);
    }
}