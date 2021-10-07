package linkedlist_stack_queue;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class SystemListDemo {
    public static void main(String[] args) {
        LinkedList<Integer> queue = new LinkedList(Arrays.asList((new Integer[]{1,2,3,4,5})));
        System.out.println(queue.toString());
        System.out.println( queue.remove());// if this is just List interface, this method would not work
    }
}
