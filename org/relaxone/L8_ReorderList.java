package org.relaxone;

import java.util.Stack;

import org.relaxone.common.ListNode;

public class L8_ReorderList {

	public void reorderList(ListNode head) {
		ListNode p = head;
		if(p == null)
			return;
		Stack<ListNode> stack = new Stack<>();
		int length = 0;
		while (p != null) {
			stack.push(p);
			p = p.next;
			length++;
		}
		p = head;
		for (int i = 0; i < length / 2; i++) {
			ListNode temp = p.next;
			p.next = stack.pop();
			p.next.next = temp;
			p = temp;
		}
		p.next = null;
	}

	public static void main(String[] args) {
		L8_ReorderList l8_ReorderList = new L8_ReorderList();
		ListNode head = null;
		l8_ReorderList.reorderList(head);
		ListNode.printNode(head);
	}

}
