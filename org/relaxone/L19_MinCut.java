package org.relaxone;

public class L19_MinCut {

	public int minCut(String s) {
		if (s.equals(""))
			return 0;

		int[] dp = new int[s.length()];
		for (int i = 0; i < s.length(); i++) {
			// 判断 0-i 子串是否是回文，若是回文则进行下一次比较，否则先将其最小回文切割设置为 i
			dp[i] = isPalindrome(s.substring(0, i + 1)) ? 0 : i;
			if (dp[i] == 0)
				continue;
			for (int j = 1; j <= i; j++) {
				if (isPalindrome(s.substring(j, i + 1)))
					dp[i] = Math.min(dp[i], dp[j - 1] + 1);
				else
					dp[i] = Math.min(dp[i], dp[j - 1] + i - j + 1);
			}
		}
		return dp[dp.length - 1];
	}

	/**
	 * a. 判断一个字符串是否是回文字符串
	 * 
	 * @param str
	 * @return
	 */
	public boolean isPalindrome(String str) {
		for (int i = 0, j = str.length() - 1; i < j; i++, j--) {
			if (str.charAt(i) != str.charAt(j))
				return false;
		}
		return true;
	}

}
