package neetcode150;

public class LongestSubstringWithoutRepeatingCharacters {
	public static void main(String[] args) {
		System.out.println(lengthOfLongestSubstring("abcabcbb"));
		System.out.println(lengthOfLongestSubstring("bbbbb"));
		System.out.println(lengthOfLongestSubstring("pwwkew"));
	}

	public static int lengthOfLongestSubstring(String s) {
//		Set<Character> set = new HashSet<Character>();
//		int max = 0;
//
//		int l = 0;
//		int r = 0;
//
//		while (r < s.length()) {
//			if (set.add(s.charAt(r))) {
//				max = Math.max(max, r - l + 1);
//			} 
//			else {
//				while (!set.add(s.charAt(r))) {
//					set.remove(s.charAt(l));
//					l++;
//				}
//			}
//			r++;
//		}
//
//		return max;

		int[] map = new int[128];
		char[] arr = s.toCharArray();
		int max = 0;

		int l = 0;
		for (int r = 0; r < s.length(); r++) {
			// to handle zero index
			if (map[arr[r]] != 0)
				l = Math.max(map[arr[r]], l);
			max = Math.max(max, r - l + 1);
			map[arr[r]] = r + 1;
		}
		
		return max;

	}
}
