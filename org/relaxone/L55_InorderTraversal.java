package org.relaxone;

import java.util.ArrayList;

import org.relaxone.common.TreeNode;

public class L55_InorderTraversal {

	public ArrayList<Integer> inorderTraversal(TreeNode root) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		iterator(root, result);
		return result;
	}

	public void iterator(TreeNode node, ArrayList<Integer> list) {
		if (node == null)
			return;
		iterator(node.left, list);
		list.add(node.val);
		iterator(node.right, list);
	}

	public static void main(String[] args) {
		TreeNode root = TreeNode.init();
		L55_InorderTraversal inorderTraversal = new L55_InorderTraversal();
		ArrayList<Integer> list = inorderTraversal.inorderTraversal(root);
		for (Integer value : list) {
			System.out.print(value + " ");
		}

	}

}
