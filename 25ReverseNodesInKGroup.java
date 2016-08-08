/*

25. Reverse Nodes in k-Group  

Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.

If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.

You may not alter the values in the nodes, only nodes itself may be changed.

Only constant memory is allowed.

For example,
Given this linked list: 1->2->3->4->5

For k = 2, you should return: 2->1->4->3->5

For k = 3, you should return: 3->2->1->4->5

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
    思路： 1）找到k个node 的 start 和 end， reverse sublist
          2）继续寻找下k个node
*/
public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k <= 1) return head;
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        cur.next = head;
        while (head != null) {
            ListNode end = head;
            int count = 1;
            while (count < k && end != null) {
                end = end.next;
                count++;
            }
            if (end == null) {
                cur.next = head;
                break;
            }
            else {
                ListNode nextHead = end.next;
                ListNode newHead = reverseLinkedList(head, end);
                cur.next = newHead;
                cur = head;
                head = nextHead;
            }
        }
        return dummy.next;
    }
    
    private ListNode reverseLinkedList(ListNode head, ListNode end) {
        if (head == end || head == null || head.next == null) return head;
        ListNode next = head.next;
        head.next = null;
        ListNode newHead = reverseLinkedList(next, end);
        next.next = head;
        return newHead;
    }
}