package neetcode150;

public class BinaryTreeMaximumPathSum {

	int max = Integer.MIN_VALUE;

	public int findMax(TreeNode curr) {
		if (curr == null)
			return 0;

		int left = Math.max(0, findMax(curr.left));
		int right = Math.max(0, findMax(curr.right));

		max = Math.max(max, left + right + curr.val);

		return Math.max(left, right) + curr.val;

	}

	public int maxPathSum(TreeNode root) {
		findMax(root);
		return max;
	}
}
