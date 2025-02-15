package neetcode150;

public class KthSmallestInABST {
	int res = -1;
	public void inorder(TreeNode curr, int[] k) {
		if (curr == null || res != -1)
			return;
		if (curr.left == null && curr.right == null) {
			k[0]--;
			if (k[0] == 0) res = curr.val;
			return;
		}

		inorder(curr.left, k);

		k[0]--;
		if (k[0] == 0) {
			res = curr.val;
			return;
		}

		inorder(curr.right, k);
	}

	public int kthSmallest(TreeNode root, int k) {
		int[] arr = new int[1];
		arr[0] = k;
		inorder(root, arr);
		return res;
	}
}
