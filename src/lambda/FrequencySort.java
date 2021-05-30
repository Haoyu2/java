package lambda;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class FrequencySort {
    /**
     *
     * @param arr Comparable array
     * @param <T> Generic types
     */
    public static <T extends Comparable<T>> void sort(T[] arr){
        Map<Object, Integer> counts = new HashMap<>();
        for(Object ob : arr){
            counts.put(ob, 1 + counts.getOrDefault(ob, 0));
        }
        System.out.println(Arrays.toString(counts.entrySet().toArray()));
        Comparator<Object> comparator = (o1, o2) -> counts.get(o1).compareTo(counts.get(o2));
        Arrays.sort(arr, comparator);
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int[] arr){
        Integer[] arr1 = new Integer[arr.length];
        for (int i = 0; i < arr.length; i++) {
            arr1[i] = arr[i];
        }
        sort(arr1);

    }

    public static void main(String[] args) {
        sort(new int[]{1,1,1,2,2,3}); //primitive types are not comparable
        sort(new Integer[]{1,1,1,2,2,3});
    }
}
