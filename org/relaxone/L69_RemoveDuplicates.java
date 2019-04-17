package org.relaxone;

import java.util.Arrays;

public class L69_RemoveDuplicates {

	public int removeDuplicates(int[] A) {
		if(A.length ==0 || A==null)
			return 0;
		int result = 1;
		int index = 0;
		int count = 1;	//记录当前记录出现的次数
		for (int i = 1; i < A.length; i++) {
			if(A[i] == A[i-1]) {
				count++;
			}else {
				count = 1;
			}
			if(count ==1 || count ==2) {
				result++;
				index++;
				A[index] = A[i];
			}
		}
		return result;
	}
	public static void main(String[] args) {
		L69_RemoveDuplicates duplicates = new L69_RemoveDuplicates();
		int[] A = {1,1,1,2,2,3};
		System.out.println(duplicates.removeDuplicates(A ));
		System.out.println(Arrays.toString(A));
	}
}
