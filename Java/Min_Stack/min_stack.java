//Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

//push(x) -- Push element x onto stack.
//pop() -- Removes the element on top of the stack.
//top() -- Get the top element.
//getMin() -- Retrieve the minimum element in the stack.


class MinStack {
	Stack<Integer> stack = new Stack<>();
	int min = Integer.MAX_VAlUE;
	
    public void push(int x) {
        if(x<min){
	        stack.push(min);
	        min = x;
        }
        stack.push(x);
    }

    public void pop() {
	    if(stack.empty()){
		    return;
	    }
        int n = stack.pop();
        if(n==min){
	        min = stack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min;
    }
}
