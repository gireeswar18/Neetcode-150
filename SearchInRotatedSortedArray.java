package neetcode150;

public class SearchInRotatedSortedArray {
	public static void main(String[] args) {
		int[] t1 = { 3, 4, 5, 1, 2 };
		System.out.println(search(t1, 1));

		int[] t2 = { 4, 5, 6, 7, 0, 1, 2 };
		System.out.println(search(t2, 0));

		int[] t3 = { 11, 13, 15, 17 };
		System.out.println(search(t3, 8));
	}

	public static int search(int[] nums, int target) {
		int low = 0;
		int high = nums.length - 1;
		
		while (low <= high) {
			int mid = (low + high) / 2;
			if (nums[mid] == target)
				return mid;
			
			if (nums[mid] < nums[high]) {
				if (target > nums[mid] && target <= nums[high]) {
					low = mid + 1;
				}
				else {
					high = mid - 1;
				}
			}
			else {
				if (target >= nums[low] && target < nums[mid]) {
					high = mid - 1;
				}
				else {
					low = mid + 1;
				}
			}
		}
		return -1;
	}
}
