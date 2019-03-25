package org.relaxone;

public class L30_MaxProfit {

	public int maxProfit(int[] prices) {
		int result = 0;
		if (prices == null || prices.length < 2)
			return result;
		for (int i = 0; i < prices.length; i++) {
			for (int j = i + 1; j < prices.length; j++) {
				int p = prices[j] - prices[i];
				result = p > result ? p : result;
			}
		}
		return result;
	}
	
	public int maxProfit_2(int[] prices) {
		int result = 0;
		if (prices == null || prices.length < 2)
			return result;
		int min = prices[0];
		for (int i = 0; i < prices.length; i++) {
			if(prices[i] < min)
				min = prices[i];
			else
				result = Math.max(result, prices[i]-min);
		}
		return result;
	}

	public static void main(String[] args) {
		L30_MaxProfit l30_MaxProfit = new L30_MaxProfit();
		int[] prices = {1,2,1,4,5,3,5,7};
		System.out.println(l30_MaxProfit.maxProfit_2(prices ));
	}
	
}
