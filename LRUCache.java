package neetcode150;

public class LRUCache {
//
//	Map<Integer, Integer> map;
//	LinkedList<Integer> list;
//	int capacity;
//
//	public LRUCache(int capacity) {
//		map = new HashMap<>();
//		list = new LinkedList<Integer>();
//		this.capacity = capacity;
//	}
//
//	public int get(int key) {
//		if (!map.containsKey(key)) {
//			return -1;
//		}
//
//		list.remove(Integer.valueOf(key));
//		list.add(key);
//
//		System.out.println("CURR LIST: " + list);
//
//		return map.get(key);
//	}
//
//	public void put(int key, int value) {
//
//		if (map.containsKey(key)) {
//			list.remove(Integer.valueOf(key));
//		} else if (list.size() == capacity) {
//			map.remove(list.pollFirst());
//		}
//
//		list.add(key);
//		map.put(key, value);
//
//		System.out.println("CURR LIST: " + list);
//	}

	Node[] map;
	Node least;
	Node most;
	int size;
	int capacity;

	class Node {
		int key;
		int val;
		Node prev;
		Node next;

		public Node(int key, int val) {
			this.key = key;
			this.val = val;
		}
	}

	public LRUCache(int capacity) {
		map = new Node[10000 + 1];
		size = 0;
		this.capacity = capacity;
	}

	public int get(int key) {
		if (map[key] == null) {
			return -1;
		}

		remove(map[key]);
		add(map[key]);

		return map[key].val;
	}

	public void put(int key, int value) {
		if (map[key] != null) {
			remove(map[key]);
		} else if (size == capacity) {
			map[least.key] = null;
			removeLeast();
		}

		Node node = new Node(key, value);
		add(node);
		map[key] = node;
	}

	public void add(Node node) {
		if (size == 0) {
			least = node;
			most = node;
		} else {
			most.next = node;
			node.prev = most;
			most = node;
		}
		size++;

	}

	public void remove(Node node) {
		// one element
		if (size == 1) {
			least = null;
			most = null;
		}
		// first
		else if (node == least) {
			node.next.prev = null;
			least = least.next;
		}
		// last
		else if (node == most) {
			node.prev.next = null;
			most = most.prev;
		} 
		else {
			node.prev.next = node.next;
			node.next.prev = node.prev;
		}
		node.next = null;
		node.prev = null;

		size--;
	}

	public void removeLeast() {
		if (size == 1) {
			least = null;
			most = null;
		} else {
			least = least.next;
			least.prev = null;
		}
		size--;
	}

	public static void main(String[] args) {

		LRUCache l = new LRUCache(2); // {}
		System.out.println(l.get(2)); // -1
		l.put(2, 6); // {2:6}
		System.out.println(l.get(1)); // -1
		l.put(1, 5); // {2:6, 1:5}
		l.put(1, 2); // {2:6, 1:2}
		System.out.println(l.get(1));
		System.out.println(l.get(2));
	}
}
