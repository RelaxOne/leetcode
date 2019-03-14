package org.relaxone;

import java.util.ArrayList;

import org.relaxone.common.TreeNode;

public class L6_PostOrderTraversal {

	public ArrayList<Integer> postOrderTraversal(TreeNode root) {
		ArrayList<Integer> result = new ArrayList<>();

		if (root == null)
			return result;
		iterator(root, result);
		return result;
	}

	public void iterator(TreeNode root, ArrayList<Integer> list) {
		if (root == null)
			return;
		iterator(root.left, list);
		iterator(root.right, list);
		list.add(root.val);
	}

	public static void main(String[] args) {
		L6_PostOrderTraversal l6_PostOrderTraversal = new L6_PostOrderTraversal();

		TreeNode root = new TreeNode(1);
		TreeNode right = new TreeNode(2);
		TreeNode right_left = new TreeNode(3);

		root.left = null;
		root.right = right;

		right.left = right_left;
		right.right = null;

		right_left.left = null;
		right_left.right = null;

		ArrayList<Integer> list = l6_PostOrderTraversal.postOrderTraversal(root);
		System.out.println(list);
	}
}
