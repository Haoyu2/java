package dp;

public class CoinChangeDP {
    public static int minNum(int amount, int[] coins){
        int[] M = new int[amount+1];
        for (int i = 1; i < M.length; i++) {
            M[i] = Integer.MAX_VALUE;
        }
        for (int i = 1; i < amount+1; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (i - coins[j] >=0)
                M[i] = Math.min(M[i], 1 +M[i - coins[j]]);
            }
        }
        return M[amount];
    }

    public static void main(String[] args) {
        System.out.println(minNum(140, new int[]{ 1, 10, 21, 34, 70, 100, 350, 1295, 1500 }));
    }
}
