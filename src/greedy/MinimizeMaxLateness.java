package greedy;

import java.util.Arrays;
import java.util.Comparator;

public class MinimizeMaxLateness {
    public static int get(int[] times, int[] dues) {
        int[][] times_dues = new int[times.length][2];
        for (int i = 0; i < times.length; i++) {
            times_dues[i][0] = times[i];
            times_dues[i][1] = dues[i];
        }

        Comparator<int[]> sortBydue = (a1, a2) -> a1[1] - a2[1];
        Arrays.sort(times_dues, sortBydue);
        System.out.println(Arrays.deepToString(times_dues));

        int start = 0, lates = 0;
        int[][] schedules = new int[times_dues.length][];
        for (int i = 0; i < times_dues.length; i++) {
            schedules[i] = new int[]{start, start + times_dues[i][0]};
            start = schedules[i][1];
            int cur_lateness = schedules[i][1] - times_dues[i][1];
            cur_lateness = cur_lateness < 0 ? 0 : cur_lateness;
            lates = Math.max(lates, cur_lateness);
        }
        System.out.println(Arrays.deepToString(schedules));
        return lates;
    }

    public static void main(String[] args) {
        int[] times = new int[]{3, 2, 1, 4, 3, 2};
        int[] dues = new int[]{6, 8, 9, 9, 14, 15};
        System.out.println(get(times, dues));

    }
}
