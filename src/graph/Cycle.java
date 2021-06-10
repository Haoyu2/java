package graph;

public class Cycle {


    static char[][] grid;
    static boolean[][] seen;
    static int H, W;

    public static boolean containsCycle(char[][] grid) {
        Cycle.grid = grid;
        H = grid.length;
        W = grid[0].length;
        seen = new boolean[H][W];
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                if (!seen[i][j] && dfs(i, j, i, j)) return true;
            }
        }
        return false;
    }


    public static boolean dfs(int i, int j, int pi, int pj) {
        if (seen[i][j]) return true;
        seen[i][j] = true;

        for (int[] next : new int[][]{{i + 1, j}, {i - 1, j}, {i, j + 1}, {i, j - 1}}) {
            int x = next[0], y = next[1];
            if (0 <= next[0] && next[0] < H && 0 <= next[1] && next[1] < W
                    && grid[x][y] == grid[i][j] && (x != pi || y != pj) &&
                    dfs(x, y, i, j)) return true;
        }

        return false;

    }


    public static void main(String[] args) {
        char[][] grid3 = new char[][]{
                {'a', 'b', 'b'},
                {'b', 'z', 'b'},
                {'b', 'b', 'a'}
        };
        char[][] grid1 = new char[][]{
                {'a', 'a', 'a', 'a'},
                {'a', 'b', 'b', 'a'},
                {'a', 'b', 'b', 'a'},
                {'a', 'a', 'a', 'a'}
        };

        char[][] grid2 = new char[][]{
                {'c', 'c', 'c', 'a'},
                {'c', 'd', 'c', 'c'},
                {'c', 'c', 'e', 'c'},
                {'f', 'c', 'c', 'c'}
        };

        char[][][] grids = new char[][][]{grid3, grid1, grid2};

        for (char[][] grid : grids)
            System.out.println(containsCycle(grid));
    }


}
