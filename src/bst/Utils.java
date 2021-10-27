package bst;


import java.util.ArrayList;
import java.util.List;

public class Utils {
    public static BST fromIArray(int[] arr){
        BST<Integer, Integer> bst = new BST<>();
        for (int i : arr) bst.put(i,i);
        return bst;
    }



    public static int closest(BST<Integer, Integer>bst, int val){
        int floor = 0 , ceil = 0;
        try {
            floor = bst.floor(val);
        }catch (Exception e){
            floor = Integer.MIN_VALUE;
        }

        try {
            ceil = bst.ceiling(val);
        }catch (Exception e){
            ceil = Integer.MAX_VALUE;
        }
        return Math.abs(val - floor) >= Math.abs(ceil - val) ? ceil : floor;

    }




    public static List<Integer> leafs(BST<Integer, Integer> bst){
        List<Integer> list = new ArrayList<>();
        return list;
    }




}
