package dp;

public class LCSS {
    public static int lcss(String s1, String s2) {
        int l1 = s1.length(), l2 = s2.length();
        int[][] M = new int[l1 + 1][l2 + 1];

        for (int i = 1; i < l1 + 1; i++) {
            for (int j = 1; j < l2 + 1; j++) {
                if (s1.charAt(i-1) == s2.charAt(j-1))
                    M[i][j] = 1 + M[i-1][j-1];
                else
                    M[i][j] = Math.max(M[i-1][j], M[i][j-1]);
            }
        }
        return M[l1][l2];
    }

    public static void main(String[] args) {
        System.out.println(lcss("GGCACCACG", "ACGGCGGATACG"));
    }

}
