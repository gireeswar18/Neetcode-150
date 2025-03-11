package neetcode150;

import java.util.*;

public class PalindromePartitioning {
	public static void main(String[] args) {
		System.out.println(partition("aab"));
	}

	static List<List<String>> res;

	public static void make(String s, List<String> curr, int ind) {
		if (ind == s.length()) {
			res.add(new ArrayList<>(curr));
			return;
		}

		for (int i = ind; i < s.length(); i++) {
			if (!isPalindrome(s, ind, i)) {
				continue;
			}
			curr.add(s.substring(ind, i + 1));
			make(s, curr, i + 1);
			curr.removeLast();
		}
	}

	public static List<List<String>> partition(String s) {
		res = new ArrayList<>();
		
		make(s, new ArrayList<>(), 0);
		
		return res;
	}

	public static boolean isPalindrome(String s, int l, int r) {
		while (l < r) {
			if (s.charAt(l) != s.charAt(r)) {
				return false;
			}
			l++;
			r--;
		}
		return true;
	}
}
