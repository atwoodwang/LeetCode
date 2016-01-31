//Given a binary tree, find the length of the longest consecutive sequence path.

//The path refers to any sequence of nodes from some starting node to any node in the tree along the parent-child connections. The longest consecutive path need to be from parent to child (cannot be the reverse).

//For example,
//   1
//    \
//     3
//    / \
//   2   4
//        \
//         5
//Longest consecutive sequence path is 3-4-5, so return 3.
//   2
//    \
//     3
//    / 
//   2    
//  / 
// 1
//Longest consecutive sequence path is 2-3,not3-2-1, so return 2.


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
	int mMax;
    public int longestConsecutive(TreeNode root) {
        if(root==null) return 0;
        helper(root,0,root.val);
        return mMax;
    }
    public void helper(TreeNode node,int cur,int pre){
	    if(node==null) return;
	    if(node.val==pre) cur++;
	    else cur = 1;
	    mMax = Math.max(cur,mMax);
	    helper(node.left,cur,node.val+1);
	    helper(node.right,cur,node.val+1);
    }
}