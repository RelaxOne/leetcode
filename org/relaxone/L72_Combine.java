package org.relaxone;

import java.util.ArrayList;

public class L72_Combine {

	public ArrayList<ArrayList<Integer>> combine(int n, int k) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<>();
		if (k > n)
			return result;
		dfs(result, new ArrayList<>(), 1, n, k);
		return result;
	}

	public void dfs(ArrayList<ArrayList<Integer>> result, ArrayList<Integer> list, int start, int n, int k) {
		if (start > n+1)
			return;
		if (list.size() == k)
			result.add(new ArrayList<>(list));
		for (int i = start; i < n+1; i++) {
			list.add(i);
			dfs(result, list, i + 1, n, k);
			list.remove(list.size() - 1);
		}
	}
	
	public static void main(String[] args) {
		L72_Combine combine = new L72_Combine();
		ArrayList<ArrayList<Integer>> list = combine.combine(4, 2);
		System.out.println(list);
	}
	
}
