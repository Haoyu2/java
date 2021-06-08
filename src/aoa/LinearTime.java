package aoa;

public class LinearTime {
    public static double average(Integer[] arr){
        if (arr.length == 0) return 0;
        int res = 0;
        for (int i :arr                ) {
            res += i;

        }
        return res/arr.length;
    }
}
