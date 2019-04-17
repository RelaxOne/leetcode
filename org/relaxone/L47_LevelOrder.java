package org.relaxone;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

import org.relaxone.common.TreeNode;

public class L47_LevelOrder {

	public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<>();
		if (root == null)
			return result;
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(null);
		queue.offer(root);
		while (queue.size() != 1) {
			TreeNode node = queue.poll();
			if (node == null) {
				ArrayList<Integer> list = new ArrayList<>();
				Iterator<TreeNode> iterator = queue.iterator();
				while(iterator.hasNext()) {
					TreeNode next = iterator.next();
					list.add(new Integer(next.val));
				}
				queue.add(null);
				result.add(list);
				continue;
			}
			if (node.left != null)
				queue.offer(node.left);
			if (node.right != null)
				queue.offer(node.right);
		}

		return result;
	}

}
