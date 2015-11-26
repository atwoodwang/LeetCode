//Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

//For example:
//Given binary tree {3,9,20,#,#,15,7},
//    3
//   / \
//  9  20
//    /  \
//   15   7
//return its level order traversal as:
//[
//  [3],
//  [9,20],
//  [15,7]
//]



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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result= new LinkedList<List<Integer>>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();

		if (root == null){
			return result;
		}

        queue.offer(root);
		
        while(!queue.isEmpty()){
	        List<Integer> list = new LinkedList<Integer>();
	        int s = queue.size();
	        for(int i=0;i<s;i++){
		        if(queue.peek().left!=null){
			        queue.offer(queue.peek().left);
		        }
		        if(queue.peek().right!=null){
			        queue.offer(queue.peek().right);
		        }

		        list.add(queue.poll().val);
	        }
	        result.add(list);
        }
        return result;
    }
}