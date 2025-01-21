package neetcode150;

import java.util.*;


public class SlidingWindowMaximum {
	public static void main(String[] args) {
		int[] t1 = { 1, 3, -1, -3, 5, 3, 6, 7 };
		System.out.println(Arrays.toString(maxSlidingWindow(t1, 3)));

		int[] t2 = { 1 };
		System.out.println(Arrays.toString(maxSlidingWindow(t2, 1)));

		int[] t3 = { 1, 2, 1, 0, 4, 2, 6 };
		System.out.println(Arrays.toString(maxSlidingWindow(t3, 3)));
	}

	public static int[] maxSlidingWindow(int[] arr, int k) {
		int n = arr.length;
		int[] res = new int[n - k + 1];
		int ind = 0;
//		PriorityQueue<Integer> q = new PriorityQueue<Integer>((a, b) -> arr[b] - arr[a]);
//		
//		int r = 0;
//		
//		while (r < k && r < n) {
//			q.add(r);
//			r++;
//		}
//		
//		res[ind++] = arr[q.peek()];
//		
//		while (r < n) {
//			while (!q.isEmpty() && q.peek() < r - k + 1) {
//				q.poll();
//			}
//			q.add(r);
//			res[ind++] = arr[q.peek()];
//			r++;
//		}

		Deque<Integer> deque = new LinkedList<Integer>();
		int l = 0, r = 0;

		while (r < n) {
			while (!deque.isEmpty() && deque.peekLast() < arr[r]) {
				deque.pollLast();
			}
			deque.addLast(arr[r]);

			if (r - l + 1 == k) {
				res[ind++] = deque.peekFirst();
				if (deque.peekFirst() == arr[l]) {
					deque.pollFirst();
				}
				l++;
			}
			r++;
		}

		return res;
	}
}
