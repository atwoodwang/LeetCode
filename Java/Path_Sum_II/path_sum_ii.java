//Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.

//For example:
//Given the below binary tree and sum = 22,
//              5
//             / \
//            4   8
//           /   / \
//          11  13  4
//         /  \    / \
//        7    2  5   1
//return
//[
//   [5,4,11,2],
//   [5,8,4,5]
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
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> sumList = new ArrayList<List<Integer>>();
        if (root == null) {
            return sumList;
        }
        List<Integer> values = new ArrayList<Integer>();
        cal(root, sumList, values);

        List<List<Integer>> result = new ArrayList<List<Integer>>();

        for (List<Integer> list : sumList) {
            int s = 0;
            for (int i = 0; i < list.size(); i++) {
                s = s + list.get(i);
            }
            if (s == sum) {
                result.add(list);
            }
        }

        return result;
    }

    public void cal(TreeNode root, List<List<Integer>> sumList, List<Integer> values) {
        if (root.left == null & root.right == null) {
            values.add(root.val);
            sumList.add(new ArrayList(values));
            values.remove(values.size()-1);
            return;
        }

        if (root.left != null) {
            values.add(root.val);
            cal(root.left, sumList, values);
            values.remove(values.size()-1);
        }

        if (root.right != null) {
            values.add(root.val);
            cal(root.right, sumList, values);
            values.remove(values.size()-1);
        }
    }
}