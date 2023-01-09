package oj.acw.offer.Date2022_12_24.acw_5_70;

import oj.acw.common.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
    public TreeNode kthNode(TreeNode root, int k) {

        Deque<TreeNode> q = new ArrayDeque<>();
        q.add(root);
        TreeNode node = root;
        while (!q.isEmpty() || node!=null){
            while (node != null) {
                q.add(node);
                node = node.left;
            }
            node = q.removeLast();

            if(0 == --k) return node;
            //if(node.right != null) q.add(node.right);
            node = node.right;

        }
        return node;
    }
}
