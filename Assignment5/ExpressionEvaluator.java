package eg.edu.alexu.csd.datastructure.stack.cs23;
public class ExpressionEvaluator {
	static int priority(char operator) {
		if (operator == '*' || operator == '/')
			return 2;
		else if (operator == '+' || operator == '-')
			return 1;
		else
			return 0;
			}
	static boolean checkParentheses(String expression) {
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
	static String checkMinus(String expression) {
		boolean flag = true;
		for (int i = 0; i < expression.length(); ++i) {
			char c = expression.charAt(i);
			while((c == ' ' || c == '\t') && i < expression.length()-1)
				c = expression.charAt(++i);
			if(c=='-' && flag) {
				flag = false;
				expression = expression.substring(0,i)+'!'+expression.substring(i+1);
			}
			if(c=='+'||c=='-'||c=='*'||c=='/'||c=='(')
				flag = true;
			if(Character.isLetterOrDigit(c))
					flag = false;
		}
		return expression;
	}
	static boolean checkExpression(String expression){
		int cnt1 = 0, cnt2 = 0;
		for (int i = 0; i < expression.length(); ++i) {
			char c = expression.charAt(i);
			if(c == '+' || c == '*' || c == '/' ||c== '-')
				cnt1++;
			if(Character.isLetterOrDigit(c))
				cnt2++;
		}
		if(cnt1+1==cnt2)
			return true;
		return false;
	}
	public static String infixToPostfix(String expression) {
		checkParentheses(expression);
		expression = checkMinus(expression);
		if(!checkExpression(expression))
			throw new RuntimeException("Enter valid expression");
		String ans= new String("");
		Stack s = new Stack();
		expression += ' ';
		for(int i = 0; i < expression.length(); ++i) {
			char c = expression.charAt(i);
			while((c == ' ' || c == '\t') && i < expression.length()-1)
				c = expression.charAt(++i);
			while(Character.isLetterOrDigit(c)  || c=='!') {
				ans += c;
				c = expression.charAt(++i);
			}
				if(ans.length() != 0 && ans.charAt(ans.length()-1) != ' ' && ans.charAt(ans.length()-1) != '!')
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
		return ans.substring(0, ans.length()-1);
	}
	public static int evaluate(String expression) {
		float ans = 0;
		String c = "";
		expression += ' ';
		Stack s = new Stack();
		for(int i = 0; i < expression.length(); ++i) {
			if(expression.charAt(i)==' ') {
				if (c != "") 
					s.push((float)Integer.parseInt(c.replace('!', '-')));
				c = "";
			}
			else if (expression.charAt(i) == '+' || expression.charAt(i) == '-' || expression.charAt(i) == '*'  || expression.charAt(i) == '/' )
			{
				float operand1 = (float)s.pop();
				float operand2 = (float)s.pop();
				switch(expression.charAt(i)) {
				 case '+':
					 ans += operand1 + operand2;
					 break;
				 case '-':
					 ans += operand2 - operand1;
					 break;
				 case '*':
					 ans += operand1 * operand2;
					 break;
				 case '/':
					 ans += operand2 / operand1;
					 break;
				}
				s.push(ans);
				ans = 0;
			}
			else
				c += expression.charAt(i);
		}
		ans = (float)s.pop();
		return (int)ans;
	}
}
