//Given an array of numbers, verify whether it is the correct preorder traversal sequence of a binary search tree.

//You may assume each number in the sequence is unique.

//Follow up:
//Could you do it using only constant space complexity?



//O(n) SPACE
public class Solution {
    public boolean verifyPreorder(int[] preorder) {
        int low = Integer.MIN_VALUE;
        Stack<Integer> stack = new Stack<>();
        for(int n:preorder){
	        if(n<low) return false;
	        while(!stack.empty()&&n>stack.peek()) low = stack.pop();
	        stack.push(n);
        }
        return true;
    }
}

//O(1) SPACE
public class Solution {
    public boolean verifyPreorder(int[] preorder) {
        int low = Integer.MIN_VALUE, i=-1;
        for(int n:preorder){
	        if(n<low) return false;
	        while(i>=0&&n>preorder[i]) low = preorder[i--];
	        preorder[++i]=n;
        }
        return true;
    }
}