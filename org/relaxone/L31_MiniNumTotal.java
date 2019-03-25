package org.relaxone;

import java.util.ArrayList;

public class L31_MiniNumTotal {

	public int minNumTotal(ArrayList<ArrayList<Integer>> triangle) {
		int result = 0;
		if (triangle == null)
			return result;
		ArrayList<Integer> lastRow = triangle.get(triangle.size() - 1);
		int[] list = new int[lastRow.size()];
		for (int i = 0; i < lastRow.size(); i++) {
			list[i] = lastRow.get(i).intValue();
		}
		// 定义循环次数
		for (int i = triangle.size() - 1; i >= 0; i--) {
			for (int j = 0; j < i; j++) {
				if (list[j] > list[j + 1])
					list[j] = triangle.get(i - 1).get(j) + list[j + 1];
				else
					list[j] += triangle.get(i - 1).get(j);
			}
		}

		return list[0];
	}

	public static void main(String[] args) {
		ArrayList<ArrayList<Integer>> triangle = new ArrayList<>();
		ArrayList<Integer> row1 = new ArrayList<>();
		row1.add(2);
		ArrayList<Integer> row2 = new ArrayList<>();
		row2.add(3);
		row2.add(4);
		ArrayList<Integer> row3 = new ArrayList<>();
		row3.add(6);
		row3.add(5);
		row3.add(7);
		ArrayList<Integer> row4 = new ArrayList<>();
		row4.add(4);
		row4.add(1);
		row4.add(8);
		row4.add(3);
		triangle.add(row1);
		triangle.add(row2);
		triangle.add(row3);
		triangle.add(row4);

		L31_MiniNumTotal l31_MiniNumTotal = new L31_MiniNumTotal();
		System.out.println(l31_MiniNumTotal.minNumTotal(triangle));
	}

}
