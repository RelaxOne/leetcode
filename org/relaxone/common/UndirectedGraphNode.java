package org.relaxone.common;

import java.util.ArrayList;
import java.util.LinkedList;

public class UndirectedGraphNode {

	public int label;
	public ArrayList<UndirectedGraphNode> neighbors;

	public UndirectedGraphNode(int x) {
		label = x;
		neighbors = new ArrayList<>();
	}

	public static UndirectedGraphNode init() {
		UndirectedGraphNode node0 = new UndirectedGraphNode(0);
		UndirectedGraphNode node1 = new UndirectedGraphNode(1);
		UndirectedGraphNode node2 = new UndirectedGraphNode(2);

		ArrayList<UndirectedGraphNode> neighbors_0 = new ArrayList<>();
		neighbors_0.add(node1);
		neighbors_0.add(node2);

		node0.neighbors = neighbors_0;

		ArrayList<UndirectedGraphNode> neighbors_1 = new ArrayList<>();
		neighbors_1.add(node2);
		node1.neighbors = neighbors_1;

		ArrayList<UndirectedGraphNode> neighbors_2 = new ArrayList<>();
		neighbors_2.add(node2);
		node2.neighbors = neighbors_2;

		return node0;
	}

	public static void printUndirectedGraphNode(UndirectedGraphNode node) {
		if (node == null)
			return;

		LinkedList<UndirectedGraphNode> queue = new LinkedList<>();
		queue.push(node);
		ArrayList<UndirectedGraphNode> hasPrint = new ArrayList<>();
		while (!queue.isEmpty()) {
			UndirectedGraphNode head = queue.poll();
			if (hasPrint.contains(head)) {
				continue;
			}
			System.out.print(head.label + ",");
			hasPrint.add(head);
			for (UndirectedGraphNode neighbor : head.neighbors) {
				System.out.print(neighbor.label + ",");
				queue.addLast(neighbor);
			}
			System.out.print("#");
		}
	}
}
