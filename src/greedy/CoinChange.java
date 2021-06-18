package greedy;

import java.util.HashMap;
import java.util.Map;

public class CoinChange {
    static int[] demominations = new int[]{1, 5, 10, 25, 100};
    public static Map<Integer, Integer> get(int change){
        Map<Integer, Integer> res = new HashMap<>();

        while (change != 0){
            System.out.println(change);
            if (demominations[0] > change) return null;
            else if (change > demominations[4]) {
                res.put(demominations[4],
                        res.getOrDefault(demominations[4], 0) + 1);
                change -= demominations[4];
            }else{
                for (int i = 0; i < demominations.length; i++) {
                    if(demominations[i] > change){
                        res.put(demominations[i-1],
                                res.getOrDefault(demominations[i-1], 0) + 1);
                        change -= demominations[i-1];
                        break;
                    }
                }
            }


        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(get(34).toString());
        System.out.println(get(289).toString());

    }

}
