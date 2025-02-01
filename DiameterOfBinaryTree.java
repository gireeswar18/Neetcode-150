package neetcode150;

public class DiameterOfBinaryTree {
	
	int max = 0;
	
	public int findMax(TreeNode curr) {
		if (curr == null) {
			return 0;
		}
		
		int lMax = findMax(curr.left);
		int rMax = findMax(curr.right);
		
		max = Math.max(max, lMax + rMax);
		
		return Math.max(lMax, rMax) + 1;
		
	}
	
	
	public int diameterOfBinaryTree(TreeNode root) {
		findMax(root);
		
		return max;
	}
}
