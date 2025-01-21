package neetcode150;

public class RemoveNthNodeFromEndOfList {

	public ListNode removeNthFromEnd(ListNode head, int n) {

		ListNode rem = head;
		ListNode last = head;

		for (int i = 0; i < n; i++) {
			last = last.next;
		}

		ListNode prev = null;
		while (last != null) {
			prev = rem;
			rem = rem.next;
			last = last.next;
		}

		if (rem == head) {
			head = head.next;
		} else {
			prev.next = rem.next;
		}
		rem.next = null;

		return head;
	}

}
