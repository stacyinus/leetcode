/*
113. Path Sum II 
Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.

For example:
Given the below binary tree and sum = 22,
              5				
             / \
            4   8			
           /   / \
          11  13  4
         /  \    / \
        7    2  5   1
return
[
   [5,4,11,2],
   [5,8,4,5]
]
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

/*
	Divide and conquer:	Tree traversal , but need to keep the traversal path , so we need to pass in an 
						list, before going to either one of the children, make a copy of the list and add the current node val;
						when reach the leaf, check if sum == current node val, if yes, then add the path to the final result.
	Time complexity: O(n)	
*/
public class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (root == null) {
        	return result;
        }
        helper(result, new ArrayList<Integer>(), root, sum);
        return result;
    }
    public void helper(List<List<Integer>> result, List<Integer> path, TreeNode root, int sum ) {
    	if (root.left == null && root.right  == null && sum == root.val) { 
    		path.add(root.val);
    		result.add(path);
    		return;
    	}
    	if (root.left != null) {
    		List<Integer> tmp = new ArrayList<Integer>(path);
    		tmp.add(root.val);
    		helper(result, tmp, root.left, sum - root.val);
    	}
    	if (root.right != null) {
    		List<Integer> tmp = new ArrayList<Integer>(path);
    		tmp.add(root.val);
    		helper(result, tmp, root.right, sum - root.val);
    	}
    }
}