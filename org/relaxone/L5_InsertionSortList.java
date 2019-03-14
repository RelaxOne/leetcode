package org.relaxone;

import org.relaxone.common.ListNode;

public class L5_InsertionSortList {

	public ListNode insertionSortList(ListNode head) {
		ListNode result = head;
		if (result == null)
			return result;
		ListNode p = head.next;
		result.next = null;
		
		while (p != null) {
			ListNode temp = p;
			p = p.next;
			ListNode p1 = result.next, h = result;
			// 当前节点插入到头结点
			if(temp.val < result.val) {
				result = temp;
				result.next  = h;
			}else {
				// 当前节点插入到中间
				while (p1 != null) {
					if (h.val <= temp.val && p1.val > temp.val) {
						break;
					}
					h = h.next;
					p1 = p1.next;
				}
				// 当前节点插入到末尾
				if(h.next == null) {
					h.next = temp;
					temp.next = null;
					continue;
				}
				temp.next = p1;
				h.next = temp;
			}
		}
		return result;
	}
	public static void main(String[] args) {
		ListNode root = new ListNode(0);
		L5_InsertionSortList insertionSortList = new L5_InsertionSortList();
		ListNode result = insertionSortList.insertionSortList(root);
		ListNode.printNode(result);
	}
}
