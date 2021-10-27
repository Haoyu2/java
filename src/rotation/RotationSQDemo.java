package rotation;

import java.lang.reflect.Array;
import java.util.Arrays;

public class RotationSQDemo<T> {
    public static void toString(int[][] mat){
        for (int[] row : mat)
            System.out.println(Arrays.toString(row));
    }
    public static void clockwise(int[][] mat){
        int N = mat.length - 1; // last index
        for (int i=0; i < (mat.length + 1) / 2; i++){
            for (int j=0; j < (mat.length + 0) / 2;j++){
                int temp = mat[i][j];
                mat[i][j] = mat[N-j][i];
                mat[N-j][i] = mat[N-i][N-j];
                mat[N-i][N-j] = mat[j][N-i];
                mat[j][N-i] = temp;
            }
        }
    }

    public static void flipH(int[][] mat){
        for (int[] row : mat){
            for (int i=0; i<row.length/2; i++){
                int tmp = row[i];
                row[i] = row[row.length-1-i];
                row[row.length-1-i] = tmp;
            }
        }

    }

    public static void flipV(int[][] mat){
        for (int i=0; i<mat.length/2; i++){
            int[] tmp = mat[i];
            mat[i] = mat[mat.length-1-i];
            mat[mat.length-1-i] = tmp;
        }
    }

    public static void transpose(int[][] mat){
        for (int i=0; i < mat.length; i++){
            for (int j=0;j<i; j++){
                int tmp = mat[i][j];
                mat[i][j] = mat[j][i];
                mat[j][i] = tmp;
            }
        }

    }


    public static void main(String[] args) {
        int[][] mat = new int[][]{
                {1,2,3},
                {4,5,6},
                {7,8,9},
        };
        toString(mat);

//        System.out.println();
//        transpose(mat);
//        toString(mat);
//
//        System.out.println();
//        flipH(mat);
//        toString(mat);
//
        System.out.println();
        flipV(mat);
        toString(mat);
//
//
//
//
//
//        clockwise(mat);
//        System.out.println();
//        toString(mat);
    }
}
