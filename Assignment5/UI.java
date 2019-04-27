package eg.edu.alexu.csd.datastructure.stack.cs23;
import java.util.Scanner;
public class UI {
	static void loop(Stack s) {
		System.out.println("IStack tester");
		System.out.println("Please enter a valid input from 1 to 5 or enter -1 for end the program");
		System.out.println("1: Push\n" + 
				"2: Pop\n" + 
				"3: Peek\n" + 
				"4: Get size\n" + 
				"5: Check if empty");
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		Object element = new Object();
		element = scn.nextLine();
		switch(n) {
		case 1:
			System.out.println("Enter the element");
			element = scn.nextLine();
			s.push(element);
			break;
		case 2:
			element= s.pop();
			System.out.println("The element is " + element);
			break;
		case 3:
			element = s.peek();
			System.out.println("The peek is " + element);
			break;
		case 4:
			System.out.println("The size of stack is " + s.size());
			break;
		case 5:
			System.out.println(s.isEmpty() ? "The stack is empty" : "The stack is not empty");
			break;
		case -1 :
			return;
		default:
			System.out.println("Error please enter a valid input from 1 to 5 or enter -1 for end the program");
			break;
		}
		System.out.println();
		loop(s);
	}
	public static void main(String args[]) {
		Stack s = new Stack();
		loop(s);
			}
}
