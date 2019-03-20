package org.relaxone;

import org.relaxone.common.TreeNode;

public class L39_ISBalanced {

	public boolean isBalanced(TreeNode root) {
		if (root == null)
			return true;
		return isBalanced(root.left) && isBalanced(root.right) && Math.abs(getHeight(root.left) - getHeight(root.right)) <= 1;
	}

	public int getHeight(TreeNode node) {
		if (node == null)
			return 0;
		int left = getHeight(node.left);
		int right = getHeight(node.right);
		return Math.max(left, right) + 1;
	}

}
