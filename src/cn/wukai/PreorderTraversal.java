package cn.wukai;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 
 * @author wukai
 *给你二叉树的根节点 root ，返回它节点值的 前序 遍历。
示例 1：
输入：root = [1,null,2,3]
输出：[1,2,3]
示例 2：
输入：root = []
输出：[]
示例 3：
输入：root = [1]
输出：[1]
示例 4：
输入：root = [1,2]
输出：[1,2]
示例 5：
输入：root = [1,null,2]
输出：[1,2]
提示：
树中节点数目在范围 [0, 100] 内
-100 <= Node.val <= 100
进阶：递归算法很简单，你可以通过迭代算法完成吗？

 */

public class PreorderTraversal {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(1);
		root.left.right = new TreeNode(1);
		List<Integer> ans = helper(root);
		for (Integer integer : ans) {
			System.out.print(integer + " ");
		}
	}
	
	public static List<Integer> solution(TreeNode root){
		List<Integer> ans = new ArrayList<Integer>();
		helper(root, ans);
		return ans;
	}
	
	/*
	 * 递归方法
	 */
	private static void helper(TreeNode root,List<Integer> ans){
		if (root == null) {
			return ;
		}
		ans.add(root.val);
		helper(root.left, ans);
		helper(root.right, ans);
	}
	
	/*
	 * 迭代方法
	 */
	public static List<Integer> helper(TreeNode root) {
		List<Integer> ans = new ArrayList<>();
		Stack<TreeNode> stack = new Stack<TreeNode>();
		if (root != null) {
			stack.push(root); //注意这里的判断 不然会报空指针异常
		}
		while(!stack.isEmpty()) {
			TreeNode node = stack.pop();
			ans.add(node.val);
			if (node.right != null) {
				stack.push(node.right);
			}
			if (node.left != null) {
				stack.push(node.left);
			}
		}
		return ans;
	}
	
}
