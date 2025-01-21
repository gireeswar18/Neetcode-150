package neetcode150;

public class LongestRepeatingCharacterReplacement {
	public static void main(String[] args) {
		System.out.println(characterReplacement("ABAB", 2));
		System.out.println(characterReplacement("AABABBA", 1));
	}

	public static int characterReplacement(String s, int k) {
		int l = 0;
		int r = 0;
		int[] freq = new int[26];
		int maxLen = 0, maxFreq = 0;
		char[] arr = s.toCharArray();
		
		while (r < arr.length) {
			freq[arr[r] - 'A']++;
			maxFreq = Math.max(maxFreq, freq[arr[r] - 'A']);
			
			while (r - l + 1 - maxFreq > k) {
				freq[arr[l] - 'A']--;
				l++;
			}
			
			maxLen = Math.max(maxLen, r - l + 1);
			r++;
		}
		
		return maxLen;
	}
}
