package eg.edu.alexu.csd.datastructure.queue.cs51_cs23;
import java.util.Scanner;
public class UI {
	static void loop(ArrQueue q) {
		System.out.println("IQueue tester");
		System.out.println("Please enter a valid input from 1 to 4 or enter -1 for end the program");
		System.out.println("1: enqueue\n" + 
				"2: dequeue\n" + 
				"3: Get size\n" + 
				"4: Check if empty");
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		Object element = new Object();
		element = scn.nextLine();
		switch(n) {
		case 1:
			System.out.println("Enter the element");
			element = scn.nextLine();
			q.enqueue(element);
			break;
		case 2:
			element= q.dequeue();
			System.out.println("The element is " + element);
			break;
		case 3:
			System.out.println("The size of Queue is " + q.size());
			break;
		case 4:
			System.out.println(q.isEmpty() ? "The Queue is empty" : "The Queue is not empty");
			break;
		case -1 :
			return;
		default:
			System.out.println("Error please enter a valid input from 1 to 4 or enter -1 for end the program");
			break;
		}
		System.out.println();
		loop(q);
	}
	public static void main(String args[]) {
		ArrQueue q = new ArrQueue(3);
		loop(q);
			}
}
