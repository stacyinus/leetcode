/*
92. Reverse Linked List 

Reverse a linked list from position m to n. Do it in-place and in one-pass.

For example:
Given 1->2->3->4->5->NULL, m = 2 and n = 4,

return 1->4->3->2->5->NULL.

Note:
Given m, n satisfy the following condition:
1 ≤ m ≤ n ≤ length of list.
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
	1->2->3->4->5->NULL
	2->1 
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
	//iterative
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(m == n)
    		return head;
        int count = 1;
        ListNode tmp = head;
        ListNode preHead = null;
        while ( count < m ) {
        	preHead = tmp;
        	tmp = tmp.next;
        	count++;
        }
        count = n - m;
        ListNode start = tmp;
        ListNode cur = tmp.next;
        ListNode next = cur.next;
        while (count > 0 && cur != null && next != null) { 
        	cur.next = tmp;
        	tmp = cur;
        	cur = next;
        	next = next.next;
        	count--;
        }
        if (count > 0) {
        	cur.next = tmp;
        	tmp = cur;
        	cur = next;        	
        }
        if (preHead != null) {
        	preHead.next = tmp;
        }
        start.next = cur;
        return preHead == null ? tmp : head;
    }

}