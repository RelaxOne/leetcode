package org.relaxone;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class L71_Subsets {

	public ArrayList<ArrayList<Integer>> subsets(int[] S) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<>();
		Arrays.sort(S);
		dfs(result, new ArrayList<>(), 0, S);
		Collections.sort(result, new Comparator<ArrayList<Integer>>() {
			@Override
			public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
				if (o1.size() != o2.size())
					return o1.size() - o2.size();
				for (int i = 0; i < o1.size(); i++) {
					if (o1.get(i) != o2.get(i))
						return o1.get(i) - o2.get(i);
				}
				return 0;
			}
		});
		return result;
	}

	public void dfs(ArrayList<ArrayList<Integer>> result, ArrayList<Integer> arrayList, int start, int[] S) {
		if (start > S.length)
			return;
		result.add(new ArrayList<>(arrayList));
		for (int i = start; i < S.length; i++) {
			arrayList.add(S[i]);
			dfs(result, arrayList, i + 1, S);
			arrayList.remove(arrayList.size() - 1);
		}
	}

	public static void main(String[] args) {
		L71_Subsets l71_Subsets = new L71_Subsets();
		int[] S = { 1, 2};
		ArrayList<ArrayList<Integer>> list = l71_Subsets.subsets(S);
		System.out.println(list);
	}
}
