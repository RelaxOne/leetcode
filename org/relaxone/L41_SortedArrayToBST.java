package org.relaxone;

import org.relaxone.common.TreeNode;

public class L41_SortedArrayToBST {

	public TreeNode sortedArrayToBST(int[] num) {
		return toBST(num, 0, num.length);
	}

	public TreeNode toBST(int[] num, int start, int end) {
		if (start == end)
			return null;
		int mid = (start + end) / 2;
		TreeNode node = new TreeNode(num[mid]);
		node.left = toBST(num, start, mid);
		node.right = toBST(num, mid+1, end);
		return node;
	}

	public static void main(String[] args) {
		L41_SortedArrayToBST bst = new L41_SortedArrayToBST();
		int[] num = {1,2,3,4,5,6,7,8,9};
		TreeNode root = bst.sortedArrayToBST(num );
		TreeNode.printNode(root);
	}
	
}
