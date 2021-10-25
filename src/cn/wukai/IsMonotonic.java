package cn.wukai;

import java.util.Iterator;

/**
 * 
 * @author wukai
 *如果数组是单调递增或单调递减的，那么它是单调的。
如果对于所有 i <= j，A[i] <= A[j]，那么数组 A 是单调递增的。 
如果对于所有 i <= j，A[i]> = A[j]，那么数组 A 是单调递减的。
当给定的数组 A 是单调数组时返回 true，否则返回 false。

示例 1：
输入：[1,2,2,3]
输出：true
示例 2：
输入：[6,5,4,4]
输出：true
示例 3：
输入：[1,3,2]
输出：false
示例 4：
输入：[1,2,4,5]
输出：true
示例 5：
输入：[1,1,1]
输出：true

提示：
1 <= A.length <= 50000
-100000 <= A[i] <= 100000

 */

public class IsMonotonic {

	public static void main(String[] args) {
		int[] nums = {1,1,1};
		System.out.println(solution(nums));
	}
	
	//两次遍历
	public static boolean  solution(int[] A) {
		return helper(A, false) || helper(A, true);
	}
	
	private static boolean helper(int[] nums,boolean isIncreasing) {
		if(isIncreasing) {
			for (int i = 0; i < nums.length - 1; i++) {
				if(nums[i] > nums[i + 1])
					return false;
			}
		}else {
			for (int i = 0; i < nums.length - 1; i++) {
				if (nums[i] < nums[i + 1]) {
					return false;
				}
			}
		}
		return true;
	}
	
	//一次遍历
	public static boolean solution2(int[] A) {
		boolean inCre = true;
		boolean deCre = true;
		for (int i = 0; i < A.length - 1; i++) {
			if(A[i] < A[i + 1]) {
				deCre = false;
			}
			if (A[i] > A[i + 1]) {
				inCre = false;
			}
		}
		return inCre && deCre;
	}
	
	
}
