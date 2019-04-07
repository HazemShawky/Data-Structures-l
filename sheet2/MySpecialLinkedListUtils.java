
public class MySpecialLinkedListUtils {
	public static double[] summary(LinkedListNode head) {
		LinkedListNode curNode = head;
		int counter = 0;
		double summary[] = {0.0, 0.0, 0.0, 0.0, 0.0};
		summary[3] = head.getValue();
		summary[4] = head.getValue();
		while (curNode != null) {
			summary[0] += curNode.getValue();
			if (curNode.getValue() > summary[3])
			{
				summary[3] = curNode.getValue();
			}
			if (curNode.getValue() < summary[4])
			{
				summary[4] = curNode.getValue();
			}
			counter++;
			curNode = curNode.getNext();
		}
		summary[1] = summary[0]/counter;
		curNode = head;
		if (counter % 2 == 0) {
			for(int i=0; i<counter/2-1; ++i) {
				curNode = curNode.getNext();
			}
			summary[2] = curNode.getValue();
			curNode = curNode.getNext();
			summary[2] += curNode.getValue();
			summary[2] /=2;
		}else {
			for(int i=0; i<counter/2; ++i) {
				curNode = curNode.getNext();
			}
			summary[2] = curNode.getValue();
		}
		return summary;
	}
	public static LinkedListNode reverse(LinkedListNode head) {
		LinkedListNode prev = null, cur = head, next=null;
		while(cur != null)
		{
			next = cur.getNext();
			cur.setNext(prev);
			prev = cur;
			cur = next;	
		}
		return prev;
	}
	public static LinkedListNode evenIndexElements(LinkedListNode head) {
		LinkedListNode temp, curNode = head;
		temp = curNode.getNext();
		while(curNode.getNext() != null && temp.getNext()!= null) {
			temp = temp.getNext();
			curNode.setNext(temp);
			curNode = curNode.getNext();
			temp = curNode.getNext();
		}
		if(temp.getNext() == null)
			curNode.setNext(null);
		return head;
	}
	public static LinkedListNode insertionSort(LinkedListNode head) {
		if(head.getNext()==null)
			return head;
		LinkedListNode x, prev=null, curNode=head.getNext().getNext(), start=head.getNext(), temp=head;
		boolean flag;
		for(x=head; x.getNext() != null; x=x.getNext()) {
			if(x.getNext().getValue() < temp.getValue()) {
				temp = x.getNext();
				prev = x;
			}
		}
		prev.setNext(temp.getNext());
		temp.setNext(head);
		head = temp;
		
		while(start.getNext() != null) {
			if(curNode.getValue() < start.getValue()) {
				flag = false;
				for(x=head; x != start&& !flag; x=x.getNext()) {
					if(curNode != null && curNode.getValue() >= x.getValue() && curNode.getValue() <= x.getNext().getValue()) {
						temp = x.getNext();
						start.setNext(curNode.getNext());
						curNode.setNext(temp);
						x.setNext(curNode);
						curNode = start.getNext();
						flag = true;
					}
				}
			}else {
				start = start.getNext();
				curNode = curNode.getNext();
			}
		}

		return head;
	}
	public static LinkedListNode getMiddle(LinkedListNode head) {
		LinkedListNode oneStep=head, twoStep=head;
		while(twoStep.getNext() != null && twoStep.getNext().getNext() != null) {
			oneStep = oneStep.getNext();
			twoStep = twoStep.getNext().getNext();
		}
		return oneStep;
	}
	public static LinkedListNode merge(LinkedListNode l, LinkedListNode r){
		LinkedListNode newHead = new LinkedListNode(0, null);
		LinkedListNode curNode;
		for(curNode = newHead; l != null && r != null; curNode = curNode.getNext()) {
			if(l.getValue() <= r.getValue()) {
				curNode.setNext(l);
				l = l.getNext();
			}else {
				curNode.setNext(r);
				r = r.getNext();
			}
		}
		curNode.setNext((l==null) ? r : l);
		return newHead.getNext();
	}
	public static LinkedListNode mergeSort(LinkedListNode head) {
		if(head == null || head.getNext() == null) 
	        return head;
 		LinkedListNode Rhead, Lhead, Mhead;
 		Mhead = getMiddle(head);
 		Lhead = head;
 		Rhead = Mhead.getNext();
 		Mhead.setNext(null);
 		return merge(mergeSort(Lhead), mergeSort(Rhead));
 		
	}
	public static LinkedListNode removeCenttralNode(LinkedListNode head) {	
		LinkedListNode curNode = head;
		int counter = 0;
		while (curNode != null) {
			curNode = curNode.getNext();
			counter++;
		}
		curNode = head;
		if(counter==1 || counter ==2)
			return head;
		if(counter%2==1) {
			for(int i=0; i<counter/2-1; ++i) {
				curNode = curNode.getNext();
			}
			curNode.setNext(curNode.getNext().getNext());
		}else {
			for(int i=0; i<counter/2-2; ++i) {
				curNode = curNode.getNext();
			}
			curNode.setNext(curNode.getNext().getNext());
		}
		return head;
	}
	public static boolean palindrome(LinkedListNode head) {
		LinkedListNode curNode = head, temp = null;
		int size = 0;
		boolean palindrome = true;
		while (curNode != null) {
			curNode = curNode.getNext();
			size++;
		}
		for(int i = 0; i < size/2 && palindrome; ++i) {
			curNode = head;
			for (int j = 0; j < size-i-1 && palindrome; ++j) {
				if(i==j) {
					temp = curNode;
				}
				curNode = curNode.getNext();
			}
			if(temp.getValue() != curNode.getValue())
				palindrome = false;
		}
		return palindrome;
	}
}
