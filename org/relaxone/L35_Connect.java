package org.relaxone;

import org.relaxone.common.TreeLinkNode;

public class L35_Connect {

	public void connect(TreeLinkNode root) {
		if (root == null)
			return;
		root.next = null;

		while (root != null) {
			TreeLinkNode head = new TreeLinkNode(0);
			TreeLinkNode cur = head;
			while (root != null) {
				if (root.left != null) {
					cur.next = root.left;
					cur = cur.next;
				}
				if (root.right != null) {
					cur.next = root.right;
					cur = cur.next;
				}
				root = root.next;
			}
			cur.next = null;
			root = head.next;
		}
	}
}
