package org.relaxone;

import java.util.Arrays;

public class L23_LongestConsecutive {

	public int longestConsecutive(int[] num) {
		if (num == null || num.length <= 0)
			return 0;
		Arrays.sort(num);
		if (num.length == 1)
			return 1;
		int length = 0;
		int cur = 1;
		for (int i = 1; i < num.length; i++) {
			if (num[i] == num[i - 1])
				continue;
			if (num[i] == num[i - 1] + 1) {
				cur++;
			} else {
				length = (length > cur) ? length : cur;
				cur = 1;
			}
		}
		return (length > cur) ? length : cur;
	}

	public static void main(String[] args) {
		int[] num = {9,1,4,7,3,-1,0,5,8,-1,6};
		L23_LongestConsecutive consecutive = new L23_LongestConsecutive();

		System.out.println(consecutive.longestConsecutive(num));

	}

}
