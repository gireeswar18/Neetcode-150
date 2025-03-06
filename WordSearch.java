package neetcode150;

public class WordSearch {
	public static void main(String[] args) {
		char[][] array = { { 'A', 'B', 'C', 'E' }, { 'S', 'F', 'C', 'S' }, { 'A', 'D', 'E', 'E' } };
		System.out.println(exist(array, "ABCCED"));
	}

	public static boolean dfs(char[][] board, String word, int ind, int r, int c) {
		if (ind == word.length()) {
			return true;
		}
		if (r < 0 || c < 0 || r == board.length || c == board[0].length || board[r][c] != word.charAt(ind)) {
			return false;
		}

		board[r][c] = '*';

		boolean res = dfs(board, word, ind + 1, r + 1, c) || dfs(board, word, ind + 1, r - 1, c)
				|| dfs(board, word, ind + 1, r, c + 1) || dfs(board, word, ind + 1, r, c - 1);

		board[r][c] = word.charAt(ind);
		
		return res;

	}

	public static boolean exist(char[][] board, String word) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length;j++) {				
				if (dfs(board, word, 0, i, j))
					return true;
			}
		}
		
		return false;
	}
}















