package org.relaxone;

public class L83_IsNumber {

	public static boolean isNumber(String s) {

		boolean has_e = false, hase_dian = false;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);

			if (!((c >= '0' && c <= '9') || c == '.' || c == 'e'))
				return false;
			if (c == '.') {
				if ((hase_dian && i + 1 < s.length() && s.charAt(i + 1) == 'e') || i == s.length() - 1)
					return false;
				else
					hase_dian = true;
			}

			// 不能含有两个 e
			if (c == 'e') {
				if ((has_e && i + 1 < s.length() && s.charAt(i + 1) == '.') || i == s.length() - 1 || i == 0)
					return false;
				else
					has_e = true;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		System.out.println(isNumber("e9"));
	}

}
