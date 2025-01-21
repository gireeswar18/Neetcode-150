package neetcode150;

public class TrappingRainWater {
	public static void main(String[] args) {
		int[] t1 = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
		System.out.println(trap(t1)); // 6

		int[] t2 = { 4, 2, 0, 3, 2, 5 };
		System.out.println(trap(t2)); // 9

		int[] t3 = { 0, 2, 0, 3, 1, 0, 1, 3, 2, 1 };
		System.out.println(trap(t3)); // 9
	}

	public static int trap(int[] height) {
		int leftMax = 0, rightMax = 0, total = 0;
		
		int left = 0, right = height.length - 1;
		
		while (left < right) {
			// if left is smaller
			if (height[left] <= height[right]) {
				if (leftMax > height[left]) {
					total += leftMax - height[left];
				}
				else {
					leftMax = height[left];
				}
				left++;
			}
			// if right is smaller
			else {
				if (rightMax > height[right]) {
					total += rightMax - height[right];
				}
				else {
					rightMax = height[right];
				}
				right--;
			}
		}
		
		return total;
	}
}
