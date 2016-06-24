/*
95. Unique Binary Search Trees II 

Given n, generate all structurally unique BST's (binary search trees) that store values 1...n.

For example,
Given n = 3, your program should return all 5 unique BST's shown below.

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3

OJ's Binary Tree Serialization:
The serialization of a binary tree follows a level order traversal, where '#' signifies a path terminator where no node exists below.

Here's an example:
   1
  / \
 2   3
    /
   4
    \
     5
The above binary tree is serialized as "{1,2,3,#,#,4,#,#,5}".
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
    Take an exmaple.  
    If n = 5, the result will be composed of :
    1 is the root,left child is null, 2,3,4,5 compose the right sub tree.
    2 is the root,left child is 1, and 3,4,5 compose the right sub tree.
    3 is the root, 1,2 compose the left sub tree, 4,5 compose the right sub tree.
    4 is the root, 1,2,3 compose the left sub tree, 5 is the right child.
    5 is the root, 1,2,3,4 compose the left sub tree, null is the right child.
    hence, we can right a function helper, that take in number s and e as the start and end number.
    the return value will be list of sub trees that can be formed, with number s to e.
*/
public class Solution {
    public List<TreeNode> generateTrees(int n) {   
        if (n <= 0) {
            return new ArrayList<TreeNode>();
        }
        return helper(1, n);
    }
    public List<TreeNode> helper(int s, int e) {
        if (s > e) {
            List<TreeNode> list = new ArrayList<TreeNode>();
            list.add(null);
            return list;
        }
        if (s == e) {
            List<TreeNode> list = new ArrayList<TreeNode>();
            list.add(new TreeNode(s));
            return list;
        }
        List<TreeNode> result = new ArrayList<TreeNode>();
        for (int i = s; i <= e; i ++)  {
            List<TreeNode> leftNodes = helper(s, i - 1); 
            List<TreeNode> rightNodes = helper(i + 1, e);
            for (TreeNode left: leftNodes) {
                for( TreeNode right : rightNodes ) {
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    result.add(root);
                }
            }           
        }
        return result;
    }

}