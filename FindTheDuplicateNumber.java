package neetcode150;

public class FindTheDuplicateNumber {
	public static void main(String[] args) {
		int[] t1 = { 1, 3, 4, 2, 2 };
		System.out.println(findDuplicate(t1));

		int[] t2 = { 3, 1, 3, 4, 2 };
		System.out.println(findDuplicate(t2));

		int[] t3 = { 3, 3, 3, 3, 3 };
		System.out.println(findDuplicate(t3));
	}

	public static int findDuplicate(int[] nums) {
//		int n = nums.length;
//		
//		for (int i = 0; i < n; i++) {
//			int ind = Math.abs(nums[i]);
//			if (nums[ind] < 0) {
//				return ind;
//			}
//			else {
//				nums[ind] *= -1;
//			}
//		}
		
		for (int num : nums) {
			int ind = Math.abs(num);
			if (nums[ind] < 0) {
				return ind;
			}
			else {
				nums[ind] *= -1;
			}
		}
		
		return -1;
	}
}
