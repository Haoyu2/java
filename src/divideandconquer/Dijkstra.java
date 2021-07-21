package divideandconquer;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class Dijkstra {



    public static int[][] shortestPath(int[][][] adj, int s, int num){

        int[] dis = new int[num], pre = new int[num];
        Arrays.fill(dis, Integer.MAX_VALUE); dis[s] = 0;

        Queue<Integer> pq = new PriorityQueue<>(num, (a, b)->dis[a] - dis[b]);
        for (int i = 0; i < num; i++) pq.add(i);

        while (!pq.isEmpty()){
            int u = pq.poll();
            for (int[] e : adj[u] ){
                int v = e[0], uv = e[1];
//                System.out.println(v);
                if (dis[v] > dis[u] + uv) {
                    pq.remove(v);
                    dis[v] = dis[u] + uv;
                    pq.add(v);
                    pre[v] = u;
                }
            }
        }
        return new int[][]{dis, pre};
    }

    public static void main(String[] args) {
        int[][][] adj = new int[][][]{
                {{1, 5},{7, 8}, {4, 9}},
                {{7,4},{3,15},{2,12}},
                {{3,3},{6,11}},
                {{3,9}},
                {{7,5},{5,4},{6,20}},
                {{2,1},{6,13}},
                {},
                {{2,7},{5,6}}

        };

        System.out.println(Arrays.toString(shortestPath(adj, 0, 8)[0]));
        System.out.println(Arrays.toString(shortestPath(adj, 0, 8)[1]));

//        Queue<Integer> pq= new PriorityQueue<>();
//        pq.add(1);pq.add(2);
//        pq.remove(2);
//        System.out.println(pq.poll());
//        System.out.println(pq.poll());

    }
}
