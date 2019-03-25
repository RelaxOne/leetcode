package org.relaxone;

import org.relaxone.common.TreeNode;

public class L38_HasPathSum {

	public boolean hasPathSum(TreeNode root, int sum) {
		if(root == null)
			return false;
		int val = sum - root.val;
		if(val  == 0 && root.left == null && root.right ==null)
			return true;
		return hasPathSum(root.left, val) || hasPathSum(root.right, val);
	}
	
}
