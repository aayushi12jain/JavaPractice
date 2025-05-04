package stack;

public class Stack {

	int[] stack = new int[8];
	static int top=-1;
	
	public void push(int data) {
		top++;
		stack[top]= data;
	}
	
	public int pop() {
		int temp = stack[top];
		stack[top] =0;
		top--;
		return temp;
	}
	
	public int top() {
		return stack[top];
	}
	
	public boolean isEmpty() {
		if(top == -1) {
			return true;
		}else {
			return false;
		}
	}
	
	public boolean isFull() {
		if(top == (stack.length-1)) {
			return true;
		}else {
			return false;
		}
	}
}
