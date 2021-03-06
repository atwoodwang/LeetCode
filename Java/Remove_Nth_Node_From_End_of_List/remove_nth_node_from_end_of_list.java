//Given a linked list, remove the nth node from the end of list and return its head.

//For example,

//   Given linked list: 1->2->3->4->5, and n = 2.

//   After removing the second node from the end, the linked list becomes 1->2->3->5.
//Note:
//Given n will always be valid.
//Try to do this in one pass.


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
	    ListNode temp = new ListNode(head.val);
	    temp.next = head.next;
        List<ListNode> list = new LinkedList<>();
        while(temp!=null){
	        list.add(temp);
	        temp=temp.next;
	        if(list.size()>n+1){
		        list.remove(0);
	        }
        }
        if(list.size()==n){
	        head=head.next;
	        return head;
        }
        ListNode node = list.get(0);
        if(n==1){
	        node.next=null;
        }else{
	        node.next = node.next.next;
        }
        return head;
    }
}