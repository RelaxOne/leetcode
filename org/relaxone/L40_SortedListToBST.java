package org.relaxone;

import org.relaxone.common.ListNode;
import org.relaxone.common.TreeNode;

public class L40_SortedListToBST {

	public TreeNode sortedListToBST(ListNode head) {
		if (head == null)
			return null;
		int length = 0;
		ListNode p = head;
		while (p != null) {
			length++;
			p = p.next;
		}
		if (length == 0)
			return null;
		if (length == 1) {
			TreeNode node = new TreeNode(head.val);
			node.left = null;
			node.right = null;
			return node;
		}
		int index = 1;
		ListNode left = head;
		p = head;
		while (index < length / 2) {
			index++;
			p = p.next;
		}
		TreeNode root = new TreeNode(p.next.val);
		ListNode right = p.next.next;
		p.next = null;
		root.left = sortedListToBST(left);
		root.right = sortedListToBST(right);
		return root;
	}

	public TreeNode sortedListToBST_2(ListNode head) {
		return toBST(head, null);
	}

	private TreeNode toBST(ListNode head, ListNode tail) {
		if (head == tail)
			return null;
		ListNode fast = head, slow = head;
		while (fast != tail && fast.next != tail) {
			fast = fast.next.next;
			slow = slow.next;
		}
		TreeNode node = new TreeNode(slow.val);
		node.left = toBST(head, slow);
		node.right = toBST(slow.next, tail);
		return node ;
	}

	public static void main(String[] args) {
		L40_SortedListToBST bst = new L40_SortedListToBST();
		ListNode head = ListNode.init();
		ListNode.printNode(head);
		TreeNode root = bst.sortedListToBST_2(head);
		TreeNode.printNode(root);

	}

}
