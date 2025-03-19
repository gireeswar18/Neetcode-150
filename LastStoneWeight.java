package neetcode150;

import java.util.PriorityQueue;

public class LastStoneWeight {
	public static void main(String[] args) {
		int[] t1 = { 2, 7, 4, 1, 8, 1 };
		System.out.println(lastStoneWeight(t1));
	}

	public static int lastStoneWeight(int[] stones) {
		PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
		
		for (int i = 0; i < stones.length; i++) {
			pq.add(stones[i]);
		}
		
		while (pq.size() != 1) {
			pq.add(pq.poll() - pq.poll());
		}
		
		return pq.peek();
	}
}
