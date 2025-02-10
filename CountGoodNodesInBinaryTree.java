package neetcode150;

public class CountGoodNodesInBinaryTree {
	
	public int count(TreeNode curr, int max, int cnt) {
		if (curr == null) return cnt;
		
		if (curr.val >= max) {
			cnt++;
		}
		max = Math.max(max, curr.val);
		
		cnt = count(curr.left, max, cnt);
		cnt = count(curr.right, max, cnt);
		
		return cnt;
	}
	
	public int goodNodes(TreeNode root) {
		return count(root, Integer.MIN_VALUE, 0);
	}
}
