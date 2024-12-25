package neetcode150;

public class EvaluateReversePolishNotation {
	public static void main(String[] args) {
		String[] t1 = { "2", "1", "+", "3", "*" };
		System.out.println(evalRPN(t1));

		String[] t2 = { "4", "13", "5", "/", "+" };
		System.out.println(evalRPN(t2));

		String[] t3 = { "10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+" };
		System.out.println(evalRPN(t3));
	}

	public static int evalRPN(String[] tokens) {
		int[] stack = new int[tokens.length];
		int top = -1;

		for (String token : tokens) {
			switch (token) {
			case "+":
				stack[top - 1] = stack[top - 1] + stack[top];
				top--;
				break;
			case "-":
				stack[top - 1] = stack[top - 1] - stack[top];
				top--;
				break;
			case "*":
				stack[top - 1] = stack[top - 1] * stack[top];
				top--;
				break;
			case "/":
				stack[top - 1] = stack[top - 1] / stack[top];
				top--;
				break;
			default:
				stack[++top] = Integer.parseInt(token);
			}
		}
		
		return stack[top];
	}
}
