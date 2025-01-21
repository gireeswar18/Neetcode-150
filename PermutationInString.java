package neetcode150;

public class PermutationInString {
	public static void main(String[] args) {
		System.out.println(checkInclusion("ab", "eidbaooo"));
		System.out.println(checkInclusion("ab", "eidbooao"));
	}

	public static boolean isPresent(int[] a, int[] b) {
		for (int i = 0; i < 26; i++) {
			if (a[i] != b[i])
				return false;
		}
		return true;
	}

	public static boolean checkInclusion(String s1, String s2) {
		int[] pat = new int[26];
		int[] str = new int[26];
		char[] arr = s2.toCharArray();
		int n = s1.length();

		for (char c : s1.toCharArray()) {
			pat[c - 'a']++;
		}
		int l = 0, r = 0;

		while (r < s2.length()) {
			str[arr[r] - 'a']++;

			if (r - l + 1 == n) {
				if (isPresent(str, pat))
					return true;
				str[arr[l] - 'a']--;
				l++;

			}
			r++;
		}
		return false;
	}
}
