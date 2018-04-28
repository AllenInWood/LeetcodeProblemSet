// class MyStack {

//     Deque<Integer> queue;
    
//     /** Initialize your data structure here. */
//     public MyStack() {
//         queue = new LinkedList<>();
//     }
    
//     /** Push element x onto stack. */
//     public void push(int x) {
//         queue.offer(x);
//     }
    
//     /** Removes the element on top of the stack and returns that element. */
//     public int pop() {
//         return queue.pollLast();
//     }
    
//     /** Get the top element. */
//     public int top() {
//         return queue.peekLast();
//     }
    
//     /** Returns whether the stack is empty. */
//     public boolean empty() {
//         return queue.isEmpty();
//     }
// }

class MyStack {
    Queue<Integer> queue;
    
    /** Initialize your data structure here. */
    public MyStack() {
        queue = new LinkedList<>();
    }
    
    /** Push element x onto stack. */
    public void push(int x) {
        queue.offer(x);
        //put the new element onto the top of the queue
        for (int i = 1; i < queue.size(); i++) {
            queue.offer(queue.remove());
        }
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return queue.remove();
    }
    
    /** Get the top element. */
    public int top() {
        return queue.peek();
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue.isEmpty();
    }
}


/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */