package neetcode150;

import java.util.*;

public class Subsets_II {
	public static void main(String[] args) {
		int[] t1 = { 1, 2, 2 };
		System.out.println(subsetsWithDup(t1));
	}

	static List<List<Integer>> res;

	public static void make(int[] arr, int ind, List<Integer> curr) {

		res.add(new ArrayList<>(curr));

		for (int i = ind; i < arr.length; i++) {
			if (i != ind && arr[i] == arr[i - 1])
				continue;

			curr.add(arr[i]);
			make(arr, i + 1, curr);
			curr.removeLast();
		}

	}

	public static List<List<Integer>> subsetsWithDup(int[] nums) {
		Arrays.sort(nums);
		res = new ArrayList<List<Integer>>();

		make(nums, 0, new ArrayList<Integer>());

		return res;

	}
}
