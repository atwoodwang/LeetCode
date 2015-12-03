//Reverse a singly linked list.


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null){
            return null;
        }

		ListNode node = head;
		ListNode nodenext = head.next;
		head.next = null;
		while(nodenext!=null){
			ListNode temp = nodenext.next;
			nodenext.next = node;
			node = nodenext;
			nodenext=temp;
		}

		return node;
    }
}

//A better Solution
public class Solution {
    public ListNode reverseList(ListNode head) {
       	ListNode newHead = null;
       	while(head!=null){
	       	ListNode temp = head.next;
	       	head.next=newHead;
	       	newHead=head;
			head=temp;
       	}
       	return newHead;
    }
}