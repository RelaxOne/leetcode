package org.relaxone;

import org.relaxone.common.TreeNode;

public class L45_MaxDepth {

	public int maxDepth(TreeNode root) {
		if (root == null)
			return 0;
		return Math.max(maxDepth(root.left), maxDepth(root.right))+1;
	}

}
