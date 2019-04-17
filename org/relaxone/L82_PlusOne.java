package org.relaxone;

import java.util.Arrays;

public class L82_PlusOne {

	public static int[] plusOne(int[] digits) {
		for (int i = digits.length - 1; i >= 0; i--) {
			if (digits[i] == 9) {
				digits[i] = 0;
			} else {
				digits[i] += 1;
				return digits;
			}
		}
		int[] result = new int[digits.length + 1];
		Arrays.fill(result, 0);
		result[0] = 1;
		return result;
	}

	public static void main(String[] args) {
		int[] digits = { 9, 9, 9 };
//		int[] digits = { 9, 8, 7, 6, 5, 4, 3, 2, 1, 0 };
		System.out.println(Arrays.toString(plusOne(digits)));
	}

}
