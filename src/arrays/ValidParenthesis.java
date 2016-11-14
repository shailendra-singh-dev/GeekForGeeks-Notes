package arrays;

public class ValidParenthesis {

   private static boolean isParenthesisMatched(String str) {
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
		
		if(stack.isEmpty()){
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

}
