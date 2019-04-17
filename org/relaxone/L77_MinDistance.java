package org.relaxone;

public class L77_MinDistance {

	public int minDistance(String word1, String word2) {
		if (word1 == null && word2 == null)
			return 0;
		if (word1 == null)
			return word2.length();
		if (word2 == null)
			return word1.length();

		int[][] dp = new int[word1.length() + 1][word2.length() + 1];
		dp[0][0] = 0;

		for (int i = 0; i < word1.length(); i++)
			dp[i + 1][0] = i + 1;
		for (int i = 0; i < word2.length(); i++)
			dp[0][i + 1] = i + 1;

		for (int i = 0; i < word1.length(); i++) {
			for (int j = 0; j < word2.length(); j++) {
				if (word1.charAt(i) == word2.charAt(j))
					dp[i + 1][j + 1] = dp[i][j];
				else
					dp[i + 1][j + 1] = Math.min(Math.min(dp[i][j + 1], dp[i + 1][j]), dp[i][j]) + 1;
			}
		}
		return dp[word1.length()][word2.length()];
	}
	
	public static void main(String[] args) {
		String word1 = "mainshi";
		String word2 = "mtaith";
		L77_MinDistance distance = new L77_MinDistance();
		System.out.println(distance.minDistance(word1, word2));
	}
}
