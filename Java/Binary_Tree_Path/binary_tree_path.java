//Given a binary tree, return all root-to-leaf paths.

//For example, given the following binary tree:

//   1
// /   \
//2     3
// \
//  5
//All root-to-leaf paths are:

//["1->2->5", "1->3"]


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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new LinkedList<String>();
        if (root == null){
	        return result;
        }

        cal(root,"",result);
        return result;
    }

    public void cal(TreeNode root,String path,List<String> result){
	    if(root.left==null&&root.right==null){
		    result.add(path+root.val);
		    return;
	    }
		if(root.left!=null){
			cal(root.left,path+root.val+"->",result);
		}
		if(root.right!=null){
			cal(root.right,path+root.val+"->",result);
		}
		return;
	    
    }
}