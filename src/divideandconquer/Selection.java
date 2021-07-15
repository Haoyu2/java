package divideandconquer;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class Selection {

    /*
    * a max priority queue for storing current k items
    *  enque a new k + 1 item and deque a max item in the queue
    * then the item gets dequed will be at bigger than k item
    *
    * after all these kind item get dequed, the next item will be the kth smallest
    *
    * in Java for queue, poll means dequeue
    *
    * */

    public static int getKS(int[] arr, int k) {
        Queue<Integer> queue = new PriorityQueue<>(k, Collections.reverseOrder());

        for (int i : arr) {
            queue.add(i);
            if (queue.size() > k) queue.poll();
        }
        return queue.poll();
    }


    public static int getKL(int[] arr, int k) {
        Queue<Integer> queue = new PriorityQueue<>(k);

        for (int i : arr) {
            queue.add(i);
            if (queue.size() > k) queue.poll();
        }
        return queue.poll();
    }

    public static void main(String[] args) {
        int[] arr = new int[] {1,2,3,4,5,6,7,8,9,10};
        System.out.println(getKS(arr, 3));
        System.out.println(getKL(arr, 3));
    }
}
