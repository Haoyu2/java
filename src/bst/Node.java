package bst;

public class Node <Key extends Comparable<Key>, Value> implements PrintableNode {

    Node<Key, Value> left, right;
    Key key;
    Value val;
    int size;

    public Node(Key key, Value val, int size) {
        this.key = key;
        this.val = val;
        this.size = size;
    }

    @Override
    public PrintableNode getLeft() {
        return left;
    }

    @Override
    public PrintableNode getRight() {
        return right;
    }

    @Override
    public String getText() {
        return val.toString();
    }
}
