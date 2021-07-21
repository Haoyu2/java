package divideandconquer;

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class Kruskal {
    public static int[][] adj2edgs(int[][][] adj){
        int n = 0;
        for (int i = 0; i < adj.length; i++) {
            n += adj[i].length;
        }

        int[][] edges = new int[n][];
        for (int i = 0, k = 0; i < adj.length; i++) {
            for (int j = 0; j < adj[i].length; j++) {
                edges[k++] = new int[]{i, adj[i][j][0],adj[i][j][1]};
            }
        }
        return edges;
    }

    public static int[][] mst(int[][][] adj, int num) {
        int[][] edges = adj2edgs(adj);
        Arrays.sort(edges, (a, b)-> a[2]-b[2]);
        int[][] res = new int[num - 1][];
        WeightedQuickUnionUF uf = new WeightedQuickUnionUF(num);
        for (int i = 0, k=0; i < edges.length; i++) {
            int u = edges[i][0], v =edges[i][1];
            if (uf.find(u)!=uf.find(v)) { // this is testing creats a cycle or not
                res[k++] = new int[]{u,v};
                uf.union(u,v);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][][] adj = new int[][][]{
                {{1, 4}, {2, 6}, {3, 16}},
                {{0, 4}, {5, 24}},
                {{0, 6}, {3, 8}, {4, 5}, {5, 23}},
                {{0, 16}, {2, 8}, {4, 10}, {3, 21}},
                {{2, 5}, {3, 10}, {5, 18}, {6, 11}, {7, 14}},
                {{1, 24}, {2, 23}, {4, 18}, {6, 9}},
                {{4, 11}, {5, 9}, {7, 7}},
                {{3, 21}, {4, 14}, {6, 7}}
        };

        System.out.println(Arrays.deepToString(Prim.mst(adj, 8)));
        System.out.println(Arrays.deepToString(mst(adj, 8)));
    }
}
