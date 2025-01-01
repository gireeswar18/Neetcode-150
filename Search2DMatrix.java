package neetcode150;

public class Search2DMatrix {
	public static void main(String[] args) {

		int[][] mat = { { 1, 3, 5, 7 }, { 10, 11, 16, 20 }, { 23, 30, 34, 60 } };
		System.out.println(searchMatrix(mat, 3));
		System.out.println(searchMatrix(mat, 13));
	}

	public static boolean searchMatrix(int[][] matrix, int target) {
		int m = matrix.length;
		int n = matrix[0].length;

		for (int i = 0; i < m; i++) {
			if (target >= matrix[i][0] && target <= matrix[i][n - 1]) {
				int low = 0;
				int high = n - 1;

				while (low <= high) {
					int mid = (low + high) / 2;
					if (matrix[i][mid] == target)
						return true;

					if (matrix[i][mid] > target)
						high = mid - 1;
					else
						low = mid + 1;
				}

				return false;
			}
		}
		return false;
	}
}
