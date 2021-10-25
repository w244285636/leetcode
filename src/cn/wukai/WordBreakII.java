package cn.wukai;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * 
 * @author wukai
 *Given a string s and a dictionary of words dict, add spaces in s to 
 *construct a sentence where each word
is a valid dictionary word.
Return all such possible sentences.

For example, given
s = "catsanddog" ,

dict = ["cat", "cats", "and", "sand", "dog"] .
A solution is ["cats and dog", "cat sand dog"] .
 */

public class WordBreakII {

	
	public static void main(String[] args) {
		String s = "catsanddog";
		Set<String> set = new HashSet<>();
		set.add("cat");
		set.add("cats");
		set.add("and");
		set.add("sand");
		set.add("dog");
		List<String> ans = solution(s, set);
		for (String string : ans) {
			System.out.println(string);
		}
	}
	
	public static List<String> solution(String s ,Set<String> dict){
		if(null == s || s.length() == 0) {
			return null;
		}
		List<String> ans = new ArrayList<>();
		
		boolean[] f = new boolean[s.length() + 1];
		boolean[][] flag = new boolean[s.length() + 1][s.length()];
		f[0] = true;
		for (int i = 1; i <= s.length(); ++i) {
			for (int j = i - 1; j >= 0; --j) {
				if(f[j] && dict.contains(s.substring(j, i))) {
					f[i] = true;
					flag[i][j] = true;
				}
			}
		}
		
		List<String> result = new ArrayList<>();
		List<String> path = new ArrayList<>();
		getPath(s,flag,s.length(),result,path);
		return result;
	}

	private static void getPath(String s, boolean[][] flag,int cur, List<String> result, List<String> path) {
		// TODO Auto-generated method stub
		if(cur == 0) {
			StringBuilder sb = new StringBuilder();
			for (String str : path) {
				sb.append(str).append(" ");
			}
			sb.deleteCharAt(sb.length() - 1);
			result.add(sb.toString());
		}
		
		for (int i = 0; i < s.length(); i++) {
			if(flag[cur][i]) {
				path.add(s.substring(i, cur));
				getPath(s, flag, i, result, path);
				path.remove(s.substring(i, cur));
			}
		}
	}
	
}
