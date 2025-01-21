package neetcode150;

public class ValidParentheses {
	public static void main(String[] args) {
		System.out.println(isValid("()"));
		System.out.println(isValid("()[]{}"));
		System.out.println(isValid("(]"));
		System.out.println(isValid("([])"));
	}

	public static boolean isValid(String s) {
		char[] stack = new char[s.length()];
		int top = -1;
		
		for (char c : s.toCharArray()) {
			if (c == '[') stack[++top] = ']';
			else if (c == '(') stack[++top] = ')';
			else if (c == '{') stack[++top] = '}';
			else {
				if (top == -1 || stack[top] != c)
					return false;
				top--;
			}
		
		}
		
		return top == -1;
	}
}
