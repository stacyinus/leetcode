/*
82. Remove Duplicates from Sorted List II

Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.

For example,
Given 1->2->3->3->4->4->5, return 1->2->5.
Given 1->1->1->2->3, return 2->3.
*/
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
/*
	dummy-1->1->1
	->2->3
	
*/
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null)
        	return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = dummy;
        boolean found = false;
        while (cur != null && cur.next != null) {
        	ListNode first = cur.next;
        	ListNode second = cur.next.next;
        	while (first != null && second != null && first.val == second.val) {
        		found = true;
        		first = first.next;
        		second = second.next;
        	}
        	if (found) {
        		cur.next = second;		
        		found = false;
        	}
        	else {
        		cur = cur.next;
        	}
        }
        return dummy.next;
    }
}