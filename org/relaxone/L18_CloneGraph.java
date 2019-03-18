package org.relaxone;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

import org.relaxone.common.UndirectedGraphNode;

public class L18_CloneGraph {
	
	/**
	 * a.�ǵݹ�ķ�ʽʵ��ͼ�ı���
	 * @param node
	 * @return
	 */
	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
		if (node == null)
			return null;
		Queue<UndirectedGraphNode> queue = new LinkedList<>();
		UndirectedGraphNode cloneNode = new UndirectedGraphNode(node.label);
		queue.offer(node);

		// ��Žڵ㼰���¡�ڵ�ļ�ֵ��
		Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();

		// ��ŵ�һ���ڵ㼰���¡�ڵ�ļ�ֵ��
		map.put(node, cloneNode);

		while (!queue.isEmpty()) {
			UndirectedGraphNode node2 = queue.poll();
			// ��ȡ�����ڵ�Ŀ�¡�ڵ�
			UndirectedGraphNode node2Clone = map.get(node2);
			for (UndirectedGraphNode neighbor : node2.neighbors) {
				// �ж��ھӽڵ��Ƿ��Ѿ���ӵ�������
				if (map.containsKey(neighbor)) {
					// �Ѿ���ӵ�������ʱ,ֱ�������ֵ�������ڵ�Ŀ�¡�ڵ���
					node2Clone.neighbors.add(map.get(neighbor));
				} else {
					// ��������ʱ, �½��ڵ�,�����ڵ���뵽�����в�������¡�ڵ��ֵ�Ե�������
					UndirectedGraphNode node3 = new UndirectedGraphNode(neighbor.label);
					map.put(neighbor, node3);
					queue.add(neighbor);
					node2Clone.neighbors.add(node3);
				}
			}
		}
		return cloneNode;
	}
	
	/**
	 * a. �ݹ�ķ�ʽʵ��ͼ�ı���
	 * @param node
	 * @param map
	 * @return
	 */
	public UndirectedGraphNode cloneGraph_2(UndirectedGraphNode node,
			Map<UndirectedGraphNode, UndirectedGraphNode> map) {
		if (node == null)
			return null;
		UndirectedGraphNode cloneNode = new UndirectedGraphNode(node.label);
		map.put(node, cloneNode);
		for (UndirectedGraphNode neighbor : node.neighbors) {
			if (map.containsKey(neighbor)) {
				cloneNode.neighbors.add(map.get(neighbor));
			} else {
				UndirectedGraphNode temp = cloneGraph_2(neighbor, map);
				cloneNode.neighbors.add(temp);
			}
		}
		return cloneNode;
	}

	public static void main(String[] args) {

		L18_CloneGraph cloneGraph = new L18_CloneGraph();

		UndirectedGraphNode node = UndirectedGraphNode.init();
		Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
		UndirectedGraphNode.printUndirectedGraphNode(cloneGraph.cloneGraph_2(node, map));
	}

}
