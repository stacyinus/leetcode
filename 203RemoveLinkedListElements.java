/*
203. Remove Linked List Elements
Remove all elements from a linked list of integers that have value val.

Example
Given: 1 --> 2 --> 6 --> 3 --> 4 --> 5 --> 6, val = 6
Return: 1 --> 2 --> 3 --> 4 --> 5

*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class 203RemoveLinkedListElements {
	//iterative
    public ListNode removeElements(ListNode head, int val) {
        ListNode tmp = head;
        while(tmp!=null&&tmp.next!=null){
        	if(tmp.next.val == val)
        		tmp.next = tmp.next.next;
        	else
        		 tmp = tmp.next;
        }
        if(head!=null && head.val == val)
        	head = head.next;
        return head;  
    }
    //recursive
    public ListNode removeElements1(ListNode head, int val) {
    	if(head ==null) return head;
    	head.next = removeElements(head.next,val);
		return head.val == val? head = head.next:head;
    }
	//iterative with fake head
    public ListNode removeElements2(ListNode head, int val) {
    	if(head ==null) return head;
    	ListNode fakeHead = new ListNode(0);
    	fakeHead.next = head;
    	ListNode tmp = fakeHead;
    	while(tmp!=null&&tmp.next!=null){
        	if(tmp.next.val == val)
        		tmp.next = tmp.next.next;
        	else
        		 tmp = tmp.next;
    	}
    	return fakeHead.next;
    }
}