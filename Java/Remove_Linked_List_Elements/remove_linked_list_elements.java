//Remove all elements from a linked list of integers that have value val.

//Example
//Given: 1 --> 2 --> 6 --> 3 --> 4 --> 5 --> 6, val = 6
//Return: 1 --> 2 --> 3 --> 4 --> 5



/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode removeElements(ListNode head, int val) {
        ListNode start = new ListNode(0);
        start.next = head;
        ListNode slow = start;
        ListNode fast = start.next;
        while(fast!=null){
	        if(fast.val==val){
		        slow.next=slow.next.next;
	        }else{
	            slow=slow.next;
	        }
	        fast=fast.next;
        }
        return start.next;
    }
}

// A better solution(recursion)
public class Solution {
    public ListNode removeElements(ListNode head, int val) {
	    if(head==null){
		    return null;
	    }
	    head.next = removeElements(head.next,val);
	    return head.val==val?head.next:head;
    }
}