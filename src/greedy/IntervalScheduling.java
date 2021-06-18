package greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class IntervalScheduling {

    public static int[][] get(int[][] intervals){

        Comparator<int[]> sortBy2 = (a1, a2) -> a1[1] - a2[1];
        Arrays.sort(intervals, sortBy2);
        List<int[]> res = new ArrayList<>();
        res.add(intervals[0]);
//        System.out.println(Arrays.deepToString(intervals));
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= res.get(res.size()-1)[1])
                res.add(intervals[i]);
        }
        // turn array list into array
        int[][] resArray = new int[res.size()][2];
        for (int i = 0; i < res.size(); i++) {
            resArray[i][0] = res.get(i)[0];
            resArray[i][1] = res.get(i)[1];
        }

        return resArray;
    }


    public static void main(String[] args) {

        int[][] intervals1 = new int[][]{{10, 20}, {11,12}, {13,14}};
        int[][] intervals2 = new int[][]{{10, 14}, {13, 15}, {14, 20}};

        get(intervals1);
        System.out.println(Arrays.deepToString(get(intervals1)));
        System.out.println(Arrays.deepToString(get(intervals2)));



    }
}
