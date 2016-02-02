/*
160. Intersection of Two Linked Lists

Write a program to find the node at which the intersection of two singly linked lists begins.


For example, the following two linked lists:

A:          a1 → a2
                   ↘
                     c1 → c2 → c3
                   ↗            
B:     b1 → b2 → b3
begin to intersect at node c1.


Notes:

If the two linked lists have no intersection at all, return null.
The linked lists must retain their original structure after the function returns.
You may assume there are no cycles anywhere in the entire linked structure.
Your code should preferably run in O(n) time and use only O(1) memory.
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class 160IntersectionOfTwoLinkedLists {
    //cleaner yet not really faster approach
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA==null||headB==null)
            return null;
        ListNode a = headA;
        ListNode b = headB;
        while(a!=b){
            a = a==null?headB:a.next;
            b = b==null?headA:b.next;
        }
        return a;
    }
    //This approach is kinda stupid, you can just append one list to another instead of append one to itself.
    public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
        if(headA==null||headB==null)
        	return null;
        ListNode tailA = headA;
        while(tailA.next!=null) //find the tail of list1
        	tailA = tailA.next;
        tailA.next = headA;	//make a loop for list1
        ListNode result = findLoopHead(headB);
        tailA.next =null;//set the list back to 
        return result;
    }
    private ListNode findLoopHead(ListNode head){
		ListNode tmp1 = head;//slow
        ListNode tmp2 = head;//fast
        while(tmp2!=null&&tmp2.next!=null){
        	tmp1 = tmp1.next;
        	tmp2 = tmp2.next.next;
        	if(tmp1==tmp2)
        		break;
        }
        if(tmp2==null||tmp2.next==null)//meaning there's no loop
        	return null;
     	tmp1=head;
     	while(tmp1!=tmp2){//tmp1 and tmp2 will meet at the beginning of the loop
     		tmp1=tmp1.next;
     		tmp2=tmp2.next;
     	}
     	return tmp2;
    }
}	