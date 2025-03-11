package neetcode150;

import java.util.*;

public class LetterCombinationsOfAPhoneNumber {
	public static void main(String[] args) {
		System.out.println(letterCombinations("23"));
	}

	static List<String> res;

	public static void helper(int ind, String digits, StringBuilder curr, Map<Character, String> map) {
		if (ind == digits.length()) {
			res.add(curr.toString());
			return;
		}

		String word = map.get(digits.charAt(ind));

		for (int i = 0; i < word.length(); i++) {
			curr.append(word.charAt(i));
			helper(ind + 1, digits, curr, map);
			curr.deleteCharAt(ind);
		}
	}

	public static List<String> letterCombinations(String digits) {
		res = new ArrayList<>();

		if (digits.length() == 0)
			return res;

		Map<Character, String> map = new HashMap<>();
		map.put('2', "abc");
		map.put('3', "def");
		map.put('4', "ghi");
		map.put('5', "jkl");
		map.put('6', "mno");
		map.put('7', "pqrs");
		map.put('8', "tuv");
		map.put('9', "wxyz");

		helper(0, digits, new StringBuilder(), map);

		return res;
	}
}
