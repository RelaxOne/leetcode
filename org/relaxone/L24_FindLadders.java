package org.relaxone;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class L24_FindLadders {

	// 判断两个字符串是否只有指定位置的字符不同
	public boolean isSim(String str1, String str2, int index) {
		if (str1.length() != str2.length())
			return false;
		for (int i = 0; i < str1.length(); i++) {
			if (i == index) {
				if (str1.charAt(i) == str2.charAt(i))
					return false;
				continue;
			}
			if (str1.charAt(i) != str2.charAt(i))
				return false;
		}
		return true;
	}

	// 判断集合中的集合的某个位置是否和指定的字符串相等
	public boolean isEqual(ArrayList<ArrayList<String>> list, int index, String str) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).get(index).equals(str))
				return true;
		}
		return false;
	}

	public int isSim(String str1, String str2, boolean[] bitmap) {
		if (str1.length() != str2.length())
			return -1;
		int numberNotEqu = 0;
		int index = -1;
		for (int i = 0; i < str1.length(); i++) {
			if (str1.charAt(i) != str2.charAt(i)) {
				numberNotEqu++;
				index = i;
			}
		}
		if (index != -1 && numberNotEqu == 1)
			return index;
		return -1;

	}

	// 找集合中跟指定字符串只有某一位不同的字符串数组
	public HashMap<String, Integer> getArray(String str, HashSet<String> dict, boolean[] bitmap) {
		Iterator<String> iterator = dict.iterator();
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		while (iterator.hasNext()) {
			String next = iterator.next();
			int index = isSim(str, next, bitmap);
			if (index != -1) {
				map.put(next, index);
			}
		}
		return map;
	}

	public ArrayList<ArrayList<String>> getLadder(String start, String end, HashSet<String> dict) {

		ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
		if (start.length() != end.length())
			return result;
		boolean[] bitmap = new boolean[start.length()];
		int index = 0;
		while (index < start.length()) {
			HashMap<String, Integer> map = getArray(start, dict, bitmap);
			for (String str : map.keySet()) {
				System.out.println(str);
			}
			index++;
		}
		return result;
	}

	public static void main(String[] args) {
		L24_FindLadders findLadders = new L24_FindLadders();
		HashSet<String> dict = new HashSet<String>();
		dict.add("hot");
		dict.add("dot");
		dict.add("dog");
		dict.add("lot");
		dict.add("log");
		findLadders.getLadder("hit", "cog", dict);
	}

}
