package org.relaxone;

import java.util.ArrayList;

import org.relaxone.common.TreeNode;

public class L37_PathSum {

	public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum){
		ArrayList<ArrayList<Integer>> result = new ArrayList<>();
		if(root == null)
			return result;
		ArrayList<Integer> list  = new ArrayList<>();
		iterator(result, list, sum,root);
		return result;
	}

	public void iterator(ArrayList<ArrayList<Integer>> result, ArrayList<Integer> list, int sum, TreeNode node) {
		if(node == null)
			return;
		sum -= node.val;
		list.add(node.val);
		if(node.left == null && node.right ==null && sum == 0) {
			result.add(new ArrayList<>(list));
		}
		iterator(result, list, sum, node.left);
		iterator(result, list, sum, node.right);
		list.remove(list.size()-1);
		
	}
	
}
