//Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.

//For example:
//Given the below binary tree and sum = 22,
//              5
//             / \
//            4   8
//           /   / \
//          11  13  4
//         /  \      \
//        7    2      1
//return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.


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
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root==null){
	        return false;
        }
        List<Integer> sums = new ArrayList<Integer>();
        calSum(root,sums,0);
        return sums.contains(sum);
    }

    public void calSum(TreeNode root,ArrayList sums,int temp){
	    if(root.left==null&&root.right==null){
		    sums.add(temp+root.val);
		    return;
	    }
	    if(root.left!=null){
		    calSum(root.left,sums,temp+root.val);
	    }
	    if(root.right!=null){
		    calSum(root.right,sums,temp+root.val);
	    }
    }
}


//A Better Solution
public class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null) return false;

        if(root.left == null && root.right == null && sum - root.val == 0) return true;

        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }
}