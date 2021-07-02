package dp;

import java.lang.reflect.Array;
import java.util.Arrays;

public class SequenceAlignment {

    /**
     * @param s1
     * @param s2
     * @param delta penalty for gap
     * @param alpha penalty for mismatch
     * @return min edit cost
     */
    public static int minEditCost(String s1, String s2, int delta, int alpha) {
        int l1 = s1.length(), l2 = s2.length();
        int[][] M = new int[l1 + 1][l2 + 1];

        for (int i = 0; i < l1 + 1; i++) M[i][0] = i * delta;
        for (int i = 0; i < l2 + 1; i++) M[0][i] = i * delta;

        for (int i = 1; i < l1 + 1; i++) {
            for (int j = 1; j < l2+1; j++) {

                int case1 = s1.charAt(i-1) == s2.charAt(j-1) ?
                        0 + M[i-1][j-1] : alpha + M[i-1][j-1];
                int case2 = delta +  Math.min(M[i-1][j], M[i][j-1]);
                M[i][j] = Math.min(case1,case2);
            }
        }

//        System.out.println(Arrays.deepToString(M));
        for (int i = 0; i < M.length; i++) {
            System.out.println(Arrays.toString(M[i]));
        }

        return M[l1][l2];
    }

    public static void main(String[] args) {
        System.out.println(minEditCost("PALETTE", "PALATE", 2, 1));


    }

}
