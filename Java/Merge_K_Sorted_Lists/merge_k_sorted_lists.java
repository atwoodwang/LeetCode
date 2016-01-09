/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */


//#1: Divide and Conquer O(NlogK) time. O(logK) space. N-total nodes, K-the length of lists.
public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
	    if(lists==null||lists.length==0) return null;
	    int n = lists.length;
	    if(n==1) return lists[0];
	    if(n==2) return mergeTwoLists(lists[0],lists[1]);
	    return mergeTwoLists(mergeKLists(Arrays.copyOfRange(lists,0,n/2)),mergeKLists(Arrays.copyOfRange(lists,n/2,n)));
    }

    public ListNode mergeTwoLists(ListNode a,ListNode b){
	    if(a==null) return b;
	    if(b==null) return a;

	    ListNode dummy = new ListNode(0);
	    ListNode pointer = dummy;
	    while(a!=null&&b!=null){
		    if(a.val<b.val){
			    pointer.next = a;
			    a=a.next;
		    }else{
			    pointer.next = b;
			    b=b.next;
		    }
		    pointer=pointer.next;
	    }
	    pointer.next = a==null?b:a;
	    return dummy.next;
    }
}

//#2:　Use PriorityQueue O(NlogK) time. O(K) space.
public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists==null||lists.length==0) return null;
        PriorityQueue<ListNode> pq = new PriorityQueue<>(lists.length,new Comparator<ListNode>(){
	        @Override
	        public int compare(ListNode a,ListNode b){
		        return a.val-b.val;
	        }
        });

        for(ListNode node:lists){
	        if(node!=null) pq.add(node);
        }

        ListNode dummy = new ListNode(0);
        ListNode pointer = dummy;
        while(!pq.isEmpty()){
	        pointer.next = pq.poll();
	        pointer = pointer.next;
	        if(pointer.next!=null) pq.add(pointer.next);
        }
        return dummy.next;        
    }
}

