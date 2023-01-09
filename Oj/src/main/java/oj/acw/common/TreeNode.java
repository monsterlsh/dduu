package oj.acw.common;

public class TreeNode {
    public int value;
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int value) {
        this.value = value;
        this.val = value;
        this.left = null;
        this.right = null;
    }

    public TreeNode(int value, TreeNode l, TreeNode r) {
        this.value = value;
        this.val = value;
        this.left = l;
        this.right = r;
    }
}
