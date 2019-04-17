package org.relaxone;

import java.util.ArrayList;

import org.relaxone.common.TreeNode;

public class L50_RecoverTree {

	ArrayList<TreeNode> list = new ArrayList<>();

	public void recoverTree(TreeNode root) {
		ArrayList<TreeNode> temp = new ArrayList<>();
		int index = 0;
		iterator(root);
		if(list.size() == 2) {
			changeValue(root, list.get(0).val, list.get(1).val);
			return;
		}
		for (int i = 1; i < list.size() && index < 2; i++) {
			if (list.get(i).val < list.get(i - 1).val) {
				if (index == 0) {
					temp.add(list.get(i - 1));
					temp.add(list.get(i));
				} else {
					temp.remove(temp.size()-1);
					temp.add(list.get(i));
				}
				index++;
			}
		}
		System.out.println(temp.get(0).val+ "    "+temp.get(1).val);
		changeValue(root, temp.get(0).val, temp.get(1).val);
	}

	public void changeValue(TreeNode node, int val1, int val2) {
		if (node == null)
			return;
		if (node.val == val1)
			node.val = val2;
		else if (node.val == val2)
			node.val = val1;
		changeValue(node.left, val1, val2);
		changeValue(node.right, val1, val2);
	}

	public void iterator(TreeNode node) {
		if (node == null)
			return;
		iterator(node.left);
		list.add(node);
		iterator(node.right);
	}

	public static void main(String[] args) {
		L50_RecoverTree l50_RecoverTree = new L50_RecoverTree();
		TreeNode root = TreeNode.init();
		TreeNode.printNode(root);
		System.out.println();
		l50_RecoverTree.recoverTree(root);
		TreeNode.printNode(root);
	}
}
