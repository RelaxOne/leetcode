package org.relaxone;

public class L15_SingleNumber {

	public int singleNumber(int[] A) {
		int result = 0;
		for(int i = 0;i < A.length;i++) {
			result = result ^ A[i];
		}
		return result;
	}
	
	public static void main(String[] args) {
		int[] A = {1,2,3,5,4,1,6,4,2,3,6};
		L15_SingleNumber l15_SingleNumber = new L15_SingleNumber();
		System.out.println(l15_SingleNumber.singleNumber(A));
	}
}
