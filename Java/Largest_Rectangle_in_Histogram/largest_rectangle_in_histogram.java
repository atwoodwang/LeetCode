public class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int max = 0;
        int i = 0;
        while(i<heights.length||!stack.empty()){
	        if(i<heights.length&&(stack.empty()||heights[i]>heights[stack.peek()])){
		        stack.push(i);
	        }else{
		        int area = 0;
		        int top = stack.pop();
		        if(stack.empty()){
			        area = heights[top]*i;
		        }else{
			        area = heights[top]*(i-stack.peek()-1);
		        }
		        max = Math.max(max,area);
	        }
        }
        return max;       
    }
}