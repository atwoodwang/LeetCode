/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */

//O(n) time O(1) space
public class Solution {
    public void connect(TreeLinkNode root) {
	    while(root!=null){
		    TreeLinkNode cur = root;
		    while(cur!=null){
			    if(cur.left!=null) cur.left.next=cur.right;
			    if(cur.right!=null&&cur.next!=null) cur.right.next=cur.next.left;
			    cur=cur.next;
		    }
		    root=root.left;
	    }
    }
}




//O(n) time O(n) space
public class Solution {
    public void connect(TreeLinkNode root) {
        Queue<TreeLinkNode> queue = new LinkedList<>();
        if(root==null) return;
        queue.offer(root);
        while(queue.size()!=0){
            int i = queue.size();
            TreeLinkNode pre = null;
            while(i-->0){
                TreeLinkNode node = queue.poll();
                node.next = pre;
                pre = node;
                if(node.right!=null) queue.offer(node.right);
                if(node.left!=null) queue.offer(node.left);
            }
        }
    }
}