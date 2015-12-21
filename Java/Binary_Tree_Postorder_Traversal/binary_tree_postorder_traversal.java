//Given a binary tree, return the postorder traversal of its nodes' values.

//For example:
//Given binary tree {1,#,2,3},
//   1
//    \
//     2
//    /
//   3
//return [3,2,1].


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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new LinkedList<>();
       	traversal(root,result);
       	return result;
    }

    public void traversal(TreeNode node,List<Integer> result){
	    if(node==null) return;
	    traversal(node.left,result);
	    traversal(node.right,result);
	    result.add(node.val);
    }
}

//Iteration
public class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        if(root==null){
	        return result;
        }
        stack.push(root);
        while(!stack.empty()){
	        TreeNode node = stack.pop();
	        result.add(0,node.val);
	        if(node.left!=null){
		        stack.push(node.left);
	        }
	        if(node.right!=null){
		        stack.push(node.right);
	        }
        }
		return result;
    }
}