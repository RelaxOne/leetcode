package org.relaxone;

public class L36_NumDistinct {

	public int numDistinct(String S, String T) {

		int t_index = 0;
		int result = 1;
		for (int i = 0; i < S.length(); i++) {
			if(t_index == T.length())
				t_index = 0;
			if (S.charAt(i) != T.charAt(t_index))
				continue;
			// 统计 S中 和 i 字符连续的次数
			int sNumber = 0;
			for (int j = i; j < S.length(); j++) {
				if(S.charAt(j) == S.charAt(i))
					sNumber++;
			}
			int tNumber = 0;
			for (int j = t_index; j < T.length(); j++) {
				if(T.charAt(j) == T.charAt(t_index))
					tNumber++;
			}
			i += sNumber-1;
			t_index += tNumber;
			if(sNumber == 1 && tNumber ==1)
				continue;
			result *= C(sNumber, tNumber);
		}
		if(t_index != T.length())
			return 0;
		return result;
	}

	public int C(int x, int y) {
		if (y == 0)
			return 1;
		return mult(x, y) / mult(y, y);
	}

	public int mult(int x, int n) {
		int result = 1;
		for (int i = x; i > x - n; i--) {
			result *= i;
		}
		return result;
	}

	public static void main(String[] args) {
		L36_NumDistinct distinct = new L36_NumDistinct();
		System.out.println(distinct.numDistinct("aacaacca", "ca"));
	}

}
