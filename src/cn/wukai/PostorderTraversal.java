package cn.wukai;

import java.util.ArrayList;
import java.util.List;

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
	private static void helper(TreeNode root) {
		
	}
}
