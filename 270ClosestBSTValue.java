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
        int diff = Integer.MAX_VALUE;
        int value = 0;
        while(root!=null){
            if(root.val == target)
                return target;
            int tmpDiff = Math.abs(target-root.val);
            if(diff>tmpDiff){
                diff = tmpDiff;
                value = root.val;
            }
            root = (root.val>target)?root = root.left:root = root.right;
        }
        return value;
    }
    //recursive
    public int closestValue(TreeNode root, double target) {
        if(root.val == target) return target;
        TreeNode kid = root.val > target? root.left: root.right);
        if(kid == null)
            return root.val;
        int closestVal = closetstValue(kid, target);
        return Math.abs(closestVal-target)<Math.abs(root.val-target)?closestVal:root.val;
    }
} 