package linkedlist_stack_queue;

public class SNode<T>{
    T val;
    SNode<T> next;

    public SNode(T val) {
        this.val = val;
    }

    public SNode(T val, SNode<T> next) {
        this.val = val;
        this.next = next;
    }
}
