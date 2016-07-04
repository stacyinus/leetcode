/*
143. Reorder List

Given a singly linked list L: L0→L1→…→Ln-1→Ln,
reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…

You must do this in-place without altering the nodes' values.

For example,
Given {1,2,3,4}, reorder it to {1,4,2,3}.

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
	1,2,3,4,5 slow = 2
	1,5,2,4,3 
	1,2,3,4,5,6 slow = 3
	1. divide the list into 2 half, if there is a middle one, leave it in the first half.(fast and slow pointer.)
	2. rotate second list, and merge.

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
    public void reorderList(ListNode head) {
        if (head == null || head.next == null)
        	return;
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
        	slow = slow.next;
        	fast = fast.next.next;
        }
        ListNode list1 = head;
        ListNode list2 = slow.next;
        slow.next = null;
        list2 = revertList(list2);
        while (list2 != null && list1 != null) {
        	ListNode tmp = list1.next;
        	list1.next = list2;
        	list2 = list2.next;
        	list1.next.next = tmp;
        	list1 = list1.next.next;
        }
    }
	private ListNode revertList(ListNode head) {
        if(head ==null||head.next==null)
            return head;
        ListNode temp = head;
        ListNode pre = null;
        ListNode next = null;
        while(temp!=null){
            next = temp.next;
            temp.next=pre;
            pre=temp;
            temp = next;
        }
        return pre;
	}
}