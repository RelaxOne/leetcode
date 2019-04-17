package org.relaxone;

import java.util.Arrays;

public class L74_SortColors {

	public void swap(int[] A, int left,int right) {
		int temp = A[left];
		A[left] = A[right];
		A[right] = temp;
	}
	
	public void sortColors(int[] A) {
		int i = 0;
		int head = 0;
		int tail = A.length - 1;
		while (i < tail + 1) {
			if (A[i] == 0) {
				swap(A, head, i);
				head++;
				i++;
			} else if (A[i] == 2) {
				swap(A, tail, i);
				tail--;
			} else {
				i++;
			}
		}
	}
	
	public static void main(String[] args) {
		int[] A = {0,1,2,0,1,2,0,1,0,1,2,0,0,2};
		L74_SortColors colors = new L74_SortColors();
		colors.sortColors(A);
		System.out.println(Arrays.toString(A));
	}
	
}
