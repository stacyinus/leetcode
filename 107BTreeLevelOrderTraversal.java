/*
107. Binary Tree Level Order Traversal II

Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).

For example:
Given binary tree {3,9,20,#,#,15,7},
    3
   / \
  9  20
    /  \
   15   7
return its bottom-up level order traversal as:
[
  [15,7],
  [9,20],
  [3]
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
public class 107BTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        if(root == null)
            return lists;
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while(!queue.isEmpty()){
            List<Integer> list = new ArrayList<Integer>();
            int size = queue.size();
            for(int i = 0; i<size; i++){
                TreeNode node = queue.poll();
                list.add(node.val);
                if( node.left != null )
                    queue.add(node.left);
                if( node.right != null )
                    queue.add(node.right);
            }
            lists.add( 0, list );
        }
        return lists;        
    }

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if(root ==null)
        	return new ArrayList<List<Integer>>();
        ArrayList<Integer> top = new ArrayList<Integer>();
        top.add(root.val);
        List<List<Integer>> l = levelOrderBottom(root.left);
        List<List<Integer>> r = levelOrderBottom(root.right);
        List<List<Integer>> result = merge(l,r);
        result.add(top);
        return result;
    }

    private List<List<Integer>> merge(List<List<Integer>> l,  List<List<Integer>> r){
    	if(l.isEmpty())
    		return r;
    	else if (r.isEmpty())
    		return l;
    	int i = l.size()-1;
    	int j = r.size()-1;
    	while(i>=0&&j>=0)
    		l.get(i--).addAll(r.get(j--));
    	if(j>=0){
    		List<List<Integer>> result = new ArrayList<List<Integer>>();
    		for(int k = 0;k<=j;k++)
	    		result.add(r.get(k));
	    	result.addAll(l);
	    	l=result;
    	}
    	return l;
    }
}