package org.relaxone;

import org.relaxone.common.ListNode;

public class L9_DetectCycle {
	public ListNode detectCysle(ListNode head) {
		ListNode slow = head;
		ListNode fast = head;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast) {
				fast = head;
				while (fast != slow) {
					fast = fast.next;
					slow = slow.next;
				}
				return fast;
			}
		}
		
		return null;
	}
}
