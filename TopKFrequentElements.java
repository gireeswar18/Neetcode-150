package neetcode150;

import java.util.*;

public class TopKFrequentElements {
	public static void main(String[] args) {
		int[] t1 = { 1, 2, 2, 3, 3, 3 };
		System.out.println(Arrays.toString(topKFrequent2(t1, 2)));

		int[] t2 = { 7, 7 };
		System.out.println(Arrays.toString(topKFrequent2(t2, 1)));
	}

	public static int[] topKFrequent(int[] nums, int k) {

		// storing freq -> n
		Map<Integer, Integer> freq = new HashMap<Integer, Integer>();
		for (int num : nums) {
			freq.put(num, freq.getOrDefault(num, 0) + 1);
		}

		// Storing in heap -> n log n
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>((a, b) -> freq.get(b) - freq.get(a));
		for (int num : freq.keySet()) {
			pq.add(num);
		}

		// storing res -> k log n
		int[] res = new int[k];
		for (int i = 0; i < k; i++) {
			res[i] = pq.poll();
		}

		return res;

	}

	public static int[] topKFrequent2(int[] nums, int k) {

		// storing freq -> n
		Map<Integer, Integer> freq = new HashMap<Integer, Integer>();
		for (int num : nums) {
			freq.put(num, freq.getOrDefault(num, 0) + 1);
		}
		
		// creating bucket -> n
		List<List<Integer>> bucket = new ArrayList<>();
		for (int i = 0; i < nums.length + 1; i++) {
			bucket.add(new ArrayList<>());
		}
		
		// storing in bucket -> n
		for (int num : freq.keySet()) {
			bucket.get(freq.get(num)).add(num);
		}
		
		// storing in res -> n
		int[] res = new int[k];
		int ind = 0;
		for (int i = nums.length; i >= 0 && k != 0; i--) {
			if (!bucket.get(i).isEmpty()) {
				for (int val : bucket.get(i)) {
					res[ind++] = val;
					k--;
				}
			}
		}

		return res;
	}
}
