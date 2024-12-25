package neetcode150;

public class ContainerWithMostWater {
	public static void main(String[] args) {
		int[] t1 = { 1, 8, 6, 2, 5, 4, 8, 3, 7 };
		System.out.println(maxArea(t1));
	}

	public static int maxArea(int[] height) {
		int low = 0;
		int high = height.length - 1;
		int max = 0;
		
		while (low < high) {
			int currHeight = Math.min(height[low], height[high]);
			max = Math.max(max, (high - low) * currHeight);
			
			while (low < high && height[low] <= currHeight) {
				low++;
			}
			
			while (low < high && height[high] <= currHeight) {
				high--;
			}
			
		}
		
		return max;
	}
}
