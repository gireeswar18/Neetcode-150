package neetcode150;

public class ValidAnagram {
	public static void main(String[] args) {
		System.out.println(isAnagram("racecar", "carrace"));
		System.out.println(isAnagram("jar", "jam"));
		System.out.println(isAnagram("maths", "athmk"));
	}

	public static boolean isAnagram(String s, String t) {
		int[] freq = new int[26];
		
		if (s.length() != t.length()) return false;
		
		for (char c : s.toCharArray()) {
			freq[c - 'a']++;
		}
		
		for (char c : t.toCharArray()) {
			if (freq[c - 'a'] == 0)
				return false;
			
			freq[c - 'a']--;
		}
		
		return true;
		
	}
}
