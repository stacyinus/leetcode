/*
270	Closest Binary Search Tree Value

Given a non-empty binary search tree and a target value, find the value in the BST that is 
closest to the target.
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
public class 270ClosestBSTValue {
    //iterative
    public int closestValue(TreeNode root, double target) {
        if(root == null) 
            return Integer.MAX_VALUE;
        int val = root.val;
        while(root!=null){
            if(root.val == target)
                return root.val;
            if(root.val > target){
                root = root.left;
            }
            else{
                root = root.right;
            }
            val = Math.abs(val - target) > Math.abs(root.val - target)? root.val: val;
        }
        return val;
    }
    //recursive
    public int closestValue(TreeNode root, double target) {
        if(root == null) return Integer.MAX_VALUE;
        TreeNode kid = root.val>target?root.left:root.right;
        if(kid == null) return root.val;
        int val = closestValue(kid, target);
        return Math.abs(root.val- target)>Math.abs(val- target)?val:root.val;
    }
} 