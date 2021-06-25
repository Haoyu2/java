package dp;

import java.util.Arrays;
import java.util.Comparator;

public class WeightedIntervalScheduling {
    public static int[][] maxWeight_intervals(int[][] intervals, int[] weights) {


        return null;
    }


    public static int maxWeight_bottom(int[][] intervals, int[] weights) {
        int[][] wi = new int[intervals.length][];
        // { {START_TIME, FINISH_TIME, WEIGHTS},{...},...}
        for (int i = 0; i < wi.length; i++) {
            wi[i] = new int[]{intervals[i][0], intervals[i][1], weights[i]};
        }
        Arrays.sort(wi, (a, b) -> a[1] - b[1]);

        int[] M = new int[weights.length + 1];

        for (int j = 1; j < M.length; j++) {
            int pj = p(wi, j-1);
            M[j] = Math.max(M[j-1], weights[j-1] + M[pj + 1]);
        }
        System.out.println(Arrays.toString(M));
        return M[weights.length];
    }


    public static int maxWeight(int[][] intervals, int[] weights) {
        int[] M = new int[weights.length + 1];
        // the M[0] stands for no intervals, M[1] stands for the first interval interval[0] and weights[0]

        int[][] wi = new int[intervals.length][];
        // { {START_TIME, FINISH_TIME, WEIGHTS},{...},...}
        for (int i = 0; i < wi.length; i++) {
            wi[i] = new int[]{
                    intervals[i][0], intervals[i][1], weights[i]};
        }

        // sort the weighted_interval by finish time
        Arrays.sort(wi, (a, b) -> a[1] - b[1]);
//        System.out.println(Arrays.deepToString(weighted_interval));

        return OPT(intervals.length, M, wi);
    }

    public static int OPT(int j, int[] M, int[][] weighted_intervals) {
        if (j == 0) return 0;
        if (M[j] != 0) return M[j];
        int pj = p(weighted_intervals, j - 1);
        // because j in M correspond j-1 interval in weighted_intervals
        M[j] = Math.max(OPT(j - 1, M, weighted_intervals),
                weighted_intervals[j - 1][2] + OPT(1 + pj, M, weighted_intervals));
        return M[j];
    }

    public static int p(int[][] weighted_intervals, int j) {
        for (int i = j - 1; i >= 0; i--) {
            if (weighted_intervals[i][1] <= weighted_intervals[j][0])
                return i;
        }
        return -1;
    }


    public static void main(String[] args) {

        int[][] intervals = new int[][]{{1, 2}, {1, 7}, {6, 7}};
        int[] weights = new int[]{5, 100, 4};


//        maxWeight(intervals, weights);

        System.out.println(maxWeight(intervals, weights));
        System.out.println(maxWeight_bottom(intervals, weights));
//
//        Integer[] arr = new Integer[weights.length];
//        for (int i = 0; i < arr.length; i++) {
//            arr[i] = i;
//        }
//
//
//        Arrays.sort(arr, new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                return weights[o1] - weights[o2];
//            }
//        });
//
//        System.out.println(Arrays.toString(arr));


    }
}
