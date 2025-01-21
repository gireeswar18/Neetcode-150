package neetcode150;

public class ValidPalindrome {
	public static void main(String[] args) {
		System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
		System.out.println(isPalindrome("race a car"));
	}

	public static boolean isPalindrome(String s) {
		char[] str = s.toCharArray();
		

		int l = 0, r = str.length - 1; // not a num or char -> move

		while (l < r) {
			if (!((str[l] >= '0' && str[l] <= '9') || (str[l] >= 'a' && str[l] <= 'z')
					|| (str[l] >= 'A' && str[l] <= 'Z'))) {
				l++;
				continue;
			}
			if (!((str[r] >= '0' && str[r] <= '9') || (str[r] >= 'a' && str[r] <= 'z')
					|| (str[r] >= 'A' && str[r] <= 'Z'))) {
				r--;
				continue;
			}
			
			if (str[l] >= 'A' && str[l] <= 'Z') {
				str[l] = (char) (str[l] + 32);
			}
			if (str[r] >= 'A' && str[r] <= 'Z') {
				str[r] = (char) (str[r] + 32);
			}
			
			if (str[l] != str[r]) return false;
			l++;
			r--;
		}

		return true;
	}
}
