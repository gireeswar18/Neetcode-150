package neetcode150;

public class BalancedBinaryTree {
	
	public int findHeight(TreeNode curr) {
		if (curr == null) return 0;
		
		int left = findHeight(curr.left);
		int right = findHeight(curr.right);
		
		if (Math.abs(left - right) > 1 || left == -1 || right == -1) 
			return -1;
		
		return Math.max(left, right) + 1;
	}
	
	public boolean isBalanced(TreeNode root) {
		return findHeight(root) != -1;
	}
}
