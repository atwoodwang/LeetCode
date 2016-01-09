//Given a binary tree, find its minimum depth.

//The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

//Recursion
public class Solution {
    public int minDepth(TreeNode root) {
        if(root==null){
	        return 0;
	    }

	    int left = minDepth(root.left);
	    int right = minDepth(root.right);
	    return (left!=0&&right!=0)?Math.min(left,right)+1:Math.max(left,right)+1;
    }
}

//Iteration
public class Solution {
    public int minDepth(TreeNode root) {
	    if(root==null) return 0;
	    Queue<TreeNode> queue = new LinkedList<>();
	    queue.offer(root);
		int count = 1;
	    while(!queue.isEmpty()){
		    int size = queue.size();
		    while(size-->0){
			    TreeNode node = queue.poll();
			    if(node.left!=null) queue.offer(node.left);
			    if(node.right!=null) queue.offer(node.right);
			    if(node.left==null&&node.right==null) return count;
		    }
		    count++;
	    }
	    return count;
    }
}