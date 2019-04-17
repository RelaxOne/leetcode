package org.relaxone;

import java.util.ArrayList;

public class L60_GrayCode {

	public ArrayList<Integer> grayCode(int n) {
		ArrayList<Integer> result = new ArrayList<>();
		result.add(0);
		for (int i = 0; i < n; i++) {
			for(int j = result.size()- 1;j >=0;j--) {
				result.add(result.get(j) + (1 << i) );
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		L60_GrayCode code = new L60_GrayCode();
		System.out.println(code.grayCode(4));
		
	}

}
