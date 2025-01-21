package neetcode150;

import java.util.*;

public class ContainsDuplicate {
	public static void main(String[] args) {
		System.out.println(containsDuplicate(new int[] { 1, 2, 3, 3 }));
		System.out.println(containsDuplicate(new int[] { 1, 2, 3, 4 }));
	}

	public static boolean containsDuplicate(int[] nums) {
		Set<Integer> set = new HashSet<>();
		for (int num : nums) {
			if (!set.add(num))
				return true;
		}
		return false;
	}
}
