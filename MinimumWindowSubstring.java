package neetcode150;

public class MinimumWindowSubstring {
	public static void main(String[] args) {
		System.out.println(minWindow("ADOBECODEBANC", "ABC"));
		System.out.println(minWindow("a", "a"));
		System.out.println(minWindow("a", "aa"));
	}

	public static String minWindow(String s, String t) {
		int[] map = new int[128];
		for (char c : t.toCharArray()) {
			map[c]++;
		}

		int l = 0, r = 0;
		int minLen = Integer.MAX_VALUE;
		int stInd = -1;
		int cnt = 0;
		char[] str = s.toCharArray();

		while (r < s.length()) {
			if (map[str[r]] > 0) {
				cnt++;
			}
			map[str[r]]--;
			while (cnt == t.length()) {
				if (r - l + 1 < minLen) {
					minLen = r - l + 1;
					stInd = l;
				}
				map[str[l]]++;
				if (map[str[l]] > 0) {
					cnt--;
				}
				l++;
			}
			r++;
		}

		return stInd == -1 ? "" : s.substring(stInd, stInd + minLen);
	}
}
