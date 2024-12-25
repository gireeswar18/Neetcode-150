package neetcode150;

import java.util.*;

public class ThreeSum {
	public static void main(String[] args) {
		int[] t1 = { -1, 0, 1, 2, -1, -4 };
		System.out.println(threeSum(t1));

		int[] t2 = { 0, 1, 1 };
		System.out.println(threeSum(t2));

		int[] t3 = { 0, 0, 0 };
		System.out.println(threeSum(t3));

		int[] t4 = { 0, 0, 0, 0 };
		System.out.println(threeSum(t4));
	}

	public static List<List<Integer>> threeSum(int[] nums) {
		Arrays.sort(nums);
		int n = nums.length;
		List<List<Integer>> res = new ArrayList<>();

		for (int i = 0; i < n - 2; i++) {
			int curr = nums[i];
			int left = i + 1;
			int right = n - 1;

			if (i != 0 && curr == nums[i - 1])
				continue;

			while (left < right) {
				if (nums[i] + nums[left] + nums[right] == 0) {
					res.add(Arrays.asList(nums[i], nums[left], nums[right]));
					left++;
					right--;

                    while (left < right && nums[left] == nums[left - 1]) {
                        left++;
                    }
                    continue;
				}

				if (nums[i] + nums[left] + nums[right] > 0) {
					right--;
				} else {
					left++;
				}
			}
		}
		return res;
	}
}
