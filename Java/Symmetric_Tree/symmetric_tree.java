//Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

//For example, this binary tree is symmetric:

//    1
//   / \
//  2   2
// / \ / \
//3  4 4  3
//But the following is not:
//    1
//   / \
//  2   2
//   \   \
//   3    3


public class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root==null)
            return true;
        return isSymSubTree(root.left, root.right);
    }

    public boolean isSymSubTree(TreeNode left, TreeNode right){
        if(left==null)
            return (right==null);
        if(right==null)
            return false;
         return (left.val==right.val) && isSymSubTree(left.left,right.right) && isSymSubTree(left.right,right.left);
    }
}