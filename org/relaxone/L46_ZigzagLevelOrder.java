package org.relaxone;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

import org.relaxone.common.TreeNode;

public class L46_ZigzagLevelOrder {

	public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<>();
		if (root == null)
			return result;
		LinkedList<TreeNode> queue = new LinkedList<>();
		queue.addLast(null);
		queue.addLast(root);
		boolean leftToRight = true;
		while (queue.size() != 1) {
			TreeNode node = queue.removeFirst();
			if (node == null) {
				ArrayList<Integer> list = new ArrayList<>();
				Iterator<TreeNode> iter = null;
				if (leftToRight)
					iter = queue.iterator();
				else
					iter = queue.descendingIterator();
				while (iter.hasNext()) {
					TreeNode next = iter.next();
					list.add(new Integer(next.val));
				}
				leftToRight = !leftToRight;
				queue.addLast(null);
				result.add(list);
				continue;
			}
			if (node.left != null)
				queue.addLast(node.left);
			if (node.right != null)
				queue.addLast(node.right);
		}
		return result;
	}

}
