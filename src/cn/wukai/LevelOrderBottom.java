package cn.wukai;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 
 * @author wukai
 *107. 二叉树的层序遍历 II
给定一个二叉树，返回其节点值自底向上的层序遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）

例如：
给定二叉树 [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7
返回其自底向上的层序遍历为：

[
  [15,7],
  [9,20],
  [3]
]
 */

public class LevelOrderBottom {

	public static List<List<Integer>> solution(TreeNode root){
		List<List<Integer>> ans = new ArrayList<>();
		if (root == null) {
			return ans;
		}
		
		Queue<TreeNode> q = new LinkedList<>();
		q.offer(root);
		while(!q.isEmpty()) {
			//tr
		}
		
		Queue<Node> queue = new LinkedList<>();
		//queue.offer(new Node(root, 0));
		int index = 0;
		List<Integer> list = new ArrayList<>();
		while(!queue.isEmpty()) {
			Node node = queue.poll();
			if (index == node.index) {
				
			}
		}
		return ans;
	}
	
	private class Node{
		TreeNode node;
		int index;
		public Node(TreeNode node, int index) {
			this.node = node;
			this.index = index;
		}
	}
	
}
