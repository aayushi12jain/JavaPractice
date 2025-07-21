import java.util.ArrayDeque;
import java.util.Deque;
import java.util.PriorityQueue;
import java.util.Stack;

public class MinStack {
    Stack<Integer> st= null;
    Stack<Integer> minStack = null;
    
    public MinStack() {
       st = new Stack<>();
       minStack = new Stack<>();
    }
    
    public void push(int val) {
        if(!minStack.isEmpty()){
            if(val < minStack.peek())
                minStack.push(val);
        }
        st.push(val);
    }
    
    public void pop() {
        int i = st.pop();
        if(!minStack.isEmpty()){
            if(i == minStack.peek())
                minStack.pop();
        }
    }
    
    public int top() {
        return st.peek();
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