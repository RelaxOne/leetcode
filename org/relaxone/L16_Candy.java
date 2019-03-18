package org.relaxone;

import java.util.Arrays;

public class L16_Candy {

	public int candy(int[] ratings) {
		if (ratings.length == 0 || ratings == null)
			return 0;
		// 先给每个孩子分一颗糖
		int[] count = new int[ratings.length];
		Arrays.fill(count, 1);
		for (int i = 1; i < ratings.length; i++) {
			if (ratings[i] > ratings[i - 1])
				count[i] = count[i - 1] + 1;
		}
		int sum = 0;
		for (int i = ratings.length - 1; i > 0; i--) {
			sum += count[i];
			if (ratings[i] < ratings[i - 1] && count[i] >= count[i - 1]) {
				count[i - 1] = count[i] + 1;
			}
		}
		return sum + count[0];
	}

	public static void main(String[] args) {
		int[] ratings = {2,3,2};
		L16_Candy candy = new L16_Candy();
		System.out.println(candy.candy(ratings));
	}
	
}
