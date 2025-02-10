package neetcode150;

public class ValidateBinarySearchTree {

	public boolean isValid(TreeNode curr, TreeNode min, TreeNode max) {
		if (curr == null) {
			return true;
		}

		if ((min != null && curr.val <= min.val) || (max != null && curr.val >= max.val))
			return false;

		return isValid(curr.left, min, curr) && isValid(curr.right, curr, max);
	}

	public boolean isValidBST(TreeNode root) {
		return isValid(root.left, null, root) && isValid(root.right, root, null);
	}
}
