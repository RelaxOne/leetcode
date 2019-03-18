package org.relaxone;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

import org.relaxone.common.UndirectedGraphNode;

public class L18_CloneGraph {
	
	/**
	 * a.非递归的方式实现图的遍历
	 * @param node
	 * @return
	 */
	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
		if (node == null)
			return null;
		Queue<UndirectedGraphNode> queue = new LinkedList<>();
		UndirectedGraphNode cloneNode = new UndirectedGraphNode(node.label);
		queue.offer(node);

		// 存放节点及其克隆节点的键值对
		Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();

		// 存放第一个节点及其克隆节点的键值对
		map.put(node, cloneNode);

		while (!queue.isEmpty()) {
			UndirectedGraphNode node2 = queue.poll();
			// 获取遍历节点的克隆节点
			UndirectedGraphNode node2Clone = map.get(node2);
			for (UndirectedGraphNode neighbor : node2.neighbors) {
				// 判断邻居节点是否已经添加到集合中
				if (map.containsKey(neighbor)) {
					// 已经添加到集合中时,直接添加其值到遍历节点的克隆节点中
					node2Clone.neighbors.add(map.get(neighbor));
				} else {
					// 若不存在时, 新建节点,并将节点加入到队列中并添加其克隆节点键值对到集合中
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
	 * a. 递归的方式实现图的遍历
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
