package neetcode150;

public class KokoEatingBananas {
	public static void main(String[] args) {
		int[] t1 = { 3, 6, 7, 11 };
		System.out.println(minEatingSpeed(t1, 8));

		int[] t2 = { 30, 11, 23, 4, 20 };
		System.out.println(minEatingSpeed(t2, 5));

		int[] t3 = { 30, 11, 23, 4, 20 };
		System.out.println(minEatingSpeed(t3, 6));
	}

	public static int minEatingSpeed(int[] piles, int h) {
		int n = piles.length;		
		int low = 1;
		int high = piles[0];		
		for (int i = 1; i < n; i++) {
			high = Math.max(piles[i], high);
		}		
		
		while (low <= high) {
			int mid = (low + high) / 2;
			long cnt = 0;
			for (int i = 0; i < n; i++) {
				cnt += (piles[i] / mid) + (piles[i] % mid != 0 ? 1 : 0);
			}
			
			if (cnt <= h) {
				high = mid - 1;
			}
			else {
				low = mid + 1;
			}
			
		}
		
		return low;
	}
}
