/*
117. Populating Next Right Pointers in Each Node II 
Follow up for problem "Populating Next Right Pointers in Each Node".

What if the given tree could be any binary tree? Would your previous solution still work?

Note:

You may only use constant extra space.
For example,
Given the following binary tree,
         1
       /  \
      2    3
     / \    \
    4   5    7
After calling your function, the tree should look like:
         1 -> NULL
       /  \
      2 -> 3 -> NULL
     / \    \
    4-> 5 -> 7 -> NULL
*/

/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
/*
	BFS. 
*/

public class Solution {
    public void connect(TreeLinkNode root) {
        if (root == null) return;
        Queue<TreeLinkNode> q = new LinkedList<TreeLinkNode>();
        q.add(root);
        while (!q.isEmpty()) {
        	int size = q.size();
        	TreeLinkNode pre = null;
        	for (int i = 0; i < size; i ++) {
        		TreeLinkNode cur = q.poll();
        		if (cur.left != null) q.add(cur.left);
        		if (cur.right != null) q.add(cur.right);
        		if (i != 0) pre.next = cur;
        		pre = cur;
        	}
        	pre.next = null;
        }
    }
}