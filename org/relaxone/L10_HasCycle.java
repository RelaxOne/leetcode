package org.relaxone;

import org.relaxone.common.ListNode;

public class L10_HasCycle {
	public boolean hasCycle(ListNode head) {
		ListNode slow = head;
		ListNode fast = head;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if(fast == slow)
				return true;
		}

		return false;
	}
}
