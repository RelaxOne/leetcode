package org.relaxone;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

import org.relaxone.common.TreeNode;

public class L42_LevelOrderBottom {

	public ArrayList<ArrayList<Integer>> levelOrdeBottom(TreeNode root) {

		ArrayList<ArrayList<Integer>> result = new ArrayList<>();
		if (root == null)
			return result;
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(null);
		queue.add(root);
		while (queue.size() != 1) {
			TreeNode node = queue.poll();
			if (node == null) {
				ArrayList<Integer> list = new ArrayList<>();
				Iterator<TreeNode> iterator = queue.iterator();
				while (iterator.hasNext()) {
					TreeNode node2 = iterator.next();
					list.add(new Integer(node2.val));
				}
				queue.add(null);
				result.add(0, list);
				continue;
			}
			if (node.left != null)
				queue.add(node.left);
			if (node.right != null)
				queue.add(node.right);
		}
		return result;
	}
}
