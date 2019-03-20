package org.relaxone;

import org.relaxone.common.TreeNode;

public class L27_MaxPathSum {

	int result = Integer.MIN_VALUE;
	public int maxPathSum(TreeNode root) {
		if(root == null)
			return result;
		iteator(root);
		return result;
	}
	public int iteator(TreeNode root) {
		if(root == null)
			return 0;
		int leftSum = Math.max(0, iteator(root.left));
		int right = Math.max(0, iteator(root.right));
		result = Math.max(result, leftSum + right + root.val);
		return Math.max(right, leftSum) + root.val;
	}
	
}
