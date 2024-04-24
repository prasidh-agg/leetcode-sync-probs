class MyQueue {

    Stack<Integer> input = new Stack<>();
    Stack<Integer> output = new Stack<>();

    public MyQueue() {
        
    }
    
    // first transfer everything from input stack to output stack, then add x, then transfer everything from output back to input stack.
    public void push(int x) {
        while(input.empty() == false){
            output.push(input.peek());
            input.pop();
        }
        input.push(x);
        while(output.empty() == false){
            input.push(output.peek());
            output.pop();
        }
    }
    
    public int pop() {
        int val = input.peek();
        input.pop();
        return val;
    }
    
    public int peek() {
        return input.peek();
    }
    
    public boolean empty() {
        return input.size() == 0;
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
