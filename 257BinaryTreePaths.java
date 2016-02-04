/*
257. Binary Tree Paths

Given a binary tree, return all root-to-leaf paths.

For example, given the following binary tree:

   1
 /   \
2     3
 \
  5
All root-to-leaf paths are:

["1->2->5", "1->3"]

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
public class 257BinaryTreePaths {
	//recursive
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new ArrayList<String>();
        if(root==null)
        	return list;
        if(root.left==null&&root.right==null){
        	list.add(Integer.toString(root.val));
        	return list;
        }
        if(root.left!=null) 
        	list.addAll(binaryTreePaths(root.left));
        if(root.right!=null)
        	list.addAll(binaryTreePaths(root.right));
        for(int i=0;i<list.size();i++)
        	list.set(i,root.val+"->"+list.get(i));
        return list;
    }
    //iterative?
    public List<String> binaryTreePaths(TreeNode root) {
    }
}