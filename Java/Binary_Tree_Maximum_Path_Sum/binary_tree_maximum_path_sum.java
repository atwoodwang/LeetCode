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
	int max;
    public int maxPathSum(TreeNode root) {
        if(root==null) return 0;
        max = Integer.MIN_VALUE;
        maxSum(root);
        return max;
    }

    public int maxSum(TreeNode root){
	    if(root==null) return 0;
	    int left =  Math.max(maxSum(root.left),0);
	    int right = Math.max(maxSum(root.right),0);
	    max = Math.max(max,root.val+left+right);
	    return Math.max(left,right)+root.val;
    }
}