package neetcode150;

public class LinkedListCycle {
	public boolean hasCycle(ListNode head) {
		ListNode slow = head;
		ListNode fast = head;
		
		while (fast != null && fast.next != null) {
			if (slow == fast) return true;
			slow = slow.next;
			fast = fast.next.next;
		}
		
		return false;
	}
}
