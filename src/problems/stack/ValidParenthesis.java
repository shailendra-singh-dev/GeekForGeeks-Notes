package problems.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * https://www.geeksforgeeks.org/check-for-balanced-parentheses-in-an-expression/
 * 
 * @author ShSingh
 *
 */
public class ValidParenthesis {

	public  boolean isParenthesisMatchedUsingStack(String str) {
		if (str == null || str.isEmpty()) {
			return false;
		}
		Stack<Character> stack = new Stack<Character>();
		for (int i = 0; i < str.length(); i++) {
			char current = str.charAt(i);
			if (current == '{' || current == '[' || current == '('
					|| current == '<') {
				stack.push(current);
			}
			if (current == '}' || current == ']' || current == ')'
					|| current == '>') {

				if (stack.isEmpty()) {
					return false;
				}

				char last = stack.peek();
				if ((last == '{' && current == '}')
						|| (last == '[' && current == ']')
						|| (last == '(' && current == ')')
						|| (last == '<' && current == '>')) {
					stack.pop();
				}
			}
		}
		return stack.isEmpty();
	}

	public boolean isParenthesisMatchedUsingHashMap(String str) {
		boolean isMatched = false;

		if (str == null || str.isEmpty()) {
			return false;
		}

		for (int i = 0; i < str.length(); i++) {
			char token = str.charAt(i);
			if (token == '{' || token == '[' || token == '(' || token == '<') {
				for (int j = 0; j < str.length() - i - 1; j++) {
					char nextToken = str.charAt(j);
					if (nextToken == '}' || nextToken == ']'
							|| nextToken == ')' || nextToken == '>') {
						isMatched = true;
						break;
					}
				}
			}
		}
		return isMatched;
	}

	public static void test() {
		ValidParenthesis validParenthesis = new ValidParenthesis();
		String str = "{[abc]()[]797ABC}";
		boolean isParenthesisMatched = validParenthesis.isParenthesisValid(str);
		System.out.println("isParenthesisMatched()"+isParenthesisMatched);
	}

	
	private boolean isParenthesisValid(String str) {
		if (str.isEmpty() || null == str) {
			return false;
		}
		Stack<Character> stack = new Stack<Character>();
		for (int i = 0; i < str.length(); i++) {
			char charFound = str.charAt(i);
			if (charFound == '[' || charFound == '{' || charFound == '(') {
				stack.push(charFound);
			}
			if (charFound == ']' || charFound == '}' || charFound == ')') {
				char charAtTop = stack.pop();
				if (charAtTop == '[' || charAtTop == '{' || charAtTop == '(') {
					continue;
				}	
			}
		}
		return stack.isEmpty();		
	}
}
