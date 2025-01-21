package neetcode150;

import java.util.*;

public class LongestConsecutiveSequence {
	public static void main(String[] args) {
		int[] t1 = { 100, 4, 200, 1, 3, 2 };
		System.out.println(longestConsecutive(t1));

		int[] t2 = { 0, 3, 7, 2, 5, 8, 4, 6, 0, 1 };
		System.out.println(longestConsecutive(t2));
	}

	public static int longestConsecutive(int[] nums) {
		Set<Integer> visited = new HashSet<>();
		Set<Integer> elements = new HashSet<>();

		for (int num : nums)
			elements.add(num);

		int max = 0;

		for (int num : nums) {
			if (visited.contains(num))
				continue;

			visited.add(num);
			int seq = 1;
			int preNum = num - 1;

			while (elements.contains(preNum) && visited.add(preNum)) {
				preNum--;
				seq++;
			}
			
			int nextNum = num + 1;
			while (elements.contains(nextNum) && visited.add(nextNum)) {
				nextNum++;
				seq++;
			}

			max = Math.max(max, seq);
		}

		return max;
	}
}
