/*
297. Serialize and Deserialize Binary Tree 

Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or another computer environment.

Design an algorithm to serialize and deserialize a binary tree. There is no restriction on how your serialization/deserialization algorithm should work. You just need to ensure that a binary tree can be serialized to a string and this string can be deserialized to the original tree structure.

For example, you may serialize the following tree

    1
   / \
  2   3
     / \
    4   5
as "[1,2,3,null,null,4,5]", just the same as how LeetCode OJ serializes a binary tree. You do not necessarily need to follow this format, so please be creative and come up with different approaches yourself.
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
	level order traversal:
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
public class Codec {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null)
            return "[]";
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean findValue = false;
            String tmpString = "";
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                if (cur == null) {
                    tmpString += "null,";
                }
                else {
                    findValue = true;
                    queue.add(cur.left);
                    queue.add(cur.right);                    
                }
                if (findValue && tmpString.length() > 0) {
                    sb.append(tmpString);
                    tmpString = "";
                }
                if (cur != null) {
                    sb.append(Integer.toString(cur.val)).append(",");
                }
            }
        }
        return sb.toString().substring(0, sb.length() - 1) + "]";
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.length() <= 2) {
            return null;
        }
        data = data.substring(1, data.length() - 1);
        String[] array = data.split(",");
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        TreeNode root = new TreeNode(Integer.valueOf(array[0]));
        queue.add(root);
        int i = 1;
        //System.out.println("array = "+ Arrays.toString(array));
        while (i < array.length && !queue.isEmpty()) {
            TreeNode cur = queue.poll();
            //System.out.println("array[" + i + "] = "+array[i]);
            TreeNode left = array[i].equals("null") ? null : new TreeNode(Integer.valueOf(array[i]));
            TreeNode right = (i + 1 >= array.length || array[i+1].equals("null")) ? null : new TreeNode(Integer.valueOf(array[i+1]));
            cur.left = left;
            cur.right = right;
            if (left != null) {
                queue.add(left);    
            }
            if (right != null) {
                queue.add(right);
            }
            i += 2;
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));