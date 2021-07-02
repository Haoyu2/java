package dp;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class RNASS {


    public static int maxPairs(String RNA){

        Set<String> pairs = new HashSet<>(){
            {add("AU");}
            {add("UA");}
            {add("GC");}
            {add("CG");}
        };

        System.out.println(pairs.toString());

        int n = RNA.length();
        int[][] M = new int[n][n];


        for (int k = 5; k < n; k++) {
            for (int i = 0; i < n-k; i++) {
                int j = i + k;
                int case3 = 0;
                for (int t = i; t < j-4; t++) {
                    int part1 = 0;
                    if (pairs.contains("" + RNA.charAt(t) + RNA.charAt(j))){
                        part1 = 1;
                    }
                    int left =  t==i ? 0: M[i][t-1];
                    case3 = Math.max(case3, part1 + left + M[t+1][j-1]);
                }

                M[i][j] = Math.max(case3, M[i][j-1]);
                if (i==0 && j == n-1) return M[i][j];
            }
        }
//        System.out.println(Arrays.deepToString(M));

        return  M[0][n-1];
    }

    public static void main(String[] args) {
        System.out.println(maxPairs("GUCGAUUGAGCGAAUGUAACAACGUGGCUACGGCGAGA"));
        System.out.println(maxPairs("AUGUGGCCAU"));

    }

}
