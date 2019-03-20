package org.relaxone;

public class L28_MaxProfit {

	public int max_profit(int[] prices) {
		int result = 0;
		if (prices == null || prices.length < 2)
			return result;
		for (int i = 0; i < prices.length; i++) {
			// 第一次交易的利润
			int maxProfit_left = 0;
			for (int j = 0; j < i; j++) {
				for (int k = j + 1; k < i; k++) {
					if (prices[k] - prices[j] > maxProfit_left)
						maxProfit_left = prices[k] - prices[j];
				}
			}
			// 第二次交易的利润
			int maxProfit_right = 0;
			for (int j = i; j < prices.length; j++) {
				for (int k = j + 1; k < prices.length; k++) {
					if (prices[k] - prices[j] > maxProfit_right)
						maxProfit_right = prices[k] - prices[j];
				}
			}
			result = (maxProfit_right + maxProfit_left) > result ? (maxProfit_right + maxProfit_left) : result;
		}

		return result;
	}

	public static void main(String[] args) {
		L28_MaxProfit l28_MaxProfit = new L28_MaxProfit();
		int[] prices = { 1, 2, 4 };
		System.out.println(l28_MaxProfit.max_profit(prices));
	}

}
