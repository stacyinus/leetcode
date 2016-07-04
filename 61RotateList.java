/*
61. Rotate List

Given a list, rotate the list to the right by k places, where k is non-negative.

For example:
Given 1->2->3->4->5->NULL and k = 2,
return 4->5->1->2->3->NULL.
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
	思路：题目可以转化成，将linkedlist变成将倒数第K个Node之后的list挪到linkedlist的头部。
		be careful of conner cases: when k >= the number of the list;
		1.  find kth to the last node
		2.  rotate. 
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
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) return head;
        ListNode tmp = head;
        int count = 0;
        while ( k >= 0 ) {
        	if (tmp == null) {
        		k %= count;
        		tmp = head;
        		count = 0;
        		if (k == 0) return head;
        	}
        	tmp = tmp.next;
        	k --;
        	count++;
        }
        ListNode tmpHead = head;
        while (tmp != null) {
            tmpHead = tmpHead.next;
            tmp = tmp.next;
        }
        ListNode newHead = tmpHead.next;
        ListNode cur = newHead;
        tmpHead.next = null;
        while (cur.next != null) {
       		cur = cur.next;
       	}
       	cur.next = head;
       	return newHead;
    }
}