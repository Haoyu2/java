package divideandconquer;

import java.util.Arrays;

public class Inversions {
    public static int bruteforce(int[] arr) {
        int res = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) res++;
            }
        }
        return res;
    }

    public static int inversionsof2sortedarrays(int[] arr1, int[] arr2) {
        int i = 0, j = 0, k = 0;

        int res = 0;
        while (i < arr1.length && j < arr2.length) {
//            System.out.printf("%d, %d, %d, %d, \n", i, j, arr1[i],arr2[j]);
//            if (arr1[i] > arr2[j++]) {
            if (arr1[i] > arr2[j]) {
                j++;
//                System.out.println(arr1.length - i);
                res += arr1.length - i;
            } else i++;
        }
        return res;
    }
// merger sort and count inversion
    public static int merge(int[] arr, int lo, int hi, int mid, int[] copy) {
        for (int i = lo; i < hi + 1; i++) copy[i] = arr[i];
        int i = lo, j = mid + 1, k = lo;

        int res = 0;
        while (i <= mid || j <= hi) {
            if (i > mid) arr[k++] = copy[j++];
            else if (j > hi) arr[k++] = copy[i++];
            else if( copy[i] > copy[j] ){
                res += (mid + 1- i);
                arr[k++] = copy[j++];
            }else{
                arr[k++] = copy[i++];
            }
        }

        return res;
    }


    public static int get(int[] arr) {
        int[] copy = new int[arr.length];
        return divide(arr, 0, arr.length - 1, (arr.length - 1) / 2, copy);
    }
// length: 1 2 3 4 5 6
// index:  0 1 2 3 4
// (i + j) / 2 = floor(actual_mid) for i, j are both index
//  eg: for i=0, j=1, actual_mid = 0.5  1 / 2 = 0 = floor (0.5)
//      for i=0, j=3, actual_mid = 1.5  3 / 2 = 1 = floor (1.5)

// (i + j) / 2 = ceiling(actual_mid) if i is the index but j is length of the subarray
//  eg: for i=0, j=1, actual_mid = 0  1 / 2 = 0 = ceiling (0)
//      for i=0, j=4, actual_mid = 1.5  4 / 2 = 2 = ceiling (1.5)


    //
    public static int divide(int[] arr, int lo, int hi, int mid, int[] copy) {
        if (lo >= hi) return 0;
        int left = divide(arr, lo, mid, (lo + mid) / 2, copy);
        int right = divide(arr, mid + 1, hi, (mid + 1 + hi) / 2, copy);

        int merge = merge(arr, lo, hi, mid, copy);
//        System.out.printf("left:%d, right:%d merge:%d\n", left,right,merge);
        return left + right + merge;
    }

    public static int get_BU(int[] arr){
        if (arr.length < 2) return 0;
        int[] copy = Arrays.copyOf(arr, arr.length);
        int res = 0;

        for (int i = 1; i < arr.length ; i+=i) {
            for (int j = 0; j < arr.length - i; j+=i + i) {

                int hi = Math.min(j + 2*i - 1, arr.length-1);
                int mid = (hi+j) / 2;
                res += merge(arr, j, hi, mid, copy);
            }
        }
        return res;
    }


    public static void main(String[] args) {
        int[] arr = new int[]{1, 3, 4, 2, 5};
        System.out.println(bruteforce(arr));
        System.out.println();

        int[] arr1 = new int[]{3, 7, 10, 14, 18};
        int[] arr2 = new int[]{2, 11, 16, 20, 23};
        System.out.println(inversionsof2sortedarrays(arr1, arr2));

        int[] arr3 = new int[]{3, 7, 10, 14, 18, 2, 11, 16, 20, 23};
        System.out.println(bruteforce(arr3));
        System.out.println(Arrays.toString(arr3));
//        System.out.println(merge(arr3, 0, arr.length-1, (arr.length-1)/2, arr3));

        System.out.println(get(arr3));
        System.out.println(Arrays.toString(arr3));

        int[] arr4 = new int[]{3, 7, 10, 14, 18, 2, 11, 16, 20, 23};
        System.out.println(get_BU(arr4));






    }

}
