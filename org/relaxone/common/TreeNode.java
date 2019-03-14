package org.relaxone.common;

public class TreeNode {

	public int val;

	public TreeNode left = null;
	public TreeNode right = null;

	public TreeNode(int val){
		this.val = val;
	}
	
	/**
	 * 用前序遍历的方法打印二叉树
	 * @param root
	 */
	public static void printNode(TreeNode root) {
		if(root == null)
			return;
		System.out.print(root.val + " ");
		printNode(root.left);
		printNode(root.right);
	}
	
	/**
	 * 初始化一个二叉树
	 * @return
	 */
	public static TreeNode init() {
		TreeNode root = new TreeNode(5);
		TreeNode left1 = new TreeNode(6);
		TreeNode right1 = new TreeNode(7);
		TreeNode left_left = new TreeNode(8);
		TreeNode left_2 = new TreeNode(9);

		TreeNode right_2 = new TreeNode(15);
		TreeNode right_right = new TreeNode(10);

		root.left = left1;
		root.right = right1;

		left1.left = left_left;
		left1.right = left_2;

		left_left.left = null;
		left_left.right = null;

		left_2.left = null;
		left_2.right = null;

		right1.left = right_2;
		right1.right = right_right;

		right_right.left = null;
		right_right.right = null;

		right_2.left = null;
		right_2.right = null;
		
		return root;
	}
}
