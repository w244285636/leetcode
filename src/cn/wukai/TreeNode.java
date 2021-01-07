package cn.wukai;

/**
 * 
 * @author wukai
 * 本leetcode算法中的常规二叉树
 */

public class TreeNode {

	TreeNode left;
	TreeNode right;
	int val;
	
	public TreeNode() {
		
	}
	
	public TreeNode(int val) {
		this.val = val;
	}
	
	public TreeNode(int val,TreeNode left,TreeNode right) {
		this.val = val;
		this.right = right;
		this.left = left;
	}
	
}
