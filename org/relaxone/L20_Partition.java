package org.relaxone;

import java.util.ArrayList;

public class L20_Partition {

	public ArrayList<ArrayList<String>> partition(String s) {
		ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
		if (s == null || s.length() == 0)
			return result;
		ArrayList<String> list = new ArrayList<String>();
		dfs(s, result, list);
		return result;
	}

	public void dfs(String str, ArrayList<ArrayList<String>> result, ArrayList<String> list) {
		if (str == null || str.length() == 0) {
			result.add(new ArrayList<String>(list));
			return;
		}
		int len = str.length();
		for (int i = 0; i <= len; i++) {
			if (isPalindrome(str.substring(0, i))) {
				list.add(str.substring(0, i));
				dfs(str.substring(i, len), result, list);
				list.remove(list.size() - 1);
			}
		}
	}

	/**
	 * a. 判断一个字符串是否是回文字符串
	 * 
	 * @param str
	 * @return
	 */
	public boolean isPalindrome(String str) {
		if (null == str || str.length() == 0)
			return false;
		for (int i = 0, j = str.length() - 1; i < j; i++, j--) {
			if (str.charAt(i) != str.charAt(j))
				return false;
		}
		return true;
	}

	public static void main(String[] args) {
		L20_Partition l20_Partition = new L20_Partition();
		ArrayList<ArrayList<String>> list = l20_Partition.partition("aab");
		System.out.println(list);
	}

}
