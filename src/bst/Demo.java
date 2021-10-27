package bst;

public class Demo {
    public static void main(String[] args) {
        int[] arr = new int[]{10,5,11,3,16,6,7, 0};
        BST<Integer, Integer> bst = Utils.fromIArray(arr);
        TreePrinter.print(bst.root);

        try {
            int res = bst.floor(-1);
        }catch (Exception e){
            System.out.println(e);
        }

        System.out.println(Utils.closest(bst, 2));

    }
}
