/*
99. Recover Binary Search Tree

Two elements of a binary search tree (BST) are swapped by mistake.

Recover the tree without changing its structure.

Note:
A solution using O(n) space is pretty straight forward. Could you devise a constant space solution?
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
	O(n) Solution: do an in order traversal ,  store the traversed node in order in a list. and find which ones to swap value.

	O(1) solution: 
            keep 2 global variables, prev and second, and a list to store wrong nodes. prev is used to track the traversal history, it is the last value that 
            traversed before root, so root > pre. eg.1,5,3,4,2,6, the 2 nodes that got swapped is 5 and 2, so when traversing 3, we found the first voilation 
            of root > pre, we add pre into the list; and when traversing 2, we found the seconde voilation of root > pre, now we add root into the list.
            however there is a special case, which is 1,3,2,4,5,6, when adjacent elements got swapped(in tree representation, it is child swapped with father/grand father.. ).
            in this case, after traversing the tree, there will only be 1 node in the list. hence, we need another gobal variable "second", to keep track of the root 
            after we first add something in to the list, because this "second" node could be one of the wrong nodes!!!
*/
public class Solution {
	// O(1)
    TreeNode prev = null;//keep track of the traversal history
    TreeNode second = null;//
    public void recoverTree(TreeNode root) {
    	List<TreeNode> wrongNodes = new ArrayList<TreeNode>();
    	findWrongNodes(root, wrongNodes);
    	if (wrongNodes.size() == 1) {
    	    wrongNodes.add(second);
    	}
    	if (wrongNodes.size() == 2) {
    		int tmp = wrongNodes.get(0).val;
	        wrongNodes.get(0).val = wrongNodes.get(1).val;
	        wrongNodes.get(1).val = tmp;
    	}
    }
    private void findWrongNodes(TreeNode root, List<TreeNode> wrongNodes) {
    	if (root == null) return;
    	findWrongNodes(root.left, wrongNodes);
    	if (prev == null) { // initialize prev
    		prev =  root;
    	}else if(root.val <= prev.val) {
    		if (wrongNodes.size() == 0) {
    		    wrongNodes.add(prev);
    		    second = root;
    		}
    		else {
    		    wrongNodes.add(root);
    		}
    	}
    	prev = root;
    	findWrongNodes(root.right, wrongNodes);
    }

	// O(n)
    public void recoverTree(TreeNode root) {
        List<TreeNode> list = new ArrayList<TreeNode>();
        inOrderTraversal(root, list);
        TreeNode n1 = null, n2 = null;
        for (int i = 0; i < list.size(); i++) {
        	if (( i == 0 || list.get(i).val > list.get(i - 1).val ) && (i == list.size() - 1 || list.get(i).val < list.get(i + 1).val)) continue;
        	if (n1 == null) n1 = list.get(i);
        	else n2 = list.get(i);
        }
        if (n1 != null && n2 != null) {//swap val
        	int tmp = n2.val;
	        n2.val = n1.val;
	        n1.val = tmp;
        }
    }

    private void inOrderTraversal(TreeNode root, List<TreeNode> list) {
    	if (root == null) return;
    	inOrderTraversal(root.left, list);
    	list.add(root);
    	inOrderTraversal(root.right, list);
    }
}