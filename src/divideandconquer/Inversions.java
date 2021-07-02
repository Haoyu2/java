package divideandconquer;

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

    public static int get(int[] arr){
        int[] copy = new int[arr.length];
        return get( arr,  0, arr.length-1, (arr.length-1)/2, copy);
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
    private static int get(int[] arr, int lo, int hi, int mid, int[] copy) {
        return 1;
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


    }

}
