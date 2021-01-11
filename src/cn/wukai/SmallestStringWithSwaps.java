package cn.wukai;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 
 * @author wukai
 *1202. 交换字符串中的元素
给你一个字符串 s，以及该字符串中的一些「索引对」数组 pairs，
其中 pairs[i] = [a, b] 表示字符串中的两个索引（编号从 0 开始）。
你可以 任意多次交换 在 pairs 中任意一对索引处的字符。
返回在经过若干次交换后，s 可以变成的按字典序最小的字符串。

示例 1:
输入：s = "dcab", pairs = [[0,3],[1,2]]
输出："bacd"
解释： 
交换 s[0] 和 s[3], s = "bcad"
交换 s[1] 和 s[2], s = "bacd"
示例 2：
输入：s = "dcab", pairs = [[0,3],[1,2],[0,2]]
输出："abcd"
解释：
交换 s[0] 和 s[3], s = "bcad"
交换 s[0] 和 s[2], s = "acbd"
交换 s[1] 和 s[2], s = "abcd"
示例 3：
输入：s = "cba", pairs = [[0,1],[1,2]]
输出："abc"
解释：
交换 s[0] 和 s[1], s = "bca"
交换 s[1] 和 s[2], s = "bac"
交换 s[0] 和 s[1], s = "abc"

提示：
1 <= s.length <= 10^5
0 <= pairs.length <= 10^5
0 <= pairs[i][0], pairs[i][1] < s.length
s 中只含有小写英文字母
 */

public class SmallestStringWithSwaps {

	public static void main(String[] args) {
		List<List<Integer>> pairs = new ArrayList<>();
		List<Integer> l1= new ArrayList<Integer>();
		l1.add(1);
		l1.add(3);
		List<Integer> l2 = new ArrayList<>();
		l2.add(1);
		l2.add(2);
		pairs.add(l1);
		pairs.add(l2);
		String s = "bcadhfge";
		System.out.println(solution(s, pairs));
	}
	
	
	/**
	 * 使用并查集的方法进行判断
	 * @param s
	 * @param pairs
	 * @return
	 */
	public static String solution(String s, List<List<Integer>> pairs) {
		int n = s.length();
		UnionFind unionFind = new UnionFind(n);
		for (List<Integer> list : pairs) {
			int index1 = list.get(0);
			int index2 = list.get(1);
			unionFind.union(index1, index2);
		}
		char[] chs = s.toCharArray();
		Map<Integer, PriorityQueue<Character>> map = new HashMap<>();
		for (int i = 0; i < n; i++) {
			int root = unionFind.find(i);
//			if (map.containsKey(root)) {
//				map.get(root).offer(chs[i]);
//			}else {
//				PriorityQueue<Character> queue = new PriorityQueue<>();
//				queue.offer(chs[i]);
//				map.put(root, queue);
//			}
			
			//上面6行代码 可以用以下代码一句完成
			map.computeIfAbsent(root, key -> new PriorityQueue<>()).offer(chs[i]);
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			int root = unionFind.find(i);
			sb.append(map.get(root).poll());
		}
		
		return sb.toString();
	}
	
	private static class UnionFind{
		private int[] parent;
		private int[] rank;
		public UnionFind(int n) {
			this.parent = new int[n];
			this.rank = new int[n];
			for (int i = 0; i < n; i++) {
				parent[i] = i;
				rank[i] = 1;
			}
		}
		
		public void union(int x,int y) {
			int rootX = find(x);
			int rootY = find(y);
			if (rootX == rootY) {
				return;
			}
			if (rank[rootX] == rank[rootY]) {
				parent[rootX] = rootY;
				rank[rootY]++;
			}else if (rank[rootX] < rank[rootY]) {
				parent[rootX] = rootY;
			}else {
				parent[rootY] = rootX;
			}
		}
		
		public int find(int x) {
			if (x != parent[x]) {
				parent[x] = find(parent[x]);
			}
			return parent[x];
		}
	}
}
