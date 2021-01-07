package cn.wukai;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 
 * @author wukai
 *给定一个二叉树，返回它的 后序 遍历。

示例:

输入: [1,null,2,3]  
   1
    \
     2
    /
   3 

输出: [3,2,1]
进阶: 递归算法很简单，你可以通过迭代算法完成吗？

 */

public class PostorderTraversal {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.right = new TreeNode(2);
		root.right.left = new TreeNode(3);
		List<Integer> ans = helper(root);
		for (Integer integer : ans) {
			System.out.print(integer + " ");
		}
	}
	
	public static List<Integer> solution(TreeNode root){
		List<Integer> ans = new ArrayList<>();
		helper(root,ans);
		return ans;
	}
	
	/*
	 * 递归方法
	 */
	private static void helper(TreeNode root,List<Integer> ans) {
		if (root == null) {
			return ;
		}
		helper(root.left, ans);
		helper(root.right, ans);
		ans.add(root.val);
	}
	
	/*
	 * 迭代方法
	 */
	private static List<Integer> helper(TreeNode root) {
		List<Integer> ans = new ArrayList<>();
		if (root == null) {
			return ans;
		}
		Stack<TreeNode> stack = new Stack<>();
		TreeNode pre = null;
		while(root != null || !stack.isEmpty()) {
			while(root != null) {
				stack.push(root);
				root = root.left;
			}
			root = stack.pop();
			if (root.right == null || root.right == pre) {
				ans.add(root.val);
				pre = root;
				root = null;
			}else {
				stack.push(root);
				root = root.right;
			}
		}
		return ans;
	}
}
