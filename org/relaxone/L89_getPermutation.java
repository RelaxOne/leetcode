package org.relaxone;

import java.util.ArrayList;
import java.util.Arrays;

public class L89_getPermutation {

	public String getPermutation(int n, int k) {
		char[] array = new char[n];
		for (int i = 0; i < n; i++) {
			array[i] = (char) ('1' + i);
		}
		ArrayList<String> result = new ArrayList<String>();
		handle(array, 0, result);
		System.out.println(result);
		return result.get(k - 1);
	}

	public void handle(char[] array, int index, ArrayList<String> result) {
		if (index >= array.length) {
			result.add(Arrays.toString(array));
			return;
		}
		for (int i = index; i < array.length; i++) {
			swap(array, i, index);
			handle(array, index + 1, result);
			swap(array, index, i);
		}
	}

	public void swap(char[] array, int left, int right) {
		char c = array[left];
		array[left] = array[right];
		array[right] = c;
	}

	private String res = "";
	private int count = 0;

	public String getPermutation_1(int n, int k) {
		int[] num = new int[n];
		for (int i = 0; i < n; i++)
			num[i] = i + 1;

		backTrack(num, n, k, "");
		return res;
	}

	public void backTrack(int[] num, int n, int k, String string) {
		if (n == 0) {
			count++;
			res = string;
			return;
		}
		for (int i = 0; i < num.length; i++) {
			if (num[i] == 0)
				continue;
			string += num[i];
			num[i] = 0;
			backTrack(num, n - 1, k, string);
			if (count == k)
				break;
			num[i] = i + 1;
			string = string.substring(0, string.length() - 1);
		}
	}

	public static void main(String[] args) {
		L89_getPermutation getPermutation = new L89_getPermutation();
		System.out.println(getPermutation.getPermutation_1(3, 5));
	}

}
