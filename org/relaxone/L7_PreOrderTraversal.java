package org.relaxone;

import java.util.ArrayList;

import org.relaxone.common.TreeNode;

public class L7_PreOrderTraversal {

	public void iterator(TreeNode root, ArrayList<Integer> list) {
		if (root == null)
			return;
		list.add(root.val);
		iterator(root.left, list);
		iterator(root.right, list);
	}

	public ArrayList<Integer> preOrderTraversal(TreeNode root) {
		ArrayList<Integer> result = new ArrayList<>();
		if(root == null)
			return result;
		
		iterator(root, result);
		return result;
	}
}
