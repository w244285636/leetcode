package cn.wukai;

/**
 * 
 * @author wukai
 *
 */

public class JumpGame {

	public static void main(String[] args) {
		int[] nums = {1,2,1};
		System.out.println(solution3(nums));
	}
	
	public static boolean solution(int[] nums) {
		if(nums == null || nums.length == 0) {
			return true;
		}
		int reach = 1;
		for (int i = 0; i < reach && reach < nums.length; i++) {
			reach = Math.max(reach, i + 1 + nums[i]);
		}
		return reach >= nums.length;
	}
	
	public static boolean solution2(int[] nums) {
		if(null == nums || nums.length == 0) {
			return true;
		}
		
		int leftMost = nums.length - 1;
		
		for (int i = nums.length - 2; i >= 0; i--) {
			if(i + nums[i] >= leftMost) {
				leftMost = i;
			}
		}
		return leftMost == 0;
	}
	
	public static boolean solution3(int[] nums) {
		if(null == nums || nums.length == 0) {
			return false;
		}
		int[] f = new int[nums.length];
		for (int i = 1; i < f.length; i++) {
			f[i] = Math.max(f[i - 1], nums[i - 1]) - 1;
			if(f[i] < 0) {
				return false;
			}
		}
		return true;
	}
	
}
