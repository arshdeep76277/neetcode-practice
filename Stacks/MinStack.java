// https://leetcode.com/problems/min-stack/description/

import java.util.Stack;

class MinStack {

    private Stack<Integer> original;
    private Stack<Integer> minStack;

    public MinStack() {
        original=new Stack<>();
        minStack=new Stack<>();
    }
    
    public void push(int val) {
        original.push(val);
        if(minStack.isEmpty()) minStack.push(val);
        else if(minStack.peek()>=val) minStack.push(val);
    }
    
    public void pop() {
        if(minStack.peek() - original.pop()==0){
            minStack.pop();
        }
    }
    
    public int top() {
        return original.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */