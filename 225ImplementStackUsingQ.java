/*
225. Implement Stack using Queues 

Implement the following operations of a stack using queues.

push(x) -- Push element x onto stack.
pop() -- Removes the element on top of the stack.
top() -- Get the top element.
empty() -- Return whether the stack is empty.
Notes:
You must use only standard operations of a queue -- which means only push to back, peek/pop from front, size, and is empty operations are valid.
Depending on your language, queue may not be supported natively. You may simulate a queue by using a list or deque (double-ended queue), as long as you use only standard operations of a queue.
You may assume that all operations are valid (for example, no pop or top operations will be called on an empty stack).
*/

class 225ImplementStackUsingQ  {
    private class MyQueue{
        ArrayList<Integer> list = new ArrayList<Integer>();
        public void push(int x){
            list.add(x);
        }
        public int pop(){
            return(list.remove(0));
        }
        public int peek(){
            return list.get(0);
        }
        public boolean empty(){
            return list.isEmpty();
        }
    }
    // Push element x onto stack.
    MyQueue queue = new MyQueue();
    public void push(int x) {
        MyQueue temp = new MyQueue();
        while(!queue.empty())
            temp.push(queue.pop());
        queue.push(x);
        while(!temp.empty())
            queue.push(temp.pop());

    }

    // Removes the element on top of the stack.
    public void pop() {
        queue.pop();
    }

    // Get the top element.
    public int top() {
        return(queue.peek());
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return(queue.empty());
    }
}