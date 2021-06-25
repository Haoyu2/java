package dp;

public class CoinChangeDP {
    public static int minNum(int amount, int[] coins){
        int[] M = new int[amount+1];
        for (int i = 1; i < M.length; i++) {
            M[i] = Integer.MAX_VALUE;
        }
        for (int i = 1; i < amount+1; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (i - coins[i] >=0)
                M[i] = Math.min(M[i], 1 +M[i - coins[i]]);
            }
        }
        return M[amount];
    }
}
