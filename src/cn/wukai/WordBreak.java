package cn.wukai;

import java.util.HashSet;
import java.util.Set;

/**
 * 
 * @author wukai
 *Given a string s and a dictionary of words dict,
 * determine if s can be segmented into a space-separated
sequence of one or more dictionary words.
For example, given
s = "leetcode" ,
dict = ["leet", "code"] .
Return true because "leetcode" can be segmented as "leet code" .

 */

public class WordBreak {

	public static void main(String[] args) {
		String s = "leetcode";
		Set<String> dict = new HashSet<>();
		dict.add("leet");
		dict.add("code");
		System.out.println(solution2(s, dict));
	}
	
	/**
	 * f[i]为状态方程
	 * f[i] = f[j] && s[j,i] in dict 0 <= j < i
	 * @param s
	 * @param dict
	 * @return
	 */
	public static boolean solution(String s ,Set<String> dict) {
		if(null == s || s.length() == 0) {
			return false;
		}
		boolean[] f = new boolean[s.length()];
		f[0] = dict.contains(s.charAt(0)) ? true : false;
		for (int i = 1; i < f.length; i++) {
			for (int j = 0; j <= i; j++) {
				String tmp = s.substring(j, i + 1);
				//f[i] = f[j - 1] && dict.contains(tmp);
				if(j == 0) {
					f[i] = dict.contains(tmp);
				}else {
					f[i] = f[j - 1] && dict.contains(tmp);
				}
				if(f[i]) {
					break;
				}
			}
		}
		return f[f.length - 1];
		
	}
	
	/**
	 * 递归进阶版
	 * @param s
	 * @param dict
	 * @return
	 */
	public static boolean solution2(String s, Set<String> dict) {
		if(null == s || s.length() == 0) {
			return false;
		}
		
		boolean[] f = new boolean[s.length() + 1];
		f[0] = true;
		
		for (int i = 1; i <= s.length(); i++) {
			for (int j = i - 1; j >= 0; --j) {
				if(f[j] && dict.contains(s.substring(j, i))) {
					f[i] = true;
					break;
				}
			}
		}
		
		return f[f.length - 1];
	}
	
}
