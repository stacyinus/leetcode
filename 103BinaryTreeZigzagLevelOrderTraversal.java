/*
103. Binary Tree Zigzag Level Order Traversal

Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).

For example:
Given binary tree {3,9,20,#,#,15,7},
    3
   / \
  9  20
    /  \
   15   7
return its zigzag level order traversal as:
[
  [3],
  [20,9],
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
public class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> lists= new ArrayList<List<Integer>>();
        if(root == null)
        	return lists;
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while(!queue.isEmpty()){
        	int size = queue.size();
        	List<Integer> list = new ArrayList<Integer>();
        	for(int i = 0; i < size; i++){
        		TreeNode tmp = queue.poll();
        		list.add(tmp.val);   
        		if(tmp.left!=null)
	        		queue.add(tmp.left);
	        	if(tmp.right!=null)
	        		queue.add(tmp.right);
        	}
        	if(lists.size()%2 != 0)
        		Collections.reverse(list);
        	lists.add(list);
        }
        return lists;
    }
}