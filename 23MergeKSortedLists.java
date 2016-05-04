/*
23. Merge k Sorted Lists

Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0)
        	return null;
        return mergeKLists(lists, 0 , lists.length - 1);
    }
    private ListNode mergeKLists(ListNode[] lists, int s, int e){
		if(s == e)
			return lists[s];
		int m = s + (e - s)/2;
		ListNode left = mergeKLists(lists, s, m);
		ListNode right = mergeKLists(lists, m + 1, e);
		return mergeTwoLists(left,right);
    }

    private ListNode mergeTwoLists(ListNode list1,ListNode list2){
    	if(list1 == null)
    		return list2;
    	if(list2 == null)
    		return list1;
    	ListNode head = new ListNode(-1);//this is a dummy node
    	ListNode tmp = head;
    	while( list1 != null || list2 != null ){
    		if(list1 == null){
    			tmp.next = list2;
    			break;
    		}
    		if(list2 == null){
    			tmp.next = list1;
    			break;
    		}
    		if(list1.val < list2.val){
    			tmp.next = list1;
    			list1 = list1.next;
    		}
    		else{
				tmp.next = list2;
    			list2 = list2.next;    			
    		}
    		tmp = tmp.next;
    	}
    	return head.next;
    }
}