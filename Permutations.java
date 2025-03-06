package neetcode150;

import java.util.*;

public class Permutations {
	public static void main(String[] args) {
		int[] t1 = { 1, 2, 3 };
		System.out.println(permute(t1));
	}
	
	static List<List<Integer>> res;
	public static void permute(int[] nums, int ind) {
		
		if (ind == nums.length) {
			List<Integer> tmp = new ArrayList<Integer>();
			
			for (int num : nums) {
				tmp.add(num);
			}
			
			res.add(tmp);
			
			return;
		}
		
		for (int i = ind; i < nums.length; i++) {
			swap(nums, ind, i);
			permute(nums, ind + 1);
			swap(nums, ind, i);
		}
		
	}
	
	public static void swap(int[] arr, int a, int b) {
		int tmp = arr[a];
		arr[a] = arr[b];
		arr[b] = tmp;
	}
	
	public static List<List<Integer>> permute(int[] nums) {
		
		res = new ArrayList<>();
		
		permute(nums, 0);
		
		return res;
		
	}
}
