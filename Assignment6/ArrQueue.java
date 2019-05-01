package eg.edu.alexu.csd.datastructure.queue.cs51_cs23;

public class ArrQueue {
	private int front, rear, size, capacity;
	private Object Q[];
	public ArrQueue(int c) {
		front = rear = size = 0;
		capacity = c;
		Q = new Object[capacity];
	}
	public void enqueue(Object item) {
		if(size == capacity)
			throw new RuntimeException("Queue overflow");
		Q[rear] = item;
		rear = (rear==capacity-1) ? 0 : rear+1;
		size++;
	}
	public Object dequeue() {
		if(size == 0)
			throw new RuntimeException("Queue underflow");
		Object o = Q[front];
		Q[front] = null;
		size--;
		front = (front==capacity-1) ? 0 : front+1;
		return o;
	}
	public boolean isEmpty() {
		return size == 0;
	}
	public int size() {
		return size;
	}
}
