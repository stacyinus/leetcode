/*
24. Swap Nodes in Pairs 

Given a linked list, swap every two adjacent nodes and return its head.

For example,
Given 1->2->3->4, you should return the list as 2->1->4->3.

Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed.
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode swapPairs(ListNode head) {
        if(head==null||head.next==null)
        	return head;
        ListNode newHead = head.next;
        ListNode next = newHead.next;
        newHead.next=head;
        head.next = swapPairs(next);
        return newHead;
    }
     public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy, cur = head, next = head.next;
        while (next != null) {
            ListNode nextCur = next.next;
            pre.next = next;
            next.next = cur;
            cur.next = nextCur;
            pre = cur;
            cur = nextCur;
            next = cur == null ? null : nextCur.next;
        }
        return dummy.next;
    }   
}