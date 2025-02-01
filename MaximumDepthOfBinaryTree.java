package neetcode150;

public class MaximumDepthOfBinaryTree {
	
	public int findDepth(TreeNode curr, int h) {
		if (curr == null) return h - 1; 
		
		return Math.max(findDepth(curr.left, h + 1), findDepth(curr.right, h + 1));
		
	}
	
	public int maxDepth(TreeNode root) {
		return findDepth(root, 1);
	}
}
