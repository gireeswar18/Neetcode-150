package neetcode150;

public class ReverseLinkedList {
	public ListNode reverseListIterative(ListNode head) {
		ListNode curr = head;
		ListNode before = null;
		ListNode after = null;

		while (curr != null) {
			after = curr.next;
			curr.next = before;
			before = curr;
			curr = after;
		}
		
		return before;
	}

	public ListNode reverseListRecursive(ListNode head) {
		return reverse(head, null, null);
	}
	
	public ListNode reverse(ListNode curr, ListNode before, ListNode after) {
		if (curr == null) {
			return before;
		}
		after = curr.next;
		curr.next = before;
		before = curr;
		curr = after;
		
		return reverse(curr, before, after);
	}
}
