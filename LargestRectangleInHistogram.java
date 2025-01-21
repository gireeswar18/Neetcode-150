package neetcode150;

import java.util.Stack;

public class LargestRectangleInHistogram {
	public static void main(String[] args) {
		int[] t1 = { 2, 1, 5, 6, 2, 3 };
		System.out.println(largestRectangleArea(t1));

		int[] t2 = { 2, 4 };
		System.out.println(largestRectangleArea(t2));
	}

	public static int largestRectangleArea(int[] heights) {
		Stack<Integer> stack = new Stack<>();
		int maxArea = 0;
		int n = heights.length;
		
		for (int i = 0; i < n; i++) {
			while (!stack.isEmpty() && heights[stack.peek()] > heights[i]) {
				
				int curr = heights[stack.pop()];
				int nse = i;
				int pse = stack.isEmpty() ? -1 : stack.peek();
				
				maxArea = Math.max(maxArea, curr * (nse - pse - 1));
 				
			}
			
			stack.push(i);
		}
		
		
		while (!stack.isEmpty()) {
			int curr = heights[stack.pop()];
			int nse = n;
			int pse = stack.isEmpty() ? -1 : stack.peek();
			
			maxArea = Math.max(maxArea, curr * (nse - pse - 1));
		}
		
		return maxArea;
		
	}
}
