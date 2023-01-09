package oj.acw.common.binarySortTree;

import  oj.acw.common.Node;
public class BinarySortTree {
    Node root;
    public BinarySortTree()
    {root=null;}
    public void makeEmpty()//变空
    {root=null;}
    public boolean isEmpty()//查看是否为空
    {return root==null;}

    /**
     * @return 最小root节点的最小值
     */
    public Node findMin(){
        if (isEmpty()) return null;
        Node p = root;
        while(p.left != null) p = p.left;
        return p;
    }

    /**
     * @param t type：oj.acw.common.Node
     * @return 返回t节点的最小值
     */
    public Node findMin(Node t){
        if (t == null || t.left == null) return t;
        return  findMin(t.left);
    }
    public Node findMax(Node t){
        if (t == null || t.right== null) return t;
        return  findMax(t.right);
    }

    public boolean isContains(int x){
        Node current = root;
        if(root == null) return false;
        while (current != null && current.value != x){
            if(current.value < x) current = current.right;
            else current = current.left;
        }
        return current != null && current.value == x;
    }
    public void insert(int x){
        Node current = root;
        if (root == null) {
            root = new Node(x);
            return ;
        }
        while (current != null){
            if(current.right == null && current.value < x) current.right = new Node(x);
            if(current.value < x) {
                current = current.right;
                continue;
            }
            if (current.left==null && current.value > x) current.left = new Node(x);
            if(current.value > x) current = current.left;
        }
    }
    public Node remove(int x, Node t){
        if (t == null) return  t;
        if(x < t.value) remove(x,t.left);
        else if(x > t.value) remove(x,t.right);
        else if(t.left != null && t.right!=null){
            t.value = findMin(t.right).value;
            t.right = remove(x,t.right);
        }
        else
            t = (t.left==null  && t.right==null) ? null : (t.right==null)?t.right:t.left;
        return t;
    }
}
