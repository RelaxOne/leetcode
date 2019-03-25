package org.relaxone;

import org.relaxone.common.TreeNode;

public class L43_BuildTree {

	public TreeNode buildTree(int[] inorder,int[] postorder) {
		
		if(inorder.length != postorder.length || inorder == null || postorder == null || postorder.length == 0)
			return null;
		
		int index = 0;	// 根节点在中序遍历中的位置
		for(int i  = 0;i<postorder.length;i++) {
			if(inorder[i] == postorder[postorder.length-1]) {
				index = i;
				break;
			}
		}
		int[] left_inorder = new int[index];
		int[] left_postorder = new int[index];

		int[] right_inorder = new int[postorder.length-index-1];
		int[] right_postorder = new int[postorder.length-index-1];
		for(int i =0 ;i<index;i++) {
			left_inorder[i] = inorder[i];
			left_postorder[i] = postorder[i];
		}
		for(int i = index+1;i<postorder.length;i++) {
			right_inorder[i-index -1] = inorder[i];
			right_postorder[i-index -1] = postorder[i-1];
		}
		TreeNode node = new TreeNode(inorder[index]);
		node.left = buildTree(left_inorder, left_postorder);
		node.right = buildTree(right_inorder, right_postorder);
		return node;
	}
	
	public static void main(String[] args) {
		L43_BuildTree buildTree = new L43_BuildTree();
		int[] postorder = {1,2};
		int[] inorder = {2,1};
		TreeNode root = buildTree.buildTree(inorder , postorder);
		TreeNode.printNode(root);
	}
	
}
