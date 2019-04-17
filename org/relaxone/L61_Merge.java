package org.relaxone;

import java.util.Arrays;

public class L61_Merge {

	public void merge(int[] A, int m, int[] B, int n) {
		if (m == 0) {
			for (int k = 0; k < B.length; k++)
				A[k] = B[k];
		} else {
			int index = m + n - 1;
			int index_m = m - 1, index_n = n - 1;

			while (index_n >= 0 && index_m >= 0) {
				if (B[index_n] > A[index_m])
					A[index--] = B[index_n--];
				else
					A[index--] = A[index_m--];
			}
			while (index_n >= 0) 
				A[index--] = B[index_n--];
			while (index_m >= 0)
				A[index--] = A[index_m--];
		}
	}

	public static void main(String[] args) {
		int[] A = new int[2];
		A[0] = 2;
		int[] B = { 1 };
		L61_Merge l61_Merge = new L61_Merge();
		l61_Merge.merge(A, 1, B, 1);
		System.out.println(Arrays.toString(A));
	}

}
