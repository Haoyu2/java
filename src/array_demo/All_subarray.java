package array_demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class All_subarray {
    public static List<int[]> all(int[] nums){
        List<int[]> res = new ArrayList();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                res.add((Arrays.copyOfRange(nums, i, j+1)));
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3};
        System.out.println("number is: " + all(nums).size());
        for (int[] arr : all(nums))
            System.out.println(Arrays.toString(arr));
    }

}
