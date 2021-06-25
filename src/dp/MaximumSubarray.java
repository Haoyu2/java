package dp;

public class MaximumSubarray {
    public static int maxSub(int[] arr){

        int[] M = new int[arr.length];
        M[0] = arr[0];
        int res = arr[0];

        for (int i = 1; i < arr.length; i++) {
            M[i] = Math.max(arr[i], arr[i] + M[i-1]);
            res = Math.max(res, M[i]);
        }

        return res;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{12,5,-1,31,-61,59,26,-53,58,97,-93,-23,84,-15,6};
        System.out.println(maxSub(arr));
    }

}
