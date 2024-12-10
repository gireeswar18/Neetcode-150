package neetcode150;

import java.util.*;

public class GroupAnagrams {
	public static void main(String[] args) {
		String[] t1 = { "eat", "tea", "tan", "ate", "nat", "bat" };
		String[] t2 = { "" };
		String[] t3 = { "a" };

		System.out.println(groupAnagrams(t1));
		System.out.println(groupAnagrams(t2));
		System.out.println(groupAnagrams(t3));
	}

	public static List<List<String>> groupAnagrams(String[] strs) {
		Map<String, List<String>> map = new HashMap<String, List<String>>();
		
		for (String str : strs) {
			char[] word = str.toCharArray();
			Arrays.sort(word);
			
			String sortedWord = String.valueOf(word);
			List<String> words;
			if (map.containsKey(sortedWord)) {
				words = map.get(sortedWord);
			}
			else {
				words = new ArrayList<String>();
			}
			words.add(str);
			map.put(sortedWord, words);
		}
		
		List<List<String>> res = new ArrayList<List<String>>();
		
		for (List<String> list : map.values()) {
			res.add(list);
		}
		
		return res;
	}
}
