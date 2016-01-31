//Given a binary tree, return the vertical order traversal of its nodes' values. (ie, from top to bottom, column by column).

//If two nodes are in the same row and column, the order should be from left to right.

//Examples:
//Given binary tree [3,9,20,null,null,15,7],
//    3
//   / \
//  9  20
//    /  \
//   15   7
//return its vertical order traversal as:
//[
//  [9],
//  [3,15],
//  [20],
//  [7]
//]
//Given binary tree [3,9,20,4,5,2,7],
//    _3_
//   /   \
//  9    20
// / \   / \
//4   5 2   7
//return its vertical order traversal as:
//[
//  [4],
//  [9],
//  [3,5,2],
//  [20],
//  [7]
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
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root==null) return res;
        HashMap<Integer,List<Integer>> map = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<Integer> col = new LinkedList<>();
        int min=0,max=0;
        queue.offer(root);
        col.offer(0);
        while(!queue.isEmpty()){
	        TreeNode node = queue.poll();
	        int cur = col.poll();
	        if(map.containsKey(cur)){
		        map.get(cur).add(node.val);
	        }else{
		        List<Integer> list = new ArrayList<>();
		        list.add(node.val);
		        map.put(cur,list);
	        }

	        if(node.left!=null){
		        queue.offer(node.left);
		        col.offer(cur-1);
		        min = Math.min(min,cur-1);
	        }
	        if(node.right!=null){
		        queue.offer(node.right);
		        col.offer(cur+1);
		        max = Math.max(max,cur+1);
	        }
        }
		
       	for(int i=min;i<=max;i++){
	       	res.add(map.get(i));
       	}
       	return res;
    }
}