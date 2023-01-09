package oj.acw.offer.Date2022_12_29.acw_1_71;

import oj.acw.common.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
    public int treeDepth(TreeNode root) {
        if(root == null) return 0;
        Deque<TreeNode> q = new ArrayDeque<>();
        int depth = 0;
        TreeNode node = null , last = root,nextlast = null;
        q.add(root);
        while ( !q.isEmpty()){
            node = q.peek(); q.removeFirst();
            if(node.left != null ) {
                q.add(node.left);
                //nextlast = node.left.right == null ? (node.left.left==null?  nextlast : node.left.left) : node.left.right ;
                nextlast = node.left;
            }
            if(node.right != null ){
                q.add(node.right);
//                if(node.right.right != null) nextlast = node.right.right;
//                else if(node.right.left != null) nextlast = node.right.left;
                nextlast = node.right;
            }

            if(last == node){
                depth ++;
                last = nextlast;
                nextlast = null;
            }
        }

        return  depth;
    }
}
