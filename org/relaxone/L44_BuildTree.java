package org.relaxone;

import org.relaxone.common.TreeNode;

public class L44_BuildTree {

public TreeNode buildTree(int[] preorder,int[] inorder) {
		
		if(inorder.length != preorder.length || inorder == null || preorder == null || preorder.length == 0)
			return null;
		
		int index = 0;	// 根节点在中序遍历中的位置
		for(int i  = 0;i<preorder.length;i++) {
			if(inorder[i] == preorder[0]) {
				index = i;
				break;
			}
		}
		int[] left_preorder = new int[index];
		int[] left_inorder = new int[index];

		int[] right_preorder = new int[preorder.length-index-1];
		int[] right_inorder = new int[preorder.length-index-1];
		for(int i =0 ;i<index;i++) {
			left_preorder[i] = preorder[i+1];
			left_inorder[i] = inorder[i];
		}
		for(int i = index+1;i<preorder.length;i++) {
			right_preorder[i-index -1] = preorder[i];
			right_inorder[i-index -1] = inorder[i];
		}
		TreeNode node = new TreeNode(inorder[index]);
		node.left = buildTree(left_preorder, left_inorder);
		node.right = buildTree(right_preorder, right_inorder);
		return node;
	}
	
}
