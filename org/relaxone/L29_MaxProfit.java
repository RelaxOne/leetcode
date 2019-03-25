package org.relaxone;

public class L29_MaxProfit {

	public int maxProfit(int[] prices) {
		int result = 0;
		if (prices == null || prices.length < 2)
			return result;
		for (int i = 1; i < prices.length; i++) {
			if(prices[i] > prices[i-1])
				result += prices[i] - prices[i-1];
		}
		return result;
	}


	public static void main(String[] args) {
		L29_MaxProfit l29_MaxProfit = new L29_MaxProfit();
		int[] prices = {1,2,1,4,5,3,5,7};
		System.out.println(l29_MaxProfit.maxProfit(prices ));
	}
	
}
