/*
101. Symmetric Tree

Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

For example, this binary tree is symmetric:

    1
   / \
  2   2
 / \ / \
3  4 4  3
But the following is not:
    1
   / \
  2   2
   \   \
   3    3
Note:
Bonus points if you could solve it both recursively and iteratively.
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
public class 101SymmetricTree {
	//recursive
    public boolean isSymmetric(TreeNode root) {
        if(root==null||(root.left==null&&root.right==null))
        	return true;
        return isSym(root.left,root.right);
    }
    private boolean isSym(TreeNode left, TreeNode right){
    	if(left==null&&right==null)
    		return true;
    	if(left!=null&&right==null||right!=null&&left==null)
    		return false;
    	if(left.val!=right.val)
    		return false;
    	return isSym(left.left,right.right)&&isSym(left.right,right.left);
    }
    //iterative
    public boolean isSymmetric2(TreeNode root) {
        if(root==null||(root.left==null&&root.right==null))
            return true;
        Stack<TreeNode> l = new Stack<TreeNode>();
        Stack<TreeNode> r = new Stack<TreeNode>();
        l.push(root.left);
        r.push(root.right);
        TreeNode left, right = null;
        while(!r.empty()&&!l.empty()){
          left = l.pop();
          right = r.pop();
          if(left==null&&right==null)
            continue;
          else if(left!=null&&right!=null){
            if(left.val!=right.val)
              return false;
            l.push(left.left);
            r.push(right.right); 
            l.push(left.right);
            r.push(right.left); 
          }
          else 
            return false;
        }
        return l.empty()&&r.empty();
    }
}