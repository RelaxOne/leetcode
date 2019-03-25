package org.relaxone;

import java.util.ArrayList;

public class L32_GetRow {

	public ArrayList<Integer> getRow(int rowIndex) {
		ArrayList<Integer> result = new ArrayList<>();
		for (int i = 0; i <= rowIndex; i++) {
			result.add(new Integer(1));
		}
		if (rowIndex == 1 || rowIndex == 0)
			return result;
		// 定义循环次数
		for (int i = 2; i <= rowIndex; i++) {
			int headRow = 1;
			for (int j = 1; j < i; j++) {
				int temp = result.get(j);
				result.set(j, result.get(j) + headRow);
				headRow = temp;
			}
		}
		return result;
	}

	public static void main(String[] args) {
		L32_GetRow getRow = new L32_GetRow();
		System.out.println(getRow.getRow(4));
	}

}
