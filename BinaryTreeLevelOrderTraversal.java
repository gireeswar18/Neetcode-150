package neetcode150;

import java.util.*;

public class BinaryTreeLevelOrderTraversal {
	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> res = new ArrayList<>();
		
		if (root == null) return res;
		
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.add(root);
		
		while (!q.isEmpty()) {
			int size = q.size();
			List<Integer> list = new ArrayList<Integer>();
			
			while (size-- != 0) {
				TreeNode curr = q.poll();
				list.add(curr.val);
				
				if (curr.left != null) q.add(curr.left);
				if (curr.right != null) q.add(curr.right);
			}
			
			res.add(list);
			
		}
		
		return res;
		
	}
}
