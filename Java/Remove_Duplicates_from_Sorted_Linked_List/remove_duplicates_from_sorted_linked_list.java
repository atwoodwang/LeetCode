//Given a sorted linked list, delete all duplicates such that each element appear only once.

//For example,
//Given 1->1->2, return 1->2.
//Given 1->1->2->3->3, return 1->2->3.

//This solution includes test cases;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(1);
        ListNode node3 = new ListNode(1);
        ListNode node4 = new ListNode(2);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = null;
        solution.deleteDuplicates(node1);
        System.out.println(node1.val);

    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode deleteDuplicates(ListNode head) {
	    ListNode node = head;
	    ListNode temp = node;
	    while(node!=null){
		    while(temp!=null&&node.val==temp.val) temp=temp.next;
		    node.next = temp;
		    node = temp;
	    }
	    return head;
    }
}
