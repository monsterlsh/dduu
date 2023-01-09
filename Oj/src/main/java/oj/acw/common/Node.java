package oj.acw.common;

public class Node {//结点
    public int value;
    public Node left;
    public Node right;

    public Node() {
    }

    public Node(int value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }

    public Node(int value, Node l, Node r) {
        this.value = value;
        this.left = l;
        this.right = r;
    }

}