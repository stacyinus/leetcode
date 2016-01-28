/*
Reverse a singly linked list.
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

public class 206ReverseLinkedList {
	 //iterative
        public ListNode reverseList(ListNode head) {
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
    
    //recursive
    public ListNode reverseList1(ListNode head) {
        if(head ==null||head.next==null)
            return head;
        ListNode cur =  head.next;
        ListNode newHead = reverseList(cur);
        cur.next = head;
        head.next=null;
        return newHead;
        
    }
}
