//Given a binary tree, find its maximum depth.

//The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public int maxDepth(TreeNode root) {
		if(root==null) return 0;
		Queue<TreeNode> queue = new LinkedList<>();
		int count=0;
	  	queue.offer(root);
	  	while(queue.size()!=0){
		  	int size = queue.size();
		  	while(size-->0){
			  	TreeNode node = queue.poll();
			  	if(node.left!=null) queue.offer(node.left);
			  	if(node.right!=null) queue.offer(node.right);
		  	}
		  	count++;
	  	}
	  	return count;
    }   
}