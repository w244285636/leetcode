package cn.wukai;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * 
 * @author wukai
 *684. 冗余连接
在本问题中, 树指的是一个连通且无环的无向图。

输入一个图，该图由一个有着N个节点 (节点值不重复1, 2, ..., N) 的树及一条附加的边构成。
附加的边的两个顶点包含在1到N中间，这条附加的边不属于树中已存在的边。
结果图是一个以边组成的二维数组。每一个边的元素是一对[u, v] ，满足 u < v，表示连接顶点u 和v的无向图的边。
返回一条可以删去的边，使得结果图是一个有着N个节点的树。如果有多个答案，则返回二维数组中最后出现的边。
答案边 [u, v] 应满足相同的格式 u < v。

示例 1：
输入: [[1,2], [1,3], [2,3]]
输出: [2,3]
解释: 给定的无向图为:
  1
 / \
2 - 3
示例 2：
输入: [[1,2], [2,3], [3,4], [1,4], [1,5]]
输出: [1,4]
解释: 给定的无向图为:
5 - 1 - 2
    |   |
    4 - 3
注意:
输入的二维数组大小在 3 到 1000。
二维数组中的整数在1到N之间，其中N是输入数组的大小。
 */

public class FindRedundantConnection {

	public static void main(String[] args) {
		int[][] edges = {{1,2},{1,3},{2,3}};
		int[][] d1 = {{1,2}, {2,3}, {3,4}, {1,4}, {1,5}};
		int[] ans = solution(edges);
		for (int i : ans) {
			System.out.print(i + " ");
		}
	}
	
	public static int[] solution(int[][] edges) {
		
		Map<Integer, List<Integer>> map = new HashMap<>();
		for (int i = 0; i < edges.length; i++) {
			int n0 = edges[i][0];
			int n1 = edges[i][1];
			putNum(n0, n1, map);
			putNum(n1, n0, map);
		}
		int key = 0;
		boolean isTrue = false;
		for (Entry<Integer, List<Integer>> entry : map.entrySet()) {
			if (entry.getValue().size() >= 3) {
				key = entry.getKey();
				isTrue = true;
				break;
			}
		}
		if (!isTrue) {
			return edges[edges.length - 1];
		}
		for (int i = edges.length - 1; i >= 0; i--) {
			if (edges[i][0] == key && map.get(edges[i][1]).size() > 1) {
				return getAns(key,edges[i][1]);
			}
			if (edges[i][1] == key && map.get(edges[i][0]).size() > 1) {
				return getAns(key,edges[i][0]);
			}
		}
	
		return null;
	}
	
	private static int[] getAns(int key, int i) {
		// TODO Auto-generated method stub
		return key > i ? new int[] {i,key} : new int[] {key,i};
	}

	private static void putNum(int n0,int n1, Map<Integer, List<Integer>> map) {
		if (map.containsKey(n0)) {
			List<Integer> l = map.get(n0);
			l.add(n1);
			map.put(n0, l);
		}else {
			List<Integer> l = new ArrayList<>();
			l.add(n1);
			map.put(n0, l);
		}
	}
	
}
