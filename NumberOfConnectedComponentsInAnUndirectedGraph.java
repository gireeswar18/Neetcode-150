package neetcode150;

import java.util.*;

public class NumberOfConnectedComponentsInAnUndirectedGraph {

	public static void main(String[] args) {

		int[][] t1 = { { 0, 1 }, { 2, 1 }, { 3, 4 } };
		System.out.println(connectedcomponents(5, t1));

		int[][] t2 = { { 0, 1 }, { 6, 1 }, { 2, 4 }, { 2, 3 }, { 3, 4 } };
		System.out.println(connectedcomponents(7, t2));

	}

	public static void dfs(int curr, ArrayList<ArrayList<Integer>> adjList, boolean[] visited,
			ArrayList<Integer> currList) {
		
		visited[curr] = true;
		currList.add(curr);
		
		for (int child : adjList.get(curr)) {
			if (!visited[child]) {
				dfs(child, adjList, visited, currList);
			}
		}
	}

	public static ArrayList<ArrayList<Integer>> connectedcomponents(int v, int[][] edges) {
		boolean[] visited = new boolean[v];
		ArrayList<ArrayList<Integer>> res = new ArrayList<>();

		// create adjList
		ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
		for (int i = 0; i < v; i++) {
			adjList.add(new ArrayList<>());
		}

		for (int[] edge : edges) {
			adjList.get(edge[0]).add(edge[1]);
			adjList.get(edge[1]).add(edge[0]);
		}
				
		for (int i = 0; i < v; i++) {
			if (!visited[i]) {
				ArrayList<Integer> list = new ArrayList<>();
				
				dfs(i, adjList, visited, list);
				Collections.sort(list);
				
				res.add(list);
			}
		}
		

		return res;

	}
}
