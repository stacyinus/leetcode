/*
Given a linked list, remove the nth node from the end of list and return its head.
*/


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class 19RemoveNthNodeFromEnd {
    // second round
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode tmp = head;
        while (n > 0) {
            tmp = tmp.next;
            n--;
        }
        ListNode cur = dummy;
        while (tmp != null) {
            cur = cur.next;
            tmp = tmp.next;
        }
        cur.next = cur.next.next;
        return dummy.next;
    }
    // first round    
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int i = 0;
        ListNode pointer = head;
        ListNode temp = head;
        while(i++<n)
            temp = temp.next;
        if(temp == null ){    
            head = head.next;
            return head;
        }    
        while(temp.next!=null){
            temp = temp.next;
            pointer = pointer.next;
        }
        pointer.next = pointer.next.next;
        return head;
    }   
}