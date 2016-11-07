/*
285.Inorder Successor in BST

Given a binary search tree and a node in it, find the in-order successor of that node in the BST.

Note: If the given node has no in-order successor in the tree, return null.

*/
// Time O(h), Space O(1)
public Node getSuccessor(Node root, Node p) {
	Node suc = null;
	while (root != null) {
		if (root.val <= p.val) {
			root = root.right;
		}
		else {
			suc = root;
			root = root.left;
		}
	}
	return suc;
}
