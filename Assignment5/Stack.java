package eg.edu.alexu.csd.datastructure.stack.cs23;
class node{
	node next;
	Object obj;
}
public class Stack{
	private node top;
    Stack(){
		top = null;
	}
	public Object pop(){
		if(this.isEmpty())
			throw new RuntimeException("Stack is empty");
		Object ans = top.obj;
		top = top.next;
		return ans;
	}
	public Object peek() {
		if(this.isEmpty())
			throw new RuntimeException("Stack is empty");
		return top.obj;
	}
	public void push(Object element) {
		node newNode = new node();
		newNode.obj = element;
		newNode.next = top;
		top = newNode;
	}
	public boolean isEmpty() {
		return top == null;
	}
	public int size() {
		int cnt = 0;
		Stack t = new Stack();
		while(!this.isEmpty()) {
			t.push(this.pop());
			cnt++;
		}
		for(int i =0; i < cnt; ++i)
			this.push(t.pop());
		return cnt;
	}
}
