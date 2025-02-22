package neetcode150;

public class DesignAddAndSearchWordDataStructures {
	static class WordDictionary {

		TrieNode root;

		class TrieNode {
			TrieNode[] children;
			boolean isEnd;

			public TrieNode() {
				children = new TrieNode[26];
			}
		}

		public WordDictionary() {
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
		
		public boolean isExist(char[] word, int ind, TrieNode curr) {
			
			if (ind == word.length) return curr.isEnd;
			
			if (word[ind] == '.') {
				
				for (TrieNode node : curr.children) {
					
					if (node != null && isExist(word, ind + 1, node)) {
						return true;
					}
				}
				return false;
			}
			else if (curr.children[word[ind] - 'a'] == null) return false;
			
			return isExist(word, ind + 1, curr.children[word[ind] - 'a']);
			
		}

		public boolean search(String word) {
			return isExist(word.toCharArray(), 0, root);
		}
	}

	public static void main(String[] args) {
		WordDictionary wordDictionary = new WordDictionary();
		wordDictionary.addWord("bad");
		wordDictionary.addWord("dad");
		wordDictionary.addWord("mad");
		System.out.println(wordDictionary.search("pad"));
		System.out.println(wordDictionary.search("bad"));
		System.out.println(wordDictionary.search(".ad"));
		System.out.println(wordDictionary.search("b.."));
	}
}
