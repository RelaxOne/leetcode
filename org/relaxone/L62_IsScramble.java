package org.relaxone;

public class L62_IsScramble {

	public boolean isScramble(String s1, String s2) {
		if (s1.length() != s2.length())
			return false;
		if (s1.equals(s2))
			return true;
		char[] array1 = s1.toCharArray();
		char[] array2 = s2.toCharArray();
		for (int i = 0; i < array1.length; i++) {
			if (array1[i] != array2[i]) {
				// 从后面找一个和当前字符相同的交换
				boolean flag = false; // 判断是否已经交换两个字符
				for (int j = i + 1; j < array2.length; j++) {
					// 交换两个字符
					if (array1[i] == array2[j]) {
						char c = array2[j];
						array2[j] = array2[i];
						array2[i] = c;
						flag = true;
						break;
					}

				}
				if (!flag)
					return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		L62_IsScramble isScramble = new L62_IsScramble();
		System.out.println(isScramble.isScramble("abc", "bca"));
	}

}
