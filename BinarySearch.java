package neetcode150;

public class BinarySearch {
	public static void main(String[] args) {
		int[] t1 = { -1, 0, 3, 5, 9, 12 };
		System.out.println(search(t1, 9));
		System.out.println(search(t1, 2));
	}

	public static int search(int[] nums, int target) {
		int low = 0, high = nums.length - 1;

		while (low <= high) {
			int mid = (low + high) / 2;
			if (nums[mid] == target)
				return mid;
			if (nums[mid] > target)
				high = mid - 1;
			else
				low = mid + 1;
		}
		
		return -1;
	}
}
