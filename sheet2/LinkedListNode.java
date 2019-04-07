public class LinkedListNode {
	private int value;
	private LinkedListNode next;
	public LinkedListNode(int x, LinkedListNode n) {
		value = x;
		next = n;
	}
	public int getValue() {
		return value;
	}
	public LinkedListNode getNext() {
		return next;
	}
	public void setValue(int x) {
		value = x;
	}
	public void setNext(LinkedListNode n) {
		next = n;
	}
}
