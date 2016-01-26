/*
You are given two linked lists representing two non-negative numbers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
*/
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class 2AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1==null||l2==null)
        	return (l1==null?l2:l1);
        boolean carry = false;
        ListNode head = null; 
        ListNode preNode = null; 
        while(l1!=null || l2!=null||carry){
        	int val = 0;
        	if(l1!=null){
        		val = l1.val;
        		l1 = l1.next;
        	}
	        if(l2!=null){
	        	val += l2.val;
	        	l2 = l2.next;
	        }
        	if(carry){
        		val += 1;
        		carry = false;
        	}
        	if(val>=10){
        		carry = true;
        		val -= 10; 
        	}
            ListNode curNode = new ListNode(val);
        	if(preNode == null){
        		head  = curNode;
        		preNode = curNode;
        	}	
        	else
        		preNode.next = curNode;
        	preNode = curNode;
        }
        return head;
    }
}