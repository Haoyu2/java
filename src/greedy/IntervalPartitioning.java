package greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class IntervalPartitioning {
    public static int get(int[][] intervals){
        Comparator<int[]> sortBy1st =(a1, a2) -> a1[0] - a2[0];

        Comparator<ArrayList<int[]>> sortBy2nd1 =(a1, a2)
                -> a1.get(a1.size() - 1)[1] - a2.get(a2.size() - 1)[1];
        Arrays.sort(intervals, sortBy1st);

        PriorityQueue<Integer> heap =   new PriorityQueue<>();

//        PriorityQueue<ArrayList<int[]>> heap =
//                new PriorityQueue<>(intervals.length, sortBy2nd1 );
//        System.out.println(Arrays.deepToString(intervals));
        heap.offer(intervals[0][1]);
        System.out.println(heap);
        for (int i = 1; i < intervals.length; i++) {
            int end = heap.poll();
            if (intervals[i][0] >= end){
                heap.offer(intervals[i][1]);
            }else {
                heap.offer(end);
                heap.offer(intervals[i][1]);
            }
        }
        return heap.size();
    }

    public static void main(String[] args) {
        int[][] intervals1 = new int[][] {{0,30},{5,10},{15,20}};
        int[][] intervals2 = new int[][] {{7,10},{2,4}};
        get(intervals2);
        System.out.println(get(intervals1));
    }
}
