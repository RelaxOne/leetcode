package org.relaxone;

import org.relaxone.common.RandomListNode;

public class L13_CopyRandomList {

	public RandomListNode copyRandomList(RandomListNode head) {

		RandomListNode result = head;
		if (result == null)
			return result;

		// �ȸ���ÿ������, �������ƵĽڵ���ӵ�ԭ�ڵ��
		RandomListNode p = head;
		while (p != null) {
			RandomListNode temp = new RandomListNode(p.label);
			temp.next = p.next;
			p.next = temp;
			p = p.next.next;
		}
		// �����ָ�Ľڵ�Ҳ������ȥ
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
		
		// ������������
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
