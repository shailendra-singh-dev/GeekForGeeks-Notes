package arrays;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParenthesis {

    public static boolean isParenthesisMatchedUsingStack(String str) {
	if (str == null || str.isEmpty()) {
	    return false;
	}
	Stack<Character> stack = new Stack<>();
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

    public static boolean isParenthesisMatchedUsingHashMap(String str) {
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

}
