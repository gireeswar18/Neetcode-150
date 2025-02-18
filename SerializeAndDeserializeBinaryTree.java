package neetcode150;

public class SerializeAndDeserializeBinaryTree {

	int i = 1;

	public TreeNode construct(String[] arr) {
		if (arr[i].equals("N")) {
			i++;
			return null;
		}

		TreeNode node = new TreeNode(Integer.parseInt(arr[i++]));

		node.left = construct(arr);
		node.right = construct(arr);

		return node;
	}

	public StringBuilder dfs(TreeNode curr, StringBuilder res) {
		if (curr == null) {
			res.append(",N");
			return res;
		}

		res.append(',').append(curr.val);

		res = dfs(curr.left, res);
		res = dfs(curr.right, res);

		return res;
	}

	public String serialize(TreeNode root) {
		StringBuilder res = new StringBuilder();

		return dfs(root, res).toString();
	}

	public TreeNode deserialize(String data) {
		String[] arr = data.split(",");

		return construct(arr);
	}
}
