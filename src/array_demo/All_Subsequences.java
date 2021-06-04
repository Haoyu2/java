package array_demo;

import java.util.ArrayList;
import java.util.List;

public class All_Subsequences {

    public static List<List<Integer>> all(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < Math.pow(2, nums.length); i++) {
            int num = i, j = nums.length - 1;
            List<Integer> l = new ArrayList<>();
            while (num > 0) {
                if (num % 2 == 1) l.add(nums[j]);
                num = num >> 1;
                j--;
            }
            res.add(l);
        }
        return res;
    }
    /*
    *   [1, 2, 3]     []                                                       1
    *   [2, 3]     1  [] | [1]                                                 1+1 = 2
    *   [3]        2  [] | [1] | [2], [1, 2]                                   2+2 = 4
    *   []         3  [] | [1] | [2], [1, 2] | [3], [1, 3], [2, 3], [1, 2, 3]  4+4 = 8
    *
    * */
    public static List<List<Integer>> cascading(int[] nums) {
        List<List<Integer>> res = new ArrayList();
        res.add(new ArrayList<Integer>());
        for(int num : nums){
            List<List<Integer>> cur = new ArrayList();
            for (List<Integer> l : res)
                cur.add(new ArrayList<Integer>(l){{add(num);}});
            for (List<Integer> l : cur) res.add(l);
        }

        return res;

    }



    public static void main(String[] args) {

        int[] arr = new int[]{1, 2, 3};

        System.out.println("Total number of subseqs is: " + all(arr).size());
        System.out.println(all(arr).toString());

        System.out.println("Total number of subseqs is: " + cascading(arr).size());
        System.out.println(cascading(arr).toString());
    }
}
