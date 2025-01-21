package neetcode150;

import java.util.*;

public class CopyListWithRandomPointer {
	class Node {
		int val;
		Node next;
		Node random;

		public Node(int val) {
			this.val = val;
			this.next = null;
			this.random = null;
		}
	}

	public Node copyRandomList(Node head) {
		Node dummy = new Node(-1);
		Node curr = dummy;
		Node i = head;
		
		Map<Node, Node> map = new HashMap<>();
		while (i != null) {
			map.putIfAbsent(i, new Node(i.val));
			i = i.next;
		}
		
		i = head;
		while (i != null) {
			curr.next = map.get(i);
			curr = curr.next;
			
			if (i.next != null) {
				curr.next = map.get(i.next);
			}
			if (i.random != null) {
				curr.random = map.get(i.random);
			}
			
			i = i.next;
		}
		
		return dummy.next;
		
	}
}
