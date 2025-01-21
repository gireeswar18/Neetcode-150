package neetcode150;

import java.util.Arrays;

public class TwoSum_II {
	public static void main(String[] args) {
		int[] t1 = { 2, 7, 11, 15 };
		System.out.println(Arrays.toString(twoSum(t1, 9)));

		int[] t2 = { 2, 3, 4 };
		System.out.println(Arrays.toString(twoSum(t2, 6)));

		int[] t3 = { -1, 0 };
		System.out.println(Arrays.toString(twoSum(t3, -1)));
	}

	public static int[] twoSum(int[] numbers, int target) {
		int left = 0;
		int right = numbers.length - 1;

		while (left < right) {
			if (numbers[left] + numbers[right] == target) {
				return new int[] { left + 1, right + 1 };
			}
			if (numbers[left] + numbers[right] > target) {
				right--;
			}
			else {
				left++;
			}
		}
		
		return new int[] {};
	}
}
