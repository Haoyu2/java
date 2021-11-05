package bst;

import java.util.Arrays;

public class Demo {
    public static void main(String[] args) {
        Integer[] arr = new Integer[]{10,5,11,3,16,6,7, 0};
        BST<Integer, Integer> bst = Utils.fromIArray(arr);
        TreePrinter.print(bst.root);

        try {
            int res = bst.floor(-1);
        }catch (Exception e){
            System.out.println(e);
        }

        System.out.println(Utils.closest(bst, 2));


        System.out.println(Arrays.toString(Utils.pre_order(bst)));

        BST<Integer, Integer> bst1 = Utils.fromPreOrder(Utils.pre_order(bst));
        TreePrinter.print(bst1.root);

    }
}
