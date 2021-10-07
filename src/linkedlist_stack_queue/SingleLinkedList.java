package linkedlist_stack_queue;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class SingleLinkedList<T> implements Iterable<T> {
    SNode<T> root;

    public void toList(Object[] arr) {
        root = toList((T[]) arr, 0);
    }

    public SNode<T> toList(T[] arr, int i) {
        if (i == arr.length) return null;
        SNode<T> root = new SNode(arr[i]);
        root.next = toList(arr, i+1);
        return root;
//        return new SNode(arr[i], toList(arr, i + 1));
    }

    public List<T> toSystemList() {
        List<T> list = new LinkedList<T>();
        SNode<T> pointer = root;
        while (pointer != null) {
            list.add(pointer.val);
            pointer = pointer.next;
        }
        return list;
    }

    public SNode<T> lastItem() {
        if (root == null) return root;
        SNode<T> pointer = root;
        return lastItem(pointer);
    }

    public SNode<T> lastItem(SNode<T> pointer) {
        if (pointer.next == null) return pointer;
        return lastItem(pointer.next);
    }

    public void r() {
        root = r(root);
    }

    public SNode<T> r(SNode<T> root) {
        if (root == null || root.next == null) return root;
        SNode last = r(root.next);
        root.next.next = root;
        root.next = null;
        return last;
    }

    public void ri() {
        SNode pre = null, cur = root, tmp;
        while (cur != null) {
            tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
        root = pre;
    }


    public SNode m() {
        if (root == null) return null;
        SNode p1 = root, p2 = root;
        return m(p1, p2);
    }

    public SNode m(SNode p1, SNode p2) {
        if (p2 == null || p2.next == null) return p1;
        p1 = p1.next;
        p2 = p2.next.next;
        return m(p1, p2);
    }

    @Override
    public String toString() {
        return toSystemList().toString();
    }

    public static void main(String[] args) {
        SingleLinkedList<Integer> slist = new SingleLinkedList<>();

        slist.toList(new Integer[]{1, 2, 3, 4, 5});
        for (int i: slist) System.out.println(i);
        System.out.println(slist.toString());
//        System.out.println(slist.lastItem().val);
//        slist.r();
//        System.out.println(slist.toString());
//        System.out.println(slist.m().val);
//        slist.ri();
//        System.out.println(slist.toString());
    }

    @Override
    public Iterator<T> iterator() {
        return new LinkedListIterator<T>();
    }

    class LinkedListIterator<T> implements Iterator<T> {
        SNode pointer = root;
        @Override
        public boolean hasNext() {
            return pointer!=null;
        }

        @Override
        public T next() {
            if (hasNext()){
                T val = (T) pointer.val;
                pointer = pointer.next;
                return val;
            }
            return null;
        }
    }

}
