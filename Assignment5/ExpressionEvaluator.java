package eg.edu.alexu.csd.datastructure.stack.cs23;
/**
* Java class implements IExpressionEvaluator
* This class solve infix to postfix notation and evaluate the expression.
*
* @author Hazem Shawky
* @version  27 April 2019
*/
public class ExpressionEvaluator {
	/**
	* Takes a char operator and return a number represents priority
	*
	* @param operator
	* char operator
	* @return a number denotes to the priority of this operator
	*/
	static int priority(char operator) {
		if (operator == '*' || operator == '/')
			return 2;
		else if (operator == '+' || operator == '-')
			return 1;
		else
			return 0;
			}
	/**
	* Takes a symbolic/numeric infix expression as input and check that the expression
	* is valid by making sure that all open parentheses have its closing one
	*
	* @param expression
	* infix expression
	* @return true if the expression is valid
	*/
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
	/**
	* Takes a symbolic/numeric infix expression as input and replacing all unary '-'
	* with '!' to find the difference between unary and binary - .
	*
	* @param expression
	* infix expression
	* @return String with '!' replacing unary '-'
	*/
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
	/**
	* Takes a symbolic/numeric infix expression as input and check
	* that the input is valid. There is no assumption on spaces between terms or the
	* length of the term (e.g., two digits symbolic or numeric term) and make sure that
	* number of operands is equal to number of operators+1
	*
	* @param expression
	* infix expression
	* @return true if the expression is valid
	*/
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
	/**
	* Takes a symbolic/numeric infix expression as input and converts it to
	* postfix notation. There is no assumption on spaces between terms or the
	* length of the term (e.g., two digits symbolic or numeric term)
	*
	* @param expression
	* infix expression
	* @return postfix expression
	*/
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
	/**
	* Evaluate a postfix numeric expression, with a single space separator
	*
	* @param expression
	* postfix expression
	* @return the expression evaluated value
	*/
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
