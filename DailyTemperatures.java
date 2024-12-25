package neetcode150;

import java.util.*;

public class DailyTemperatures {
	public static void main(String[] args) {
		System.out.println(Arrays.toString(dailyTemperatures(new int[] { 73, 74, 75, 71, 69, 72, 76, 73 })));
		System.out.println(Arrays.toString(dailyTemperatures(new int[] { 30, 40, 50, 60 })));
		System.out.println(Arrays.toString(dailyTemperatures(new int[] { 30, 60, 90 })));
	}

	public static int[] dailyTemperatures(int[] temperatures) {
//		Stack<Integer> stack = new Stack<Integer>();
		int n = temperatures.length;
		int[] res = new int[n];

//		for (int i = 0; i < n; i++) {
//			if (stack.isEmpty() || temperatures[stack.peek()] > temperatures[i]) {
//				stack.push(i);
//			} else {
//				while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]) {
//					res[stack.peek()] = i - stack.pop();
//				}
//				stack.push(i);
//			}
//		}
//
//		for (int i = 0; i < n; i++) {
//			
//			while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]) {
//				res[stack.peek()] = i - stack.pop();
//			}
//			stack.push(i);
//			
//		}
		
		int[] st = new int[n];
		int top = -1;
		
		for (int i = 0; i < n; i++) {

			while (top != -1 && temperatures[st[top]] < temperatures[i]) {
				res[st[top]] = i - st[top--];
			}
			st[++top] = i;

		}
		return res;
	}
}
