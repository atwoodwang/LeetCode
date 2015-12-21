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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new LinkedList<>();
       	traversal(root,result);
       	return result;
    }

    public void traversal(TreeNode node,List<Integer> result){
	    if(node==null) return;
	    result.add(node.val);
	    traversal(node.left,result);
	    traversal(node.right,result);
    }
}


//Iteration
public class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        if(root==null){
	        return result;
        }
        stack.push(root);
        while(!stack.empty()){
	        TreeNode node = stack.pop();
	        result.add(node.val);
	        if(node.right!=null){
		        stack.push(node.right);
	        }
	        if(node.left!=null){
		        stack.push(node.left);
	        }
        }
		return result;
    }
}