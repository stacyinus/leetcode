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
    	TreeNode parent = root;
    	while(root!=null){
    		if(target==root.val)
    			return target;
    		parent = root;
    		if(target>root.val)
    			root=root.right;
    		else
    			root=root.left;
    	}
    	int v = parent.val;
    	//parent value is not necessary the closest, neet to check the biggest value of
    	//left tree of parent.
    	parent = parent.left;
    	if(parent==null) return v;
    	while(parent.right!=null)
    		parent=parent.right;
    	if(Math.abs(v-target)>Math.abs(parent.val-target))
    		return parent.val
    	return  v;
    }
} 