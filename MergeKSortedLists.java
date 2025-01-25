package neetcode150;

import java.util.PriorityQueue;

public class MergeKSortedLists {
	public ListNode mergeKLists(ListNode[] lists) {
		PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>((a, b) -> a.val - b.val);

		for (ListNode head : lists) {
			while (head != null) {
				ListNode temp = head;
				pq.add(head);
				head = head.next;
				temp.next = null;
			}
		}

		ListNode dummy = new ListNode(-1);
		ListNode curr = dummy;

		while (!pq.isEmpty()) {
			curr.next = pq.poll();
			curr = curr.next;
		}
		
		return dummy.next;
	}
}
