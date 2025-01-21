package neetcode150;

import java.util.*;

public class ProductOfArrayExceptSelf {
	public static void main(String[] args) {
		int[] t1 = { 1, 2, 3, 4 };
		
		System.out.println(Arrays.toString(productExceptSelf(t1)));
	}

	public static int[] productExceptSelf(int[] nums) {
		int n = nums.length;
		int[] res = new int[n];
		
		int leftProduct = 1;
		
		for (int i = 0; i < n; i++) {
			res[i] = leftProduct;
			leftProduct *= nums[i];
		}
		
		int rightProduct = 1;
		
		for (int i = n - 1; i >= 0; i--) {
			res[i] *= rightProduct;
			rightProduct *= nums[i];
		}
		
		return res;
	}
}
