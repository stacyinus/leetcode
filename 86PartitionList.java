/*
86. Partition List 

Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.

You should preserve the original relative order of the nodes in each of the two partitions.

For example,
Given 1->4->3->2->5->2 and x = 3,
return 1->2->2->4->3->5.
*/
/*
	dummy->	1->4->3->2->5->2  p1  point to the last smaller than x
					  p is current. 
					  all start from begining.
						if p < x, p1.next = x, p1 = p1.next  p1.next = p2
			54312			
	1: 1->4->3->2->5->2 p1 = 1, p2 = 3 
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
	Method 1(better): divide the list into 2 lists, one holds the nodes smaller than x, the other holds the 
				nodes larger than x, and combine them.
				create 2 dummy nodes, small and large, loop through the list, if node is smaller than 
				x, then put it into the small list, else put it into the larger list. combine 2 lists 
				after the loop ends, and return the smaller head;
	Method 2:  pointer p1 point to the last node (from beginning) that is smaller than x, p is the moving pointer
				for every p that is smaller than x, move to p1.next . Here you need to keep another pointer p2 to track
				the node prior to current p. 
				create 1 dummy node prior to head, p1 and p both start from dummy, and move forward until meet the first
				  node, whose next is greater than x. ( loop 1, this is just to find the start point)
				 now, p1 is pointing to the last node (from beginning) that is smaller than x. make p2 = p1, and p = p1.next
	Time complexity O(n)
	Space complexity O(1)
*/
public class Solution {
	public ListNode partition(ListNode head, int x) {
        ListNode smallHead = new ListNode(0);
        ListNode largeHead = new ListNode(0);
        ListNode small = smallHead, large = largeHead;
        while ( head != null ) {
        	ListNode tmp = head.next;
        	if( head.val < x ) {
        		small.next = head;
        		small = small.next;
        	}
        	else {
        		large.next = head;
        		large = large.next;
        	}
        	head = tmp;
        }
        small.next = largeHead.next;
        large.next = null;
        return smallHead.next;
	}

    public ListNode partition(ListNode head, int x) {
        if ( head == null || head.next == null ) {
        	return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode p1 = dummy, p = dummy; //P1 point to the last smaller than x
        while(p1.next!= null && p1.next.val < x){
        	p1 = p1.next;
        	p = p.next;
        }
        ListNode p2 = p1; //p2 point to the node prior to p
        p = p.next;
        while ( p!= null  ) {
        	if ( p.val < x ) {
        		p2.next = p.next;
	        	ListNode tmp = p1.next;
	        	p1.next = p;
	        	p.next = tmp;     
	        	p1 = p1.next;
	        	p = p2.next;			
        	}
        	else {
        		p = p.next;
        		p2 = p2.next;
        	}
        }
        return dummy.next;
    }
}