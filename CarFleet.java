package neetcode150;

public class CarFleet {
	public static void main(String[] args) {
		System.out.println(carFleet(12, new int[] { 10, 8, 0, 5, 3 }, new int[] { 2, 4, 1, 1, 3 }));
		System.out.println(carFleet(10, new int[] { 3 }, new int[] { 3 }));
	}

	public static int carFleet(int target, int[] position, int[] speed) {
		
		int fleets = 0;
		double maxTime = 0;
		int n = position.length;
		
		double[] times = new double[target];
		for (int i = 0; i < n; i++) {
			times[position[i]] = (double) (target - position[i]) / speed[i];
		}
		
		
		for (int i = target - 1; i >= 0; i--) {
			
			if (times[i] > maxTime) {
				fleets++;
				maxTime = times[i];
			}
			
		}
		
		return fleets;
		
	}
}
