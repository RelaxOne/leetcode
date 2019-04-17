package org.relaxone;

import java.util.ArrayList;

public class L78_SimplifyPath {

	public String simplifyPath(String path) {

		if (path.trim().equals("") || path == null)
			return "";
		String[] strings = path.split("/");
		StringBuffer buffer = new StringBuffer();
		ArrayList<String> list = new ArrayList<>();

		for (int i = 0; i < strings.length; i++) {
			if (!strings[i].equals("") && !strings[i].equals(".") && !strings[i].equals(".."))
				list.add(strings[i]);
			else if (strings[i].equals("..") && list.size() > 0)
				list.remove(list.size() - 1);
		}

		buffer.append("/");
		for (int i = 0; i < list.size() - 1; i++) {
			buffer.append(list.get(i));
			buffer.append("/");
		}
		if (list.size() > 0)
			buffer.append(list.get(list.size() - 1));
		return buffer.toString();
	}

	public static void main(String[] args) {
		L78_SimplifyPath l78_SimplifyPath = new L78_SimplifyPath();
		String path = "/..";
		System.out.println(l78_SimplifyPath.simplifyPath(path));
	}

}
