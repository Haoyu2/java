package array_demo;

import edu.princeton.cs.algs4.In;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class ArraysUtil_Demo {
    public static void main(String[] args) {
        int[] arr = new int[]{0, 1, 2, 3, 4, 5};

        // 1d array to String
        System.out.println(Arrays.toString(arr));

        // copyOf (have to offer the length) and copyOfRange
        int[] arr_copy = Arrays.copyOf(arr, arr.length);
        int[] arr_copy_range = Arrays.copyOfRange(arr, 1, 3);

        System.out.println("copy:\n" + Arrays.toString(arr_copy));
        System.out.println("range copy:\n" + Arrays.toString(arr_copy_range));

        // set same initial values
        int[] arr1 = new int[5];
        Arrays.fill(arr1, -1);
        System.out.println("fill -1\n" + Arrays.toString(arr1));

        // sort and sort with comparator
        Integer[] arr2 = new Integer[]{3, 1, 2};
        Arrays.sort(arr2);
        Comparator<Integer> reverse = (a, b) -> b - a;
        Arrays.sort(arr2, reverse);
        System.out.println("Descending order:\n" + Arrays.toString(arr2));

        // search and binary seach
        System.out.println("Index is of 1 is:\n" + Arrays.binarySearch(arr, 1));

        // 2d array
        int[][] arr2d = new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9},
        };
        // deep to string
        System.out.println("2d array to string:\n" + Arrays.toString(arr2d));
        System.out.println("2d array deep to string:\n" + Arrays.deepToString(arr2d));

        // 3d array
        int[][][] arr3d = new int[][][]{
                {{1, 2}, {3, 4}},
                {{5, 6}, {7, 8}}
        };
        System.out.println("3d array deep to string:\n" + Arrays.deepToString(arr3d));

        // array to fixed length list
        List<Integer> list = Arrays.asList(arr2);
        // list.add(10); // WRONG THIS LIST IS OF FIXED LENGTH CAN'T ADD
        System.out.println("list to string" + list.toString());

        // setAll with lambda
        String[] strings = new String[]{"a", "b", "c"};
        Arrays.setAll(strings,  i -> strings[i].toUpperCase());
        System.out.println("lower to upper case:\n" + Arrays.toString(strings));


    }
}
