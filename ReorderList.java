package neetcode150;

public class ReorderList {
	public void reorderList(ListNode head) {
		
		// finding mid
		ListNode slow = head, fast = head;
		
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		
		ListNode curr = slow.next;
		slow.next = null;
		
		// reverse second part
		ListNode before = null, after = null;
		
		while (curr != null) {
			after = curr.next;
			curr.next = before;
			before = curr;
			curr = after;
		}
		
		// merge
		ListNode a = head;
		ListNode b = before;
		
		while (a != null && b != null) {
			ListNode tempA = a.next;
			ListNode tempB = b.next;
			a.next = b;
			b.next = tempA;
			a = tempA;
			b = tempB;
		}
			
	}
}
