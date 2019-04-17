package org.relaxone;

public class L52_IsInterleave {

	public boolean isInterleave(String s1, String s2, String s3) {
		if (s3.length() != s1.length() + s2.length())
			return false;
		int s1_index = 0, s2_index = 0;
		for (int i = 0; i < s3.length(); i++) {
			if (s1_index == s1.length()) {
				if (s3.charAt(i) != s2.charAt(s2_index))
					return false;
				else 
					continue;
			}
			if (s2_index == s2.length()) {
				if (s3.charAt(i) != s1.charAt(s1_index))
					return false;
				else 
					continue;
			}
			// ¼ÈÆ¥Åäµ½ s1£¬ ÓÖÆ¥ÅäÁË s2
			if (s3.charAt(i) == s1.charAt(s1_index) && s3.charAt(i) == s2.charAt(s2_index)) {
				s1_index++;
				continue;
			} else if (s3.charAt(i) == s1.charAt(s1_index)) {
				s1_index++;
				continue;
			} else if (s3.charAt(i) == s2.charAt(s2_index)) {
				s2_index++;
				continue;
			} else {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {

		L52_IsInterleave interleave = new L52_IsInterleave();

		String s3 = "aadbbcbcac";
		String s1 = "aabcc";
		String s2 = "dbbca";

		System.out.println(interleave.isInterleave(s1, s2, s3));
	}

}
