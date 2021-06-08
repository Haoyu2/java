package aoa;

import java.util.ArrayList;
import java.util.List;

public class ExponentialTime {
    public static void cascading(int[] nums) {
        List<List<Integer>> res = new ArrayList();
        res.add(new ArrayList<Integer>());
        for(int num : nums){
            List<List<Integer>> cur = new ArrayList();
            for (List<Integer> l : res) {
                int a =  100 * 10;
            }
            for (List<Integer> l : cur) {
                int b = 100 * 100;
            }
        }


    }
}
