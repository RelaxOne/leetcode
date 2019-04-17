package org.relaxone;

public class L79_ClimbStairs {

	public int climbStairs(int n) {
		if (n == 1)
			return n;
		int m = 0;
		int result = 1;
		for (int i = 0; i < n; i++) {
			result += m;
			m = result - m;
		}
		return result;
	}

	public static void main(String[] args) {
		L79_ClimbStairs climbStairs = new L79_ClimbStairs();
		System.out.println(climbStairs.climbStairs(3));
	}

}
