package divideandconquer;

import java.util.Arrays;

public class MergeSort {
    public static int[] merge(int[] a, int[] b) {

        int[] res = new int[a.length + b.length];
        int i = 0, j = 0, k = 0;
        while (i < a.length || j < b.length) {
            if (i >= a.length) res[k++] = b[j++];
            else if (j >= b.length) res[k++] = a[i++];
            else if (a[i] > b[j]) res[k++] = b[j++];
            else res[k++] = a[i++];
        }

        return res;
    }

    public static void main(String[] args) {

        int[] a = new int[]{1, 3, 5, 7};
        int[] b = new int[]{2, 4, 6, 8, 10};

        System.out.println(Arrays.toString(merge(a, b)));
    }

}
