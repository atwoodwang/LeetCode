//Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.

//For example:
//Given the following binary tree,
//   1            <---
// /   \
//2     3         <---
// \     \
//  5     4       <---
//You should return [1, 3, 4].


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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        rightView(root,result,0);
        return result;
    }

    public void rightView(TreeNode node,List<Integer> result,int currDepth){
	    if(node==null){
		    return;
	    }

	    if(currDepth==result.size()){
		    result.add(node.val);
	    }
	    rightView(node.right,result,currDepth+1);
	    rightView(node.left,result,currDepth+1);
    }   
}