package neetcode150;

import java.util.*;

public class CombinationSum {
	public static void main(String[] args) {
		System.out.println(combinationSum(new int[] { 2, 3, 6, 7 }, 7));
	}

	static List<List<Integer>> res;

	public static void isPossible(int[] arr, List<Integer> curr, int ind, int target) {

		if (ind == arr.length) {
			if (target == 0) {
				res.add(new ArrayList<>(curr));
			}
			
			return;
		}
		
		if (target - arr[ind] >= 0) {
			curr.add(arr[ind]);
			
			isPossible(arr, curr, ind, target - arr[ind]);
			
			curr.removeLast();
		}
		
		isPossible(arr, curr, ind + 1, target);

	}

	public static List<List<Integer>> combinationSum(int[] candidates, int target) {

		res = new ArrayList<>();

		isPossible(candidates, new ArrayList<>(), 0, target);
		
		return res;
		
	}
}
