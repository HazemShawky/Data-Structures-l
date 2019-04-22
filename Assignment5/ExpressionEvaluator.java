package eg.edu.alexu.csd.datastructure.stack.cs23;
public class ExpressionEvaluator {
	public static int priority(char operator) {
		if (operator == '*' || operator == '/')
			return 2;
		else if (operator == '+' || operator == '-')
			return 1;
		else
			return 0;
			}
	public static boolean checkParentheses(String expression) {
		Stack s = new Stack();
		for (int i = 0; i < expression.length(); ++i) {
			if(expression.charAt(i) == '(')
				s.push('(');
			else if (expression.charAt(i) == ')') {
				if(s.isEmpty())
					throw new RuntimeException("error");
				s.pop();
			}
		}
		if(s.isEmpty())
			return true;
		else
			throw new RuntimeException("error");
	}
	public static String infixToPostfix(String expression) {
		String ans= new String("");
		Stack s = new Stack();
		expression += ' ';
		for(int i = 0; i < expression.length(); ++i) {
			char c = expression.charAt(i);
			while((c == ' ' || c == '\t') && i < expression.length()-1)
				c = expression.charAt(++i);
			while(Character.isLetterOrDigit(c)) {
				ans += c;
				c = expression.charAt(++i);
			}
				if(ans.length() != 0 && ans.charAt(ans.length()-1) != ' ')
					ans += ' ';
			if (c == '(') 
                s.push(c); 
			if (c == ')') 
            { 
                while (!s.isEmpty() && (char)s.peek() != '(') 
                    ans += s.pop(); 
                    s.pop(); 
            }
			if (c=='+' || c == '-' || c == '*' || c == '/') {
				while (!s.isEmpty() && priority(c) <= priority((char)s.peek())) {
                    ans += s.pop();
                    ans += ' ';
				}
                s.push(c);
			}
		}
			while (!s.isEmpty()) {
	            ans += s.pop();
	            ans += ' ';
			}
		return ans;
	}
  }
