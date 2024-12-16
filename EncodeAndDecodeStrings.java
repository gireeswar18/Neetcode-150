package neetcode150;

import java.util.*;

public class EncodeAndDecodeStrings {

	public static void main(String[] args) {
		System.out.println(encode(Arrays.asList("neet","code","love","you")));
		System.out.println(decode("4#neet4#code4#love3#you"));
	}

	public static String encode(List<String> strs) {

		StringBuilder sb = new StringBuilder();

		for (String str : strs) {
			sb.append(str.length()).append("#").append(str);
		}

		return sb.toString();

	}

	public static List<String> decode(String str) {

		int i = 0;
		List<String> list = new ArrayList<>();

		while (i < str.length()) {
			int j = i;
			while (str.charAt(j) != '#') {
				j++;
			}
			int len = Integer.parseInt(str.substring(i, j));

			i = j + 1 + len;
			list.add(str.substring(j + 1, i));
		}

		return list;

	}
}
