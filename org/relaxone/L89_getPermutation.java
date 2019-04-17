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

	public static void main(String[] args) {
		L89_getPermutation getPermutation = new L89_getPermutation();
		System.out.println(getPermutation.getPermutation(3, 5));
	}

}
