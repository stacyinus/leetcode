/*
109. Convert Sorted List to Binary Search Tree

Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.

Subscribe to see which companies asked this question
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
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
	//inplace, fast and slow pointers.
    public TreeNode sortedListToBST(ListNode head) {
    	ListNode tail = null;
    	return sortedListToBST(head, tail);
    }
    public TreeNode sortedListToBST(ListNode head, ListNode tail) {
    	if(head == tail)
    		return null;
    	ListNode fast = head;
    	ListNode slow = head;
    	while(fast != tail && fast.next != tail){
    		fast = fast.next.next;
    		slow = slow.next;
    	}
    	TreeNode tHead = new TreeNode(slow.val);
    	tHead.left = sortedListToBST(head, slow);
    	tHead.right = sortedListToBST(slow.next, tail);
    	return tHead;
    }

	//convert to arraylist first
    public TreeNode sortedListToBST(ListNode head) {
        if(head == null)
        	return null;
        ArrayList<Integer> list = new ArrayList<Integer>();
        while(head != null){
        	list.add(head.val);
        	head = head.next;
        }
    	return construct(list, 0, list.size() - 1);
    }
    public TreeNode construct(ArrayList<Integer> list, int s, int e){
    	if(s > e)
    		return null;
    	int h = s + (e-s)/2; // index of head;
    	TreeNode head = new TreeNode(list.get(h));
    	head.left = construct( list, 0, h - 1 );
    	head.right = construct( list, h + 1, e ); 
    	return head;
    }
}