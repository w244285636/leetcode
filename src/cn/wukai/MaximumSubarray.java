package cn.wukai;

/**
 * 
 * @author wukai
 *Find the contiguous subarray within an array (containing at least one number) which has the largest sum.
For example, given the array [−2,1,−3,4,−1,2,1,−5,4] , the contiguous subarray [4,−1,2,1] has
the largest sum = 6 .

求最大连续子序列之和
 */

public class MaximumSubarray {
	
	public static void main(String[] args) {
		int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
		System.out.println(solution(nums));
	}

	/**
	 * 使用动态规划
	 * 遍历数组 获取最大子序列时候，对于第J位 如果前j-1位大于0 则该位置最大子序列和为F[j - 1] + n[j]
	 * 否则为n[j]
	 * 递推公式：
	 * F[j] = max{F[j - 1] + n[j],n[j]}
	 * result = max{F}
	 * @param nums
	 * @return
	 */
	public static int solution(int[] nums) {
		if(null == nums || nums.length == 0) {
			return 0;
		}
		
		int[] f = new int[nums.length];
		f[0] = nums[0];
		int ans = f[0];
		for (int i = 1; i < nums.length; i++) {
			f[i] = Math.max(f[i - 1] + nums[i], nums[i]);
			ans = Math.max(ans, f[i]);
		}
		
		return ans;
	}
	
}
