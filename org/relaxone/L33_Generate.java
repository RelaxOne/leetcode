package org.relaxone;

import java.util.ArrayList;

public class L33_Generate {

	public ArrayList<ArrayList<Integer>> generate(int numRows){
		ArrayList<ArrayList<Integer>> result = new ArrayList<>();
		for (int rowIndex = 0; rowIndex < numRows;rowIndex++) {
			
			ArrayList<Integer> list = new ArrayList<>();
			for (int i = 0; i <= rowIndex; i++) {
				list.add(new Integer(1));
			}
			if (rowIndex == 1 || rowIndex == 0) {
				result.add(list);
				continue;
			}
			// 定义循环次数
			for (int i = 2; i <= rowIndex; i++) {
				int headRow = 1;
				for (int j = 1; j < i; j++) {
					int temp = list.get(j);
					list.set(j, list.get(j) + headRow);
					headRow = temp;
				}
			}
			result.add(list);
		}
		return result;
	}
	public static void main(String[] args) {
		L33_Generate generate = new L33_Generate();
		System.out.println(generate.generate(5));
	}
}
