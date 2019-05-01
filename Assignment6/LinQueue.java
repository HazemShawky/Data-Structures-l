package eg.edu.alexu.csd.datastructure.queue.cs51_cs23;
class Node{
	private Object element;
	private Node next;
	public Object getElement() {
		return element;
	}
	public Node getNext() {
		return next;
	}
	public void setElement(Object e) {
		element = e;
	}
	public void setNext(Node n) {
		next = n;
	}
}
public class LinQueue {
	Node front, rear;
	int size;
	public LinQueue(){
		front = null;
		rear = null;
		size = 0;
	}
	public void enqueue(Object item) {
		Node newNode = new Node();
		newNode.setElement(item);
		newNode.setNext(null);
		if(size==0)
			front = newNode;
		else
			rear.setNext(newNode);
		rear = newNode;
		size++;
	}
	public Object dequeue() {
		if(size == 0)
			throw new RuntimeException("Queue is empty");
		Object o = front.getElement();
		front = front.getNext();
		size--;
		if(size == 0)
			rear = null;
		return o;
	}
	public boolean isEmpty() {
		return size == 0;
	}
	public int size() {
		return size;
	}
}
