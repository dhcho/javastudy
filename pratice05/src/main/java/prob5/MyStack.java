package prob5;

public class MyStack {
	private int top;
	private String stack[];
	
	public MyStack(int size) {
		this.top = -1;
		this.stack = new String[size];
	}
	
	public boolean isEmpty() {
		if(top == -1) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean isFull() {
		if(top == this.stack.length -1) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public void push(String data) {
		if(isFull()) {
			resize(stack.length + 1);
			stack[++top] = data;
		} else {
			stack[++top] = data;
		}
	}
	
	public String pop() throws MyStackException {
		if(isEmpty()) {
			throw new MyStackException("Stack is empty.");
		}
		String data = stack[top];
		stack[top--] = null;
		
		return data;
	}
	
	public void resize(int size) {
		String temp[] = new String[size];
		
		for(int i = 0; i < stack.length; i++) {
			temp[i] = stack[i];
		}
		
		stack = temp;
	}
}