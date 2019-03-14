package org.relaxone;

public class L14_SingleNumber {

	public int singleNumber(int[] A) {
		int ones = 0;
		int twos = 0;
		int threes = 0;
		for (int i = 0; i < A.length; i++) {
			int t = A[i];
			twos = twos | (ones & t); // 查看哪些位出现了两次
			ones = ones ^ t; // 记录哪些位出现了一次
			threes = ones & twos;
			twos = twos & ~threes; // 抹掉出现了三次的位
			ones = ones & ~threes; // 抹掉出现了三次的位
		}
		return ones;
	}

	public static void main(String[] args) {
		int[] A = { 1, 1, 1, 8, 5, 5, 5, 6, 4, 6, 6, 4, 4 };
		L14_SingleNumber l14_SingleNumber = new L14_SingleNumber();
		System.out.println(l14_SingleNumber.singleNumber(A));
	}

}
