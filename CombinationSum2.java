package neetcode150;

import java.util.*;

public class CombinationSum2 {
	public static void main(String[] args) {
		System.out.println(combinationSum2(new int[] { 10, 1, 2, 7, 6, 1, 5 }, 8));
	}

	static List<List<Integer>> res;

	public static void make(int[] arr, int ind, int target, List<Integer> curr) {
		if (target == 0) {
			res.add(new ArrayList<Integer>(curr));
			return;
		}

		for (int i = ind; i < arr.length; i++) {

			if (i != ind && arr[i] == arr[i - 1]) {
				continue;
			}

			if (arr[i] > target) {
				break;
			}
			curr.add(arr[i]);
			make(arr, i + 1, target - arr[i], curr);

			curr.removeLast();
		}

	}

	public static List<List<Integer>> combinationSum2(int[] arr, int target) {
		res = new ArrayList<>();

		Arrays.sort(arr);

		// 1 1 2 5 6 7 10

		make(arr, 0, target, new ArrayList<>());

		return res;
	}
}
