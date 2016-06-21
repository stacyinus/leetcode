/*
147. Insertion Sort List 
Sort a linked list using insertion sort.
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
	insertion sort is to looping through the list , and keep the looped part sorted 
	by inserting the current value to it's proper position in the sorted list;

	1 4 3 2 0 -->  1 4 3 2 0 -->1 3 4 2 0 --> 1 2 3 4 0 --> 0 1 2 3 4

	Method: 2 pointers next to each other, if the second val is smaller than the first val, 
			loop from the begining to find where to insert the second val.
			Use a dummy node to simplify the code.
	Time Complexity O(n)
	Space O(1)
*/
public class Solution {
    public ListNode insertionSortList(ListNode head) {
        if(head == null || head.next == null)
            return head;
    	ListNode dummy = new ListNode(0);
    	dummy.next = head;
        ListNode slow = head;
        ListNode fast = head.next;
        while(fast != null){
        	if(fast.val < slow.val) {
        		ListNode newTmp = dummy;
        		while(newTmp.next.val < fast.val) {
        			newTmp = newTmp.next;
        		}
        		slow.next = slow.next.next;
        		ListNode tmp = newTmp.next;
        		newTmp.next = fast;
				fast.next = tmp;
				fast = slow.next;
 	       	}
 	       	else {
 	       	    fast = fast.next;
 	       	    slow = slow.next;
 	       	}
        }
        return dummy.next;
    }
}