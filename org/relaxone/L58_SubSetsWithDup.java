package org.relaxone;

import java.util.ArrayList;
import java.util.Arrays;

public class L58_SubSetsWithDup {

	public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num){
		ArrayList<ArrayList<Integer>> result = new ArrayList<>();
		Arrays.sort(num);
		iteator(result, new ArrayList<Integer>(), num, 0);
		return result;
	}
	
	public void iteator(ArrayList<ArrayList<Integer> > result, ArrayList<Integer> list, int[] num, int start) {
		result.add(new ArrayList<>(list));
		for(int i = start;i< num.length;i++) {
			if(i != start && num[i] ==num[i-1] )
				continue;
			list.add(num[i]);
			iteator(result, list, num, i+1);
			list.remove(list.size()-1);
		}
	}
	
	public static void main(String[] args) {
		L58_SubSetsWithDup dup = new L58_SubSetsWithDup();
		int[] num = {1,2,2};
		ArrayList<ArrayList<Integer>> list = dup.subsetsWithDup(num);
		System.out.println(list);
	}
}
