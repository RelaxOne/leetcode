package org.relaxone.common;

public class TreeLinkNode {

	public int val;
	public TreeLinkNode left, right, next;

	public TreeLinkNode(int x) {
		val = x;
	}

	public static TreeLinkNode init() {
		TreeLinkNode root = new TreeLinkNode(1);
		TreeLinkNode left = new TreeLinkNode(2);
		TreeLinkNode right = new TreeLinkNode(3);
		TreeLinkNode left_left = new TreeLinkNode(4);
		TreeLinkNode left_right = new TreeLinkNode(5);
		TreeLinkNode right_right = new TreeLinkNode(7);

		root.left = left;
		root.right = right;

		left.left = left_left;
		left.right = left_right;

		right.left = null;
		right.right = right_right;

		right_right.left = null;
		right_right.right = null;
		left_left.left = null;
		left_left.right = null;

		left_right.left = null;
		left_right.right = null;

		return root;
	}

}
