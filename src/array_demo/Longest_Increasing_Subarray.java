package array_demo;

import java.util.Arrays;

public class Longest_Increasing_Subarray {
    public static int[] subarray(int[] nums) {
        int x=0, y=0, cur = 0;
        for (int i = 0, j = 1; j < nums.length; j++) {
            if (nums[j] <= nums[j - 1]) {
                if (j - i > y - x) {
                    x = i;
                    y = j;
                }
                i = j;
            }
        }
        return Arrays.copyOfRange(nums, x, y);
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1,3,5,4,7};
        int[] nums2 = new int[]{2,2,2,2,2};
        System.out.println("nums1's longest increasing subarray is:" + Arrays.toString(subarray(nums1)));
        System.out.println("nums2's longest increasing subarray is:" + Arrays.toString(subarray(nums2)));
    }

}
