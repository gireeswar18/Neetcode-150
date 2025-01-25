package neetcode150;

public class ReverseNodesInKGroup {
	
	public ListNode[] reverse(ListNode curr, int k) {
		ListNode after, before = null;
		
		while (k-- != 0) {
			after = curr.next;
			curr.next = before;
			before = curr;
			curr = after;
		}
		
		return new ListNode[] {before, curr};
	}
	
	public ListNode reverseKGroup(ListNode head, int k) {
		ListNode t = head;
		int size = 0;
		while (t != null) {
			t = t.next;
			size++;
		}
		ListNode tail = null;
		ListNode curr = head;
		ListNode newHead = null;
		boolean found = false;
		
		while (size >= k) {
			ListNode newTail = curr;
			
			ListNode[] bef_curr = reverse(curr, k);
			ListNode revHead = bef_curr[0];
			curr = bef_curr[1];
			
			size -= k;
			
			if (!found) {
				newHead = revHead;
				found = true;
			}
			
			if (tail != null) {
				tail.next = revHead;
			}
			tail = newTail;
			
		}
		
		if (curr != null) {
			tail.next = curr;
		}
		
		return newHead;
	}
}
