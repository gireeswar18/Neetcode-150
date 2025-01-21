package neetcode150;

public class FindMinimumInRotatedSortedArray {
	public static void main(String[] args) {

		int[] t1 = { 3, 4, 5, 1, 2 };
		System.out.println(findMin(t1));

		int[] t2 = { 4, 5, 6, 7, 0, 1, 2 };
		System.out.println(findMin(t2));

		int[] t3 = { 11, 13, 15, 17 };
		System.out.println(findMin(t3));

	}

	public static int findMin(int[] nums) {
		int low = 0;
		int high = nums.length - 1;
		
		while (low < high) {
			int mid = (low + high) / 2;
			
			if (nums[mid] > nums[high]) {
				low = mid + 1;
			}
			else {
				high = mid;
			}
		}
		
		return nums[low];
	}
}
