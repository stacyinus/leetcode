/*
148. Sort List

Sort a linked list in O(n log n) time using constant space complexity.
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
	// 3 way quick sort
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) 
            return head;
        ListNode pivot = head;
        ListNode cur = head.next;
        ListNode dummy1 = new ListNode(0);//smaller than pivot
        ListNode tmp1 = dummy1;
        ListNode dummy2 = new ListNode(0);//greater than pivot
        ListNode tmp2 = dummy2;
        
        while(cur != null) {
            if (cur.val < pivot.val) {
                tmp1.next = cur;
                tmp1 = tmp1.next;
            }
            else if (cur.val > pivot.val) {
                tmp2.next = cur;
                tmp2 = tmp2.next;
            }
            else {
                head.next = cur;
                head = head.next;
            }
            cur = cur.next;
        }
        tmp1.next = null;
        tmp2.next = null;
        head.next = null;
        dummy1.next = sortList(dummy1.next);//smaller than pivot
        dummy2.next = sortList(dummy2.next);//greater than or equal to pivot
        tmp1 = dummy1;
        while (tmp1.next != null ) {
            tmp1 = tmp1.next;
        }
        tmp1.next = pivot;
        head.next = dummy2.next;
        return dummy1.next;
    }

    //merge sort
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) 
            return head;
        ListNode slow = head;
        ListNode fast = head.next.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode head2 = slow.next;
        slow.next = null;
        ListNode list1 = sortList(head);
        ListNode list2 = sortList(head2);
        return merge(list1, list2);
    }
    private ListNode merge(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                cur.next = list1;
                list1 = list1.next;
            }
            else {
                cur.next = list2;
                list2 = list2.next;
            }
            cur = cur.next;
        }
        if (list1 != null) {
            cur.next = list1;
        }
        if (list2 != null) {
            cur.next = list2;
        }
        return dummy.next;
    }    
}