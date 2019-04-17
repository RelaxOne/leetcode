package org.relaxone;

import org.relaxone.common.ListNode;

public class L63_Partition {

	public ListNode partition(ListNode head, int x) {
		if (head == null)
			return null;

		ListNode result = new ListNode(0);
		result.next = head;

		ListNode p = head;
		// 找到给定值得位置
		while (p.next !=null) {
			if ((p.val > x && p.next.val < x) || p.val == x) {
				break;
			}
			p = p.next;
		}

		// 给定的值是最后一个节点
		if (p == null)
			return result.next;
		ListNode p_right = p.next;
		ListNode p_head = p;
		while (p_right != null) {

			ListNode temp = p_right;
			p_right = p_right.next;
			// 找到小于给定值的节点,将它插入到前面的节点
			if (temp.val < x) {
				ListNode tail = result;
				temp.next = tail.next;
				tail.next = temp;
				tail = tail.next;
				p_head.next = p_right;
			} else {
				p_head = p_head.next;
			}

		}
		return result.next;
	}

	public static void main(String[] args) {
		L63_Partition l63_Partition = new L63_Partition();
		ListNode head = new ListNode(3);
		ListNode next = new ListNode(1);
		head.next = next;
		next.next = null;
		
		ListNode node = l63_Partition.partition(head, 2);
		ListNode.printNode(node);
	}
}
