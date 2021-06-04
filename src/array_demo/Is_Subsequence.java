package array_demo;

import java.util.Arrays;

public class Is_Subsequence {
    public static boolean isSubsequence(int[] num1, int[] num2) {

        int i = 0, j = 0;
        while (i < num1.length && j < num2.length) {
            if (num1[i] == num2[j]) i++;
            j++;
        }
        return i == num1.length ? true : false;
    }

    public static void main(String[] args) {
        int[] num1 = new int[] {1, 3, 2};
        int[] num2 = new int[] {1, 4};
        int[] num3 = new int[] {1, 2, 1, 2, 3, 1, 3, 2};
        System.out.println("num1 and num3: " + isSubsequence(num1, num3));
        System.out.println("num2 and num3: " + isSubsequence(num2, num3));

        int[] nums1 = new int[]{1, 2};
        int[] nums2 = new int[]{2,1,3,1};
        System.out.println(Arrays.toString(nums1) +
                " and " + Arrays.toString(nums2) + ": " + isSubsequence(nums1,nums2)) ;
    }
}
