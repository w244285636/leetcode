package cn.wukai;

import java.util.Arrays;
import java.util.Iterator;

/**
 * 
 * @author wukai
 * 189.旋转数组
 *给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
示例 1:
输入: [1,2,3,4,5,6,7] 和 k = 3
输出: [5,6,7,1,2,3,4]
解释:
向右旋转 1 步: [7,1,2,3,4,5,6]
向右旋转 2 步: [6,7,1,2,3,4,5]
向右旋转 3 步: [5,6,7,1,2,3,4]
示例 2:
输入: [-1,-100,3,99] 和 k = 2
输出: [3,99,-1,-100]
解释: 
向右旋转 1 步: [99,-1,-100,3]
向右旋转 2 步: [3,99,-1,-100]
说明:
尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。
要求使用空间复杂度为 O(1) 的 原地 算法。
 */

public class Rotate {

	public static void main(String[] args) {
		int[] nums = {1,2,3,4,5,6,7};
		solution(nums, 3);
		for (int i : nums) {
			System.out.print(i + " ");
		}
	}
	
	/*
	 * 暴力遍历....时间复杂度o（nk）比较愚蠢
	 */
	public static void solution(int[] nums, int k) {
		int n = nums.length;
		for (int i = 0; i < k; i++) {
			int tmp = nums[n - 1];
			for (int j = 0; j < nums.length; j++) {
				int a = nums[j];
				nums[j] = tmp;
				tmp = a;
			}
		}
	}
	
	/*
	 * 使用额外数组进行调整
	 */
	public static void solution2(int[] nums, int k) {
		int n = nums.length;
		int[] newNums = new int[n];
		for (int i = 0; i < newNums.length; i++) {
			newNums[(i + k) % n] = nums[i];
		}
		System.arraycopy(newNums, 0, nums, 0, n);
	}
	
	/*
	 * 使用数组反转 先将数组翻转，然后分别对前0 ~ (k mod n) - 1翻转，对后面(k mod n) ~ n - 1翻转
	 * 1234567-7654321-4567123
	 */
	public static void solution3(int[] nums, int k) {
		int n = nums.length;
		k %= n;
		reverse(nums, 0, n - 1);
		reverse(nums, 0, k - 1);
		reverse(nums, k, n - 1);
	}
	
	private static void reverse(int[] nums,int start,int end) {
		while(start < end) {
			int tmp = nums[start];
			nums[start] = nums[end];
			nums[end] = tmp;
			start++;
			end--;
		}
	}
}
