//Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or another computer environment.

//Design an algorithm to serialize and deserialize a binary tree. There is no restriction on how your serialization/deserialization algorithm should work. You just need to ensure that a binary tree can be serialized to a string and this string can be deserialized to the original tree structure.

//For example, you may serialize the following tree

//    1
//   / \
//  2   3
//     / \
//    4   5
//as "[1,2,3,null,null,4,5]", just the same as how LeetCode OJ serializes a binary tree. You do not necessarily need to follow this format, so please be creative and come up with different approaches yourself.
//Note: Do not use class member/global/static variables to store states. Your serialize and deserialize algorithms should be stateless.


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        treeToString(root,sb);
        return sb.toString();
    }
    
    public void treeToString(TreeNode node,StringBuilder sb){
        if(node==null){
            sb.append("X").append(",");
            return;
        }
        sb.append(node.val+",");
        treeToString(node.left,sb);
        treeToString(node.right,sb);
    }
    
    
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Deque<String> queue = new LinkedList<>();
        queue.addAll(Arrays.asList(data.split(",")));
        return stringToTree(queue);
    }
    
    public TreeNode stringToTree(Deque<String> queue){
        String s = queue.poll();
        if(s.equals("X")) return null;
        TreeNode node = new TreeNode(Integer.parseInt(s));
        node.left = stringToTree(queue);
        node.right = stringToTree(queue);
        return node;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));