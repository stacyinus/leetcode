/*
155. Min Stack

Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

push(x) -- Push element x onto stack.
pop() -- Removes the element on top of the stack.
top() -- Get the top element.
getMin() -- Retrieve the minimum element in the stack.
*/
class MinStack {
	int min = Integer.MAX_VALUE;
	Stack<Number> stack = new Stack<Number>();
    public void push(int x) {
        if(min>x)
        	min = x;
        stack.push(new Number(x,min));
    }

    public void pop() {
        stack.pop();
        if(stack.isEmpty())
        	min = Integer.MAX_VALUE;
        else
        	min = stack.peek().min;
    }

    public int top() {
        return(stack.peek().value);
    }

    public int getMin() {
        return min;
    }
    static class Number{
    	int value;
    	int min;
    	public Number(int value, int min){
    		this.value = value;
    		this.min = min;
    	}
    }
}
