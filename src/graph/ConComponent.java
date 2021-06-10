package graph;

import java.util.*;

public class ConComponent {
    static List<Integer>[] adjList;
    static int[] visited;
    public static void dfs(int startNode) {
        visited[startNode] = 1;

        for (int i = 0; i < adjList[startNode].size(); i++) {
            if (visited[adjList[startNode].get(i)] == 0) {
                dfs(adjList[startNode].get(i));
            }
        }
    }

    public static int countComponents(int n, int[][] edges) {
        int components = 0;
        visited = new int[n];
        adjList = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adjList[i] = new ArrayList<Integer>();
        }

        for (int i = 0; i < edges.length; i++) {
            adjList[edges[i][0]].add(edges[i][1]);
            adjList[edges[i][1]].add(edges[i][0]);
        }

        for (int i = 0; i < n; i++) {
            if (visited[i] == 0) {
                components++;
                dfs(i);
            }
        }
        return components;
    }

    public static void main(String[] args) {
        int n = 5;
        int[][] edges1 = new int[][]{{0,1},{1,2},{3,4}};
        int[][] edges2 = new int[][]{{0,1},{1,2},{2,3},{3,4}};
        System.out.println(countComponents(n, edges1));
        System.out.println(countComponents(n, edges2));

    }
}
