package org.relaxone;

import org.relaxone.common.RandomListNode;

public class L13_CopyRandomList {

	public RandomListNode copyRandomList(RandomListNode head) {

		RandomListNode result = head;
		if (result == null)
			return result;

		// 先复制每个链表, 并将复制的节点添加到原节点后
		RandomListNode p = head;
		while (p != null) {
			RandomListNode temp = new RandomListNode(p.label);
			temp.next = p.next;
			p.next = temp;
			p = p.next.next;
		}
		// 讲随机指的节点也拷贝过去
		p = head;
		while (p != null) {
			RandomListNode pNext = p.next;
			if(p.random == null) {
				pNext.random = null;
			}else {
				pNext.random = p.random.next;
			}
			p = p.next.next;
		}
		
		// 将链表分离出来
		p = head;
		result = p.next;
		RandomListNode tail = result;
		p = p.next.next;
		while(p !=null) {
			tail.next = p.next;
			tail = tail.next;
			p = p.next.next;
		}
		return result;
	}
	
	public static void main(String[] args) {
		L13_CopyRandomList copyRandomList = new L13_CopyRandomList();
		RandomListNode node = new RandomListNode(-1);
		node.next = null;
		node.random = null;
		copyRandomList.copyRandomList(node);
		
	}
	
}
