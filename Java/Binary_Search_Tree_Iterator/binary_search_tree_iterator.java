/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class BSTIterator {
	Stack<TreeNode> stack = new Stack<>();
    public BSTIterator(TreeNode root) {
		pushLeft(root);
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.empty();
    }

    /** @return the next smallest number */
    public int next() {
       	TreeNode node = stack.pop();
		pushLeft(node.right);
		return node.val;
    }

    public void pushLeft(TreeNode node){
	    while(node!=null){
		    stack.push(node);
		    node=node.left;
	    }
    }
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */