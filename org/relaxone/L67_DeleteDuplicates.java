package org.relaxone;

import org.relaxone.common.ListNode;

public class L67_DeleteDuplicates {

	public ListNode deleteDuplcates(ListNode head) {
		if (head == null)
			return null;
		ListNode p_head = head;
		ListNode p = head.next;
		while (p != null) {
			if(p.val == p_head.val) {
				p = p.next;
				continue;
			}
			p_head.next = p;
			p_head = p;
			p = p.next;
		}
		p_head.next = null;
		return head;
	}
	public static void main(String[] args) {
		L67_DeleteDuplicates deleteDuplicates = new L67_DeleteDuplicates();
		ListNode head = ListNode.init();
		ListNode node = deleteDuplicates.deleteDuplcates(head);
		ListNode.printNode(node);
	}
}
