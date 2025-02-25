package neetcode150;

import java.util.*;

public class Subsets {
	public static void main(String[] args) {
		System.out.println(subsets(new int[] { 1, 2, 3 }));
	}

	static List<List<Integer>> res;

	public static void makeSubset(int[] nums, int ind, List<Integer> curr) {
		if (ind == nums.length) {
			return;
		}

		curr.add(nums[ind]);
		res.add(new ArrayList<Integer>(curr));
		
		for (int i = ind + 1; i < nums.length; i++) {
			makeSubset(nums, i, curr);
		}
		
		curr.removeLast();

	}

	public static List<List<Integer>> subsets(int[] nums) {
		res = new ArrayList<>();

		for (int i = 0; i < nums.length; i++) {
			makeSubset(nums, i, new ArrayList<>());
		}
		return res;
	}
}
