/*
102. Binary Tree Level Order Traversal

Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

For example:
Given binary tree {3,9,20,#,#,15,7},
    3
   / \
  9  20
    /  \
   15   7
return its level order traversal as:
[
  [3],
  [9,20],
  [15,7]
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
public class 102BTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder1(TreeNode root) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        if(root==null)
        	return list;
        List<List<Integer>> l = levelOrder(root.left);
        List<List<Integer>> r = levelOrder(root.right);
        int i=0;
        for(;i<r.size();i++){
        	if(i<l.size())
        		l.get(i).addAll(r.get(i));
        	else
        		l.add(r.get(i));
        }
        ArrayList<Integer> top = new ArrayList<Integer>();
        top.add(root.val);
        l.add(0,top);
        return l;
    }
    //iterative
    public List<List<Integer>> levelOrder(TreeNode root) {
    	List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(root==null)
        	return result;
        ArrayList<TreeNode> list =  new ArrayList<TreeNode>();
        ArrayList<Integer> currentLevel = new ArrayList<Integer>();
        list.add(root);
        list.add(null);//null act as a sign of level change
        for(int i = 0;i<list.size()-1;i++){//notice here use list.size()-1 as the bound to eliminate an empty list to be added.
        	if(list.get(i)==null){
        		result.add(currentLevel);
        		currentLevel = new ArrayList<Integer>();
        	}
        	else {
        		TreeNode n = list.get(i);
        		if(n.left!=null)
        			list.add(n.left);
        		if(n.right!=null)
        			list.add(n.right);
        		if(list.get(i+1)==null)
        			list.add(null);
        		currentLevel.add(n.val);
        	}
        	 	
        }
        return result; 
    }

}