/*
142. Linked List Cycle II

Given a linked list, return the node where the cycle begins. If there is no cycle, return null.

Note: Do not modify the linked list.

Follow up:
Can you solve it without using extra space?
*/
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if( head == null )
        	return null;
        ListNode fast = head;
        ListNode slow = head;
        boolean flag = false;
        while(fast != null && fast.next != null){
        	if(flag && fast == slow)
        		break;
        	fast = fast.next.next;
        	slow = slow.next;
        	flag = true;
        }
        if(fast == null || fast.next == null)
        	return null;
        fast = head;
        while(fast!= slow){
        	fast = fast.next;
        	slow = slow.next;
        }
        return fast;
    }
}