package org.relaxone;

import java.util.HashSet;
import java.util.Set;

public class L12_WorkBreak {

	public boolean workBreak(String s, Set<String> dict) {
		if (s.trim().equals("") || dict.isEmpty())
			return false;
		return work(s, s.length(), "", dict);
	}

	public boolean work(String s, int index, String str, Set<String> dict) {

		if (index <= 0 && str.length() > 0) {
			return true;
		}
		for (int i = index; i >= 0; i--) {
			String temp = s.substring(i, index);
			if (dict.contains(temp)) {
				return work(s, i, s.substring(i, index)+" "+str, dict);
			}
		}
		return false;
	}

	public static void main(String[] args) {
		L12_WorkBreak break1 = new L12_WorkBreak();
		Set<String> dict = new HashSet<>();
		dict.add("aaa");
		dict.add("aaaa");

		String s = "aaaaaaa";

		System.out.println(break1.workBreak(s, dict));
	}
}
