package neetcode150;

public class MinStack {

	Node top;
	
	public class Node {
		int val;
		int minUptoMe;
		Node prev;
		
		public Node(int val, int min, Node prev) {
			this.val = val;
			this.minUptoMe = min;
			this.prev = prev;
		}
	}
	
	public MinStack() {
		this.top = null;
	}

	public void push(int val) {
		Node node;
		if (top == null) {
			node = new Node(val, val, null);
		}
		else {
			node = new Node(val, Math.min(val, top.minUptoMe) , top);
		}
		top = node;
	}

	public void pop() {
		top = top.prev;
	}

	public int top() {
		return top.val;
	}

	public int getMin() {
		return top.minUptoMe;
	}

	public static void main(String[] args) {
		MinStack obj = new MinStack();
		obj.push(-2);
		obj.push(0);
		obj.push(-1);
		System.out.println("Min: " + obj.getMin());
		obj.pop();
		System.out.println("Top: " + obj.top());
		System.out.println("Min: " + obj.getMin());
	}
}
