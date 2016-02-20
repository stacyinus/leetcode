/*
141. Linked List Cycle

Given a linked list, determine if it has a cycle in it.

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
public class 141LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        if(head == null) return false;
        ListNode tmp1 = head;//slow
        ListNode tmp2 = head.next;//fast
        while(tmp2!=null&&tmp2.next!=null){
        	if(tmp1==tmp2)
        		return true;
        	tmp1 = tmp1.next;
        	tmp2 = tmp2.next.next;
        }
        return false;
    }
}