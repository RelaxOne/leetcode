package org.relaxone;

public class L84_AddBinary {

	public static int binary2Int(String a) {
		char[] arr = a.toCharArray();
		int result = 0;
		for (int i = 0; i < arr.length; i++) {
			result = result << 1;
			if (arr[i] == '1')
				result += 1;
		}
		return result;
	}

	public static String addBinary(String a, String b) {
		int value = binary2Int(a) + binary2Int(b);
		return Integer.toBinaryString(value);
	}

	public static String addBinary_1(String a, String b) {
		boolean jin = false; // 表示是否有进位
		StringBuilder builder = new StringBuilder();
		int m = a.length();
		int n = b.length();
		int min = m > n ? n : m;
		for (int i = 0; i < min; i++) {
			char a_c = a.charAt(a.length() - i - 1);
			char b_c = b.charAt(b.length() - i - 1);
			// 有进位
			if (jin) {
				if (a_c == '1' && b_c == '1') {
					builder.append("1");
				} else if (a_c == '0' && b_c == '0') {
					builder.append("1");
					jin = false;
				} else {
					builder.append("0");
				}
			} else {
				if (a_c == '1' && b_c == '1') {
					jin = true;
					builder.append("0");
				} else if (a_c == '0' && b_c == '0') {
					builder.append("0");
				} else {
					builder.append("1");
				}
			}
		}
		System.out.println(builder.toString());
		if (jin) {
			if (m > n)
				add(a, builder, m - n);
			else
				add(b, builder, n - m);
		} else {
			if (m > n)
				copy(a, builder, m - n);
			else
				copy(b, builder, n - m);
		}
		StringBuilder reverse = builder.reverse();
		return reverse.toString();
	}

	public static void copy(String str, StringBuilder builder, int pos) {
		for (int i = pos; i > 0; i--)
			builder.append(str.charAt(i - 1));
	}

	public static void add(String str, StringBuilder builder, int pos) {
		int index = -2;
		for (int i = pos; i > 0; i--) {
			if (str.charAt(i - 1) == '1')
				builder.append("0");
			else {
				index = i - 2;
				builder.append("1");
				break;
			}
		}
		for (int i = index; i >= 0; i--) {
			builder.append(str.charAt(i));
		}
		if (index == -2)
			builder.append("1");
	}

	public static void main(String[] args) {
		String string = L84_AddBinary.addBinary_1("101111", "10");
		System.out.println(string);
	}

}
