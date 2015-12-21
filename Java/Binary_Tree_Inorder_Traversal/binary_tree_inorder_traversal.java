//Given a binary tree, return the inorder traversal of its nodes' values.

//For example:
//Given binary tree {1,#,2,3},
//   1
//    \
//     2
//    /
//   3
//return [1,3,2].

//Note: Recursive solution is trivial, could you do it iteratively?

//Recursion
public class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new LinkedList<>();
       	traversal(root,result);
       	return result;
    }

    public void traversal(TreeNode node,List<Integer> result){
	    if(node==null) return;
	    traversal(node.left,result);
	    result.add(node.val);
	    traversal(node.right,result);
    }
}

//Iteration
public class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
       	List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while(!stack.empty()||cur!=null){
	        while(cur!=null){
		        stack.push(cur);
		        cur=cur.left;
	        }
	        cur = stack.pop();
	        result.add(cur.val);
	        cur=cur.right;
        }
		return result;
    }
}