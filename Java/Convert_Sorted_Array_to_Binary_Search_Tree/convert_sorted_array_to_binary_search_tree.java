//Given an array where elements are sorted in ascending order, convert it to a height balanced BST.


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
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums.length==0) return null;
        return buildTree(nums,0,nums.length-1);
    }

    public TreeNode buildTree(int[] nums,int i,int j){
        if(i>j) return null;
        if(i==j) return new TreeNode(nums[i]);
        int mid = (i+j)/2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = buildTree(nums,i,mid-1);
        node.right = buildTree(nums,mid+1,j);
        return node;
    }
}