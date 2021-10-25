package cn.wukai;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 
 * @author wukai
 *993. 二叉树的堂兄弟节点
在二叉树中，根节点位于深度 0 处，每个深度为 k 的节点的子节点位于深度 k+1 处。
如果二叉树的两个节点深度相同，但 父节点不同 ，则它们是一对堂兄弟节点。
我们给出了具有唯一值的二叉树的根节点 root ，以及树中两个不同节点的值 x 和 y 。
只有与值 x 和 y 对应的节点是堂兄弟节点时，才返回 true 。否则，返回 false。

示例 1：
输入：root = [1,2,3,4], x = 4, y = 3
输出：false
示例 2：
输入：root = [1,2,3,null,4,null,5], x = 5, y = 4
输出：true
示例 3：
输入：root = [1,2,3,null,4], x = 2, y = 3
输出：false

提示：
二叉树的节点数介于 2 到 100 之间。
每个节点的值都是唯一的、范围为 1 到 100 的整数。
 */

public class IsCousins {

	private TreeNode fatherA;
	private int deepA;
	private int x;
	private boolean foundA;
	private int y;
	private TreeNode fatherB; 
	private int deepB;
	private boolean foundB;
	
	public boolean solution(TreeNode root, int x, int y) {
		if(null == root) {
			return false;
		}
		this.x = x;
		this.y = y;
		
		dps(root,0,null);
		return fatherA != fatherB && deepA == deepB;
	}

	private void dps(TreeNode node, int deep, TreeNode father) {
		if(node == null) {
			return;
		}
		if(node.val == x) {
			deepA = deep;
			fatherA = father;
			foundA = true;
		}else if(node.val == y) {
			deepB = deep;
			fatherB = father;
			foundB = true;
		}
		
		if(foundA &&  foundB) {
			return ;
		}
		dps(node.left, deep + 1, node);
		if(foundA && foundB) {
			return ;
		}
		dps(node.right, deep + 1, node);
	}
	
	public boolean solution2(TreeNode root, int x,int y) {
		
		if(null == root) {
			return false;
		}
		this.x = x;
		this.y = y;
		
		Queue<TreeNode> queueNode = new LinkedList<>();
		Queue<Integer> queuedeep = new LinkedList<Integer>();
		queuedeep.offer(0);
		queueNode.offer(root);
		update(root,0,null);
		while(!queueNode.isEmpty()) {
			TreeNode node = queueNode.poll();
			int deep = queuedeep.poll();
			
			if(node.left != null) {
				queueNode.offer(node.left);
				queuedeep.offer(deep + 1);
				update(node.left, deep + 1,node);
			}
			
			if(node.right != null) {
				queuedeep.offer(deep + 1);
				queueNode.offer(node.right);
				update(node.right, deep + 1, node);
			}
			
			if(foundA && foundB) {
				break;
			}
			
		}
		
		return fatherA != fatherB && deepA == deepB;
	}

	private void update(TreeNode node, int deep, TreeNode father) {
		// TODO Auto-generated method stub
		if(node.val == x) {
			fatherA = father;
			deepA = deep;
			foundA = true;
		}else if(node.val == y) {
			fatherB = father;
			deepB = deep;
			foundB = true;
		}
	}
}
