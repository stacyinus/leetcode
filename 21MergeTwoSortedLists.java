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
    //recursive is much cleaner
    public ListNode mergeTwoLists(ListNode l1, ListNode l2){
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        if(l1.val < l2.val){
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else{
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }
    //iterative using a dummy node
    public ListNode mergeTwoLists(ListNode n1, ListNode n2) {
        ListNode head = new ListNode(0);
        ListNode cur = head;
        while(cur != null){
            if(n1 == null){
                cur.next = n2;
                break;
            }
            else if(n2 == null){
                cur.next = n1;
                break;
            }
            if(n1.val < n2.val){
                cur.next = n1;
                n1 = n1.next;
            }
            else{
                cur.next = n2;
                n2 = n2.next;
            }
            cur = cur.next;
        }
        return head.next;
    }
    //iterative
    public ListNode mergeTwoLists(ListNode n1, ListNode n2) {
    	if(n1==null)
    		return n2;
    	if(n2==null)
    		return n1;
    	ListNode head = null;
    	if(n1.val<n2.val){
    		head = n1;
    		n1 = n1.next;
    	}
    	else{
    		head = n2;
    		n2 = n2.next;
    	}
    	ListNode cur = head;
    	while(n1!=null&&n2!=null){
    		if(n1.val<n2.val){
    			cur.next = n1;
    			n1=n1.next;
    		}
    		else{
    			cur.next=n2;
    			n2=n2.next;
    		}
    		cur = cur.next;
    	}
    	if(n1!=null)
    		cur.next=n1;
    	else if(n2!=null)
    		cur.next=n2;
    	return head;
    }
}    