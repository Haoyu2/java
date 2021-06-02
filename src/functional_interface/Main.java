package functional_interface;

import edu.princeton.cs.algs4.Quick3way;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Integer[] arr = new Integer[]{9,8,7};
        Quick3way.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
