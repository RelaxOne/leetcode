package org.relaxone;

import org.relaxone.common.TreeNode;

public class L48_IsSymmetric {

	public boolean isSymmetric(TreeNode root) {
		TreeNode rootMirror = getMirror(root);
		return isSymmetric(root, rootMirror);
	}

	public boolean isSymmetric(TreeNode root, TreeNode mirror) {
		if (root == null && mirror == null)
			return true;
		if (root == null || mirror == null)
			return false;
		return root.val == mirror.val && isSymmetric(root.left, mirror.left) && isSymmetric(root.right, mirror.right);
	}

	public TreeNode getMirror(TreeNode root) {
		if (root == null)
			return null;
		TreeNode node = new TreeNode(root.val);
		node.left = getMirror(root.right);
		node.right = getMirror(root.left);
		return node;
	}

	public static void main(String[] args) {
		L48_IsSymmetric isSymmetric = new L48_IsSymmetric();
		TreeNode node = TreeNode.init();
		TreeNode.printNode(node);
		System.out.println();
		TreeNode.printNode(isSymmetric.getMirror(node));
	}
}
