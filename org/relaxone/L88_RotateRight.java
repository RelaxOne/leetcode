package org.relaxone;

import org.relaxone.common.ListNode;

public class L88_RotateRight {

	public ListNode rotateRight(ListNode head, int n) {
		if(head == null)
			return null;
		if(n == 0)
			return head;
		ListNode p, q;
		p = head;
		q = head;
		int index = 0;
		int len = 0;
		ListNode k = head;
        while(k != null){
            len++;
            k = k.next;
        }
        n %= len;
		while (p.next != null) {
			if(index >= n) {
				q = q.next;
			}
			p = p.next;
			index++;
		}
		if(index == n)
			return head;
		p.next = head;
		ListNode result = q.next;
		q.next = null;
		
		return result;
	}
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = null;
		
		L88_RotateRight l88_RotateRight = new L88_RotateRight();
		ListNode node = l88_RotateRight.rotateRight(head, 1);
		ListNode.printNode(node);
	}
}
