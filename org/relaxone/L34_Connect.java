package org.relaxone;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

import org.relaxone.common.TreeLinkNode;

public class L34_Connect {

	public void connect(TreeLinkNode root) {
		if (root == null)
			return;
		Queue<TreeLinkNode> queue = new LinkedList<>();
		queue.offer(root);
		queue.offer(null);

		while (queue.size() != 1) {
			TreeLinkNode linkNode = queue.poll();
			if (linkNode == null) {
				Iterator<TreeLinkNode> iterator = queue.iterator();
				TreeLinkNode headNode = null;
				while (iterator.hasNext()) {
					TreeLinkNode next = iterator.next();
					if (headNode != null)
						headNode.next = next;
					next.next = null;
					headNode = next;
				}
				queue.add(null);
				continue;
			}
			if (linkNode.left != null)
				queue.offer(linkNode.left);
			if (linkNode.right != null)
				queue.offer(linkNode.right);
		}
	}

	public static void main(String[] args) {
		TreeLinkNode root = TreeLinkNode.init();
		L34_Connect connect = new L34_Connect();
		connect.connect(root);

		System.out.println(root.left.left.next.val);
	}

}
