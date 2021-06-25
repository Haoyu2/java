package dp;

import java.util.*;

public class Knapsack {

    public static int[] maxValue_items(int limit, int[] vs, int[] ws) {

        List<Integer> items = new ArrayList<>();

        int lm = vs.length + 1;
        List<Integer>[][] M = new ArrayList[lm][limit + 1];
        for (int i = 0; i < M.length; i++) {
            M[i][0] = new ArrayList<Integer>();
            M[i][0].add(0);
        }
        for (int i = 0; i < M[0].length; i++) {
            M[0][i] = new ArrayList<Integer>();
            M[0][i].add(0);
        }
        // the arraylist contains maxValues and the rest of item
        for (int i = 1; i < lm; i++) {
            for (int w = 0; w < limit + 1; w++) {
                if (ws[i - 1] > w) M[i][w] = M[i - 1][w];
                else{

                    int case1 = M[i-1][w].get(0);
                    int case2 = vs[i - 1] + M[i - 1][w - ws[i - 1]].get(0);

                    if ( case1 > case2)M[i][w] = M[i - 1][w];
                    else{
                        List<Integer> cur = new ArrayList<>(M[i - 1][w - ws[i - 1]]);
                        cur.add(i-1);
                        cur.set(0, case2);
                        M[i][w] = cur;
                    }
                }
            }
        }

        int[] res = new int[M[vs.length][limit].size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = M[vs.length][limit].get(i);
        }
        return res;
    }

    public static int maxValue(int limit, int[] vs, int[] ws) {
        int lm = vs.length + 1;
        int[][] M = new int[lm][limit + 1];

        for (int i = 1; i < lm; i++) {
            for (int w = 0; w < limit + 1; w++) {
                if (ws[i - 1] > w) M[i][w] = M[i - 1][w];
                else M[i][w] = Math.max(M[i - 1][w],
                        vs[i - 1] + M[i - 1][w - ws[i - 1]]);
            }
        }

        return M[vs.length][limit];
    }

    public static void main(String[] args) {
        int[] vs = new int[]{28, 22, 18, 6, 1};

        int[] ws = new int[]{7, 6, 5, 2, 1};
//        Arrays.sort(vs, (int a, int b) -> Integer.compare(a, b));

        int limit = 11;
        System.out.println(maxValue(limit, vs, ws));
        System.out.println(Arrays.toString(maxValue_items(limit,vs,ws)));
    }

}
