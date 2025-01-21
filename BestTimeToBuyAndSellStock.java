package neetcode150;

public class BestTimeToBuyAndSellStock {
	public static void main(String[] args) {
		int[] t1 = { 7, 1, 5, 3, 6, 4 };
		System.out.println(maxProfit(t1));

		int[] t2 = { 7, 6, 4, 3, 1 };
		System.out.println(maxProfit(t2));
	}

	public static int maxProfit(int[] prices) {
		int minBuy = Integer.MAX_VALUE;
		int maxProfit = 0;
		
		for (int i = 0; i < prices.length; i++) {
			minBuy = Math.min(minBuy, prices[i]);
			maxProfit = Math.max(maxProfit, prices[i] - minBuy);
		}
		
		return maxProfit;
	}

}
