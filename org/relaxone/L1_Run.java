package org.relaxone;

import org.relaxone.common.TreeNode;

public class L1_Run {
	public int run(TreeNode root) {
		if (root == null)
			return 0;
		return iterator(root);
	}

	public int iterator(TreeNode node) {
		if (node.left == null && node.right == null)
			return 1;
		if (node.left == null) {
			return iterator(node.right) + 1;
		} else if (node.right == null) {
			return iterator(node.left) + 1;
		} else {
			return Math.min(iterator(node.left), iterator(node.right)) + 1;
		}
	}

	public static void main(String[] args) {
		L1_Run l1_Run = new L1_Run();
		TreeNode root = new TreeNode(1);
		TreeNode root1 = new TreeNode(2);

		root.left = root1;
		root.right = null;

		root1.left = null;
		root1.right = null;

		System.out.println(l1_Run.run(root));
	}
}
