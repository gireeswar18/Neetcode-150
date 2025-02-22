package neetcode150;

import java.util.*;

import neetcode150.WordSearch_II.Trie.TrieNode;

public class WordSearch_II {
	public static void main(String[] args) {

		char[][] t1 = { { 'o', 'a', 'a', 'n' }, { 'e', 't', 'a', 'e' }, { 'i', 'h', 'k', 'r' },
				{ 'i', 'f', 'l', 'v' } };
		String[] words = { "oath", "pea", "eat", "rain" };

		System.out.println(findWords(t1, words));

	}
	
	static class Trie {
		TrieNode root;
		
		class TrieNode {
			TrieNode[] children;
			boolean isEnd;
			public TrieNode() {
				children = new TrieNode[26];
			}
		}
		
		public Trie() {
			root = new TrieNode();
		}
		
		public void addWord(String word) {
			TrieNode curr = root;
			
			for (char c : word.toCharArray()) {
				if (curr.children[c - 'a'] == null) {
					curr.children[c - 'a'] = new TrieNode();
				}
				curr = curr.children[c - 'a'];
			}
			
			curr.isEnd = true;
		}
	}
	
	static Set<String> res;
	
	public static void dfs(char[][] board, int r, int c, TrieNode curr, String word, Set<String> vis) {
		
		int ROWS = board.length;
		int COLS = board[0].length;
		
		
		if (r < 0 || c < 0 || r == ROWS || c == COLS) return;
		char val = board[r][c];
		if (curr.children[val - 'a'] == null) return;
		
		StringBuilder visKey = new StringBuilder();
		visKey.append(r).append(' ').append(c);
		
		if (vis.contains(visKey.toString())) return;
		
		vis.add(visKey.toString());
		
		curr = curr.children[val - 'a'];
		word += board[r][c];
		
		if (curr.isEnd) {
			res.add(word);
		}
		
		dfs(board, r - 1, c, curr, word, vis);
		dfs(board, r + 1, c, curr, word, vis);
		dfs(board, r, c - 1, curr, word, vis);
		dfs(board, r, c + 1, curr, word, vis);
		
		vis.remove(visKey.toString());
	}

	public static List<String> findWords(char[][] board, String[] words) {
		 res = new HashSet<>();
		
		Trie trie = new Trie();
		for (String word : words) trie.addWord(word);

		Set<String> vis = new HashSet<>();
		
		int ROWS = board.length;
		int COLS = board[0].length;
		
		for (int i = 0; i < ROWS; i++) {
			for (int j = 0; j < COLS; j++) {
				dfs(board, i, j, trie.root, "", vis);
			}
		}
		
		return new ArrayList<String>(res);
	}
}
