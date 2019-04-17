package org.relaxone;

import org.relaxone.common.TreeNode;

public class L51_IsValidBST {

	public boolean isValidBST(TreeNode root) {
		if (root == null)
			return true;
		if (root.left == null && root.right == null)
			return true;
		if (root.right != null) {
			if (root.val >= root.right.val)
				return false;
			TreeNode p = root.right;
			while (p.left != null) {
				p = p.left;
			}
			if (root.val >= p.val) {
				return false;
			}
		}
		if (root.left != null) {
			if (root.val <= root.left.val)
				return false;
			TreeNode p = root.left;
			while (p.right != null) {
				p = p.right;
			}
			if (p.val >= root.val)
				return false;
		}
		return isValidBST(root.left) && isValidBST(root.right);
	}

}
