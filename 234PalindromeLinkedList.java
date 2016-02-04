/*
234. Palindrome Linked List

Given a singly linked list, determine if it is a palindrome.

Follow up:
Could you do it in O(n) time and O(1) space?
*/
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class 234PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        
    }
    private ListNode reverse(ListNode head){
    	if(head==null||head.next==null) return head; 
    	ListNode tmp = head.next;
    	ListNode newHead = reverse(tmp);
    	tmp.next = head;
    	head.next = null;
    	return newHead;
    }
}