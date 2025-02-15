package neetcode150;

import java.util.*;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal {

	int ind = 0;

	public TreeNode build(int[] pre, int[] in, int l, int r, Map<Integer, Integer> map) {

		if (l > r)
			return null;

		TreeNode curr = new TreeNode(pre[ind]);

		int inInd = map.get(pre[ind]);
		ind++;

		curr.left = build(pre, in, l, inInd - 1, map);
		curr.right = build(pre, in, inInd + 1, r, map);

		return curr;
	}

	public TreeNode buildTree(int[] preorder, int[] inorder) {

		Map<Integer, Integer> map = new HashMap<>();

		for (int i = 0; i < inorder.length; i++) {
			map.put(inorder[i], i);
		}

		return build(preorder, inorder, 0, inorder.length - 1, map);
	}
}
