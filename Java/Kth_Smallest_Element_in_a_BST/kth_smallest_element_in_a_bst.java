//Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.

//Note: 
//You may assume k is always valid, 1 ≤ k ≤ BST's total elements.

//Follow up:
//What if the BST is modified (insert/delete operations) often and you need to find the kth smallest frequently? How would you optimize the kthSmallest routine?

//Hint:

//Try to utilize the property of a BST.
//What if you could modify the BST node's structure?
//The optimal runtime complexity is O(height of BST).


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

//Binary Search
public class Solution {
    public int kthSmallest(TreeNode root, int k) {
        int count = cal(root.left);
        if(count>=k){
	        return kthSmallest(root.left,k);
        }else if(k>count+1){
	        return kthSmallest(root.right,k-count-1);
        }
        return root.val;
    }

    public int cal(TreeNode root){
	    if(root==null) return 0;
	    return cal(root.left)+cal(root.right)+1;
    }
}

//In Order Traversal (Recursive)
public class Solution {
	public int count;
	public int number;
    public int kthSmallest(TreeNode root, int k) {
		count = k;
		helper(root);
		return number;
    }

    public void helper(TreeNode root){
	    if(root.left!=null) helper(root.left);
        count--;
        if(count==0){
	        number = root.val;
	        return;
        }
        if(root.right!=null) helper(root.right);
    }
}

//In Order Traversal (Iterative)
public class Solution {
	public int kthSmallest(TreeNode root, int k) {
	    Stack<TreeNode> st = new Stack<>();

	    while (root != null) {
	        st.push(root);
	        root = root.left;
	    }

	    while (k != 0) {
	        TreeNode n = st.pop();
	        k--;
	        if (k == 0) return n.val;
	        TreeNode right = n.right;
	        while (right != null) {
	            st.push(right);
	            right = right.left;
	        }
	    }

	    return -1; // never hit if k is valid
	}
}