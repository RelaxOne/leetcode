package org.relaxone;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class L11_WordBreak {

	public ArrayList<String> wordBreak(String s, Set<String> dict) {
		ArrayList<String> result = new ArrayList<>();
		if (s.trim().equals("") || dict.isEmpty())
			return result;

		work(s, s.length(), dict, result, "");

		return result;
	}

	public void work(String s, int index, Set<String> dict, ArrayList<String> result, String r) {
		if (index <= 0 && r.length() > 0)
			result.add(r);
		for (int i = index; i >= 0; i--) {
			String temp = s.substring(i, index);
			if (dict.contains(temp)) {
				if (index == s.length())
					work(s, i, dict, result, s.substring(i, index) + r);
				else
					work(s, i, dict, result, s.substring(i, index) + " " + r);
			}
		}
	}

	public static void main(String[] args) {
		L11_WordBreak break1 = new L11_WordBreak();
		Set<String> dict = new HashSet<>();
		dict.add("cat");
		dict.add("cats");
		dict.add("and");
		dict.add("sand");
		dict.add("dog");

		String s = "catsanddog";

		System.out.println(break1.wordBreak(s, dict));
	}

}
