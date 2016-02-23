/*
116. Populating Next Right Pointers in Each Node
Given a binary tree

    struct TreeLinkNode {
      TreeLinkNode *left;
      TreeLinkNode *right;
      TreeLinkNode *next;
    }
Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.

Initially, all next pointers are set to NULL.

Note:

You may only use constant extra space.
You may assume that it is a perfect binary tree (ie, all leaves are at the same level, and every parent has two children).
For example,
Given the following perfect binary tree,
         1
       /  \
      2    3
     / \  / \
    4  5  6  7
After calling your function, the tree should look like:
         1 -> NULL
       /  \
      2 -> 3 -> NULL
     / \  / \
    4->5->6->7 -> NULL
*/

/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
	//BFS
    public void connect(TreeLinkNode root) {
    	if(root==null)
    		return;
    	ArrayList<TreeLinkNode> queue = new ArrayList<TreeLinkNode>();
    	queue.add(root);
    	queue.add(null);
    	TreeLinkNode current=null;
    	TreeLinkNode last=null; 
    	int index = 0;
    	while(index<queue.size()){
    		current = queue.get(index);
    		if(last!=null)
    			last.next=current;
    		if(current!=null){
    			if(current.left!=null)
	    			queue.add(current.left);
    			if(current.right!=null)
	    			queue.add(current.right);
    		}else if(current==null&&index<queue.size()-1)
    			queue.add(null);
    		last = current;
    		index++;
    	}
    }
}