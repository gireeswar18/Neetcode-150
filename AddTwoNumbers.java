package neetcode150;

public class AddTwoNumbers {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		int carry = 0;
		ListNode h1 = l1;
		ListNode prev = null;
		
		while (l1 != null && l2 != null) {
			prev = l1;
			int sum = l1.val + l2.val + carry;
			l1.val = sum % 10;
			carry = sum / 10;
			l1 = l1.next;
			l2 = l2.next;
		}
		
		while (l1 != null) {
			prev = l1;
			int sum = l1.val + carry;
			carry = sum / 10;
			l1.val = sum % 10;
			l1 = l1.next;
		}
		
		while (l2 != null) {
			int sum = l2.val + carry;
			carry = sum / 10;
			l2.val = sum % 10;
			prev.next = l2;
			l2 = l2.next;
			prev = prev.next;
		}
		
		if (carry != 0) {
			prev.next = new ListNode(1);
		}
		
		return h1;
	}
}
