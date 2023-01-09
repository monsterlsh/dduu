package oj.acw.offer.Date2022_11_27.SecondAcw48;
import java.util.*;
public class Solution {
    public class TreeNode {
             int val;
             TreeNode left;
             TreeNode right;
             TreeNode(int x) { val = x; }
         }
    public List<List<Integer>> findPath(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        ArrayList<Integer> ans = new ArrayList<>();
        dfs(root,sum,ans,0,res);
        return res;
    }
    boolean dfs(TreeNode root,int sum,List<Integer> ans,int sums,List<List<Integer>> res){
        if(root == null) return false;
        ans.add(root.val);
        sums+= root.val;
        
        if(sums< sum){
            dfs(root.left,sum,ans,sums,res);
           
             dfs(root.right,sum,ans,sums,res);
            
        }else if(sums==sum && root.left==null && root.right==null){
            res.add(new ArrayList<>(ans));
        }
        ans.remove(ans.size()-1);
        return true;
    }
}
