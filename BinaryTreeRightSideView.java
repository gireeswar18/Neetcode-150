package neetcode150;

import java.util.*;

public class BinaryTreeRightSideView {
	public List<Integer> rightSideView(TreeNode root) {
		Queue<TreeNode> q = new LinkedList<TreeNode>();

		List<Integer> res = new ArrayList<Integer>();

		if (root == null)
			return res;

		q.add(root);

		while (!q.isEmpty()) {
			int size = q.size();
			int last = -101;

			while (size-- != 0) {
				TreeNode curr = q.poll();
				last = curr.val;

				if (curr.left != null)
					q.add(curr.left);
				if (curr.right != null)
					q.add(curr.right);
			}

			res.add(last);
		}

		return res;
	}

	
}
