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
	//O(n) time and O(n) space
	public boolean isPalindrome(ListNode head) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		ListNode cur = head;
		while(cur!=null){
			list.add(cur.val);
        	cur=cur.next;
        }
        int size = list.size();
        if(size==0||size==1)return true;
        for(int i=0;i<=(size-1)/2;i++)
        	if(!list.get(i).equals(list.get(size-1-i)))
        		return false;
        return true;
	}
	//O(n) time and O(1) space
    public boolean isPalindrome(ListNode head) {
        ListNode cur = head;
        int l = 0;
        while(cur!=null){
        	cur=cur.next;
        	l++;
        }
        int count = (l+1)/2;
        cur = head;
        while(count>0){
        	cur=cur.next;
        	count--;
        }
        ListNode rightHead = reverse(cur);
        cur = head;
        while(rightHead!=null){
        	if(rightHead.val!=cur.val)
        		return false;
        	rightHead=rightHead.next;
        	cur=cur.next;
        }
        return true;
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