//Given a singly linked list, determine if it is a palindrome.


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public boolean isPalindrome(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        ListNode temp = head;
        while(temp!=null){
	        stack.push(temp);
	        temp=temp.next;
        }
        int size = stack.size();
        for(int i=1;i<=size/2;i++){
	        ListNode tail = stack.pop();
	        if(tail.val!=head.val){
		        return false;
	        }
	        head=head.next;
        }
        return true;
    }
}
