package org.relaxone;

import org.relaxone.common.ListNode;

public class L57_ReverseBetween {

	public ListNode reverseBetween(ListNode head, int m, int n) {
		ListNode result = new ListNode(0);
		result.next = head;
		ListNode preStart = result;
		ListNode start = result.next;
		for (int i = 1; i < m; i++) {
			preStart = start;
			start = start.next;
		}

		for (int i = 0; i < n - m; i++) {
			ListNode temp = start.next;
			start.next = temp.next;
			temp.next = preStart.next;
			preStart.next = temp;
		}
		return result.next;
	}

	public static void main(String[] args) {
		L57_ReverseBetween between = new L57_ReverseBetween();
		ListNode head = ListNode.init();
		ListNode.printNode(head);
		head = between.reverseBetween(head, 2, 4);
		ListNode.printNode(head);
	}
}
