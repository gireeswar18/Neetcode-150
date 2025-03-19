package neetcode150;

import java.util.PriorityQueue;

public class KthLargestElementInAStream {
	class KthLargest {
		PriorityQueue<Integer> pq;

		int k;

		public KthLargest(int k, int[] nums) {
			pq = new PriorityQueue<Integer>();
			this.k = k;

			for (int num : nums) {
				add(num);
			}
		}

		public int add(int val) {
			pq.add(val);
			if (pq.size() > k) {
				pq.poll();
			}
			
			return pq.peek();
		}
	}
}
