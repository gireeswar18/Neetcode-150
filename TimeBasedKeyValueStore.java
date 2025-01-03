package neetcode150;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TimeBasedKeyValueStore {
	public static void main(String[] args) {

	}

	class TimeMap {
		
		class Pair {
			int time;
			String val;
			
			public Pair(int time, String val) {
				this.time = time;
				this.val = val;
			}
		}

		HashMap<String, List<Pair>> map;

		public TimeMap() {
			map = new HashMap<>();
		}

		public void set(String key, String value, int timestamp) {
			
			if (map.containsKey(key)) {
				map.get(key).add(new Pair(timestamp, value));
			}
			else {
				map.put(key, new ArrayList<>());
				map.get(key).add(new Pair(timestamp, value));
			}
		}

		public String get(String key, int timestamp) {
			List<Pair> list = map.get(key);
			
			if (list == null) return "";
			
			int left = 0, right = list.size() - 1;
			
			String res = "";
			
			while (left <= right) {
				int mid = (left + right) / 2;
				if (list.get(mid).time <= timestamp) {
					res = list.get(mid).val;
					left = mid + 1;
				}
				else {
					right = mid - 1;
				}
			}
			
			return res;
		}
	}
}
