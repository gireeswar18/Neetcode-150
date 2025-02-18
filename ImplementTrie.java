package neetcode150;

public class ImplementTrie {
	static class Trie {
		
		TrieNode root;
		
		class TrieNode {
			TrieNode[] nodes;
			boolean isEnd;
			
			public TrieNode() {
				nodes = new TrieNode[26];
			}
		}
		
		public Trie() {
			root = new TrieNode();
		}

		public void insert(String word) {
			
			TrieNode curr = root;
			
			for (char c : word.toCharArray()) {
				
				if (curr.nodes[c - 'a'] == null)
					curr.nodes[c - 'a'] = new TrieNode();
				
				curr = curr.nodes[c - 'a'];
			}
			
			curr.isEnd = true;
		}

		public boolean search(String word) {
			TrieNode curr = root;
			
			for (char c : word.toCharArray()) {
				if (curr.nodes[c - 'a'] == null) return false;
				
				curr = curr.nodes[c - 'a'];
			}
			
			return curr.isEnd;
			
		}

		public boolean startsWith(String prefix) {
			TrieNode curr = root;
			
			for (char c : prefix.toCharArray()) {
				if (curr.nodes[c - 'a'] == null) return false;
				
				curr = curr.nodes[c - 'a'];
			}
			
			return true;
		}
	}

	public static void main(String[] args) {
		Trie trie = new Trie();
		trie.insert("apple");
		System.out.println(trie.search("apple")); // return True
		System.out.println(trie.search("app")); // return False
		System.out.println(trie.startsWith("app")); // return True
		trie.insert("app");
		System.out.println(trie.search("app"));
	}
}
