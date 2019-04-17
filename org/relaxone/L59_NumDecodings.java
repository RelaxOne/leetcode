package org.relaxone;

public class L59_NumDecodings {

	public int numDecodings(String s) {
		if (s.length() == 0 || s == null || (s.length() > 1 && s.charAt(0) == '0'))
			return 0;
		int[] result = new int[s.length() + 1];
		result[0] = 1;
		for (int i = 1; i < result.length; i++) {
			if (s.charAt(i - 1) == '0')
				result[i] = 0;
			else
				result[i] = result[i - 1];
			if ((i > 1 && s.charAt(i - 2) == '1') || (i > 1 && '6' >= s.charAt(i - 1) && s.charAt(i - 2) == '2')) {
				result[i] += result[i - 2];
			}
		}
		return result[s.length()-1];
	}

	public static void main(String[] args) {
		L59_NumDecodings decodings = new L59_NumDecodings();
		System.out.println(decodings.numDecodings("12335"));

	}
}
