package org.relaxone;

import org.relaxone.common.TreeNode;

public class L22_SumNumbers {
	
	private int reslut = 0;
	public int sumNumbers(TreeNode root) {
		iterator(root, 0);
		return reslut;
	}

	public void iterator(TreeNode node, int temp) {
		if (node == null)
			return;
		int value = node.val + temp * 10;
		if (node.left == null && node.right == null) {
			reslut += value;
		}
		if (node.left != null) {
			iterator(node.left, value);
		}
		if (node.right != null) {
			iterator(node.right, value);
		}
	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		TreeNode left = new TreeNode(2);
		TreeNode right = new TreeNode(3);
		root.left = left;
		root.right = right;
		left.left = null;
		left.right = null;
		right.left = null;
		right.right = null;
		L22_SumNumbers l22_SumNumbers = new L22_SumNumbers();
		System.out.println(l22_SumNumbers.sumNumbers(root));
	}

}
