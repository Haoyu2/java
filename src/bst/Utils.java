package bst;


import java.util.*;

public class Utils {
    public static BST fromIArray(Integer[] arr){
        BST<Integer, Integer> bst = new BST<>();
        for (int i : arr) bst.put(i,i);
        return bst;
    }

    public static BST fromPreOrder(Integer[] arr){
        BST<Integer, Integer> bst = new BST<>();
        LinkedList<Integer> q = new LinkedList();
        for (int i : arr) q.add(i);
        bst.root = fromPreOrder(Integer.MIN_VALUE, Integer.MAX_VALUE, q);
        return bst ;
    }
    public static Node<Integer, Integer> fromPreOrder(int lower, int upper, LinkedList<Integer> q){
        if (q.isEmpty() || q.peek() < lower || q.peek() > upper) return null;
        Node<Integer, Integer> root = new Node<>(q.peek(), q.poll(), 0);
        root.left = fromPreOrder(lower, root.val, q);
        root.right = fromPreOrder(root.val, upper, q);
        return root;
    }

    public static Integer[] pre_order(BST<Integer, Integer> bst){
        ArrayList<Integer> list = new ArrayList<>();
        pre_order(bst.root, list);
        return  list.toArray(new Integer[list.size()]);
    }
    public static void pre_order(Node<Integer, Integer> root, List<Integer> list){
        if (root == null) return;
        list.add(root.val);
        pre_order(root.left, list);
        pre_order(root.right,list);
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
