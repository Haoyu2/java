package divideandconquer;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;


public class Prim {
    public static int[][] mst(int[][][] adj, int num) {
        int[] dis = new int[num], pre = new int[num];
        boolean[] seen = new boolean[num];
        Arrays.fill(dis, Integer.MAX_VALUE);
        dis[0] = 0;

        Queue<Integer> pq = new PriorityQueue<>(num, (a, b) -> dis[a] - dis[b]);
        for (int i = 0; i < num; i++) {
            pq.add(i);
        }
        int[][] res = new int[num - 1][];
        int k = 0;
        while (!pq.isEmpty()) {
            int u = pq.poll();
            seen[u] = true;
            if (u != 0) res[k++] = new int[]{pre[u], u};

            for (int[] edge : adj[u]) {
                int v = edge[0], uv = edge[1];
                if (!seen[v] && uv < dis[v]) {
                    pq.remove(v);
                    dis[v] = uv;
                    pre[v] = u;
                    pq.add(v);
                }
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

        System.out.println(Arrays.deepToString(mst(adj, 8)));
    }
}
