package org.relaxone;

import org.relaxone.common.ListNode;

public class L66_DeleteDuplicates {

	public ListNode deleteDuplicates(ListNode head) {
		if (head == null)
			return null;
		ListNode result = new ListNode(0);
		result.next = head;
		ListNode p = head, p_head = result;
		boolean flag = false;
		while (p.next != null) {
			// ѭ��ɾ������ڵ�͵�ǰ�ڵ���ͬ�Ľڵ�
			if (p.val == p.next.val) {
				p.next = p.next.next;
				flag = true;
				continue;
			}
			// ɾ����һ���ظ��Ľڵ�
			if (flag) {
				p = p.next;
				p_head.next = p;
				flag = false;
			} else {
				p = p.next;
				p_head = p_head.next;
			}
		}
		if (flag) {
			p = p.next;
			p_head.next = p;
		}
		return result.next;
	}
	public static void main(String[] args) {
		L66_DeleteDuplicates deleteDuplicates = new L66_DeleteDuplicates();
		ListNode head = ListNode.init();
		ListNode node = deleteDuplicates.deleteDuplicates(head);
		ListNode.printNode(node);
	}
}
