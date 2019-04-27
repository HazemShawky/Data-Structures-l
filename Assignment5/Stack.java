package eg.edu.alexu.csd.datastructure.stack.cs23;
/**
* Java class implements IStack
* The class contains the implementaion of the stack by using nodes.
*
* @author Hazem Shawky
* @version  27 April 2019
*/

/**
* class defines node.
*
* obj contains the value of the node.
* 
* next points to a node next to the current node.
*/
class node{
	node next;
	Object obj;
}
public class Stack{
	private node top;
    Stack(){
		top = null;
	}
    /**
    * Removes the element at the top of stack and returns that element.
    *
    * @return top of stack element, or through exception if empty
    */
	public Object pop(){
		if(this.isEmpty())
			throw new RuntimeException("Stack is empty");
		Object ans = top.obj;
		top = top.next;
		return ans;
	}
	/**
	* Get the element at the top of stack without removing it from stack.
	*
	* @return top of stack element, or through exception if empty
	*/
	public Object peek() {
		if(this.isEmpty())
			throw new RuntimeException("Stack is empty");
		return top.obj;
	}
	/**
	* Pushes an item onto the top of this stack.
	*
	* @param object
	* to insert
	*/
	public void push(Object element) {
		node newNode = new node();
		newNode.obj = element;
		newNode.next = top;
		top = newNode;
	}
	/**
	* Tests if this stack is empty
	*
	* @return true if stack empty
	*/
	public boolean isEmpty() {
		return top == null;
	}
	/**
	* Returns the number of elements in the stack.
	*
	* @return number of elements in the stack
	*/
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
