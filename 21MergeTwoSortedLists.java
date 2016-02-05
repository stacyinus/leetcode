/*
21. Merge Two Sorted Lists
Merge two sorted linked lists and return it as a new list. 
The new list should be made by splicing together the nodes of the first two lists.
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class 21MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode n1, ListNode n2) {
    	if(n1==null)
    		return n2;
    	if(n2==null)
    		return n1;
    	ListNode temp = null;
    	ListNode head = null;
    	while(n1!=null&&n2!=null){
	    	if(n1.val>n2.val){
	    		if(head==null) head =n2;
	    		temp = n2.next;
	    		if(n2.next==null||n2.next.val>n1.val)
		    		n2.next = n1;
		    	n2=temp;
	    	}
	    	else{
	    		if(head==null) head =n1;
	    		temp = n1.next;
	    		if(n1.next==null||n1.next.val>n2.val)
	    			n1.next = n2;	
	    		n1 = temp;	
	    	}    		
    	}
    	return head;
    }
}    