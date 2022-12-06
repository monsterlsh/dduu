#include<iostream>
#include<string>
#include<vector>
#include<stack>
using namespace std;

  struct TreeNode {
      int val;
      TreeNode *left;
      TreeNode * right;
      TreeNode(int x) : val(x), left(NULL), right(NULL) {}
  };

class Solution {
public:
    TreeNode buildTree(vector<int>& preorder, vector<int>& inorder) {
        if( preorder.size()==0) return NULL;
        TreeNode * root = new TreeNode(preorder[0]),*l=NULL;
        int prei = 0,front=0,read=-1,ori=0,i=0;
        stack<int>s;
        stack<TreeNode *> tree;
        s.push(preorder[prei]);
        while(!s.empty()){
            if (root == NULL){

            }
            else if(s.top()!=inorder[ori]) {
                
                s.push(preorder[++prei]);
                
                root->left=  new TreeNode(preorder[prei]);
                tree.push(root);
                root = root->left;
                
            }else if(!tree.empty()){
                tree.pop();
                root = tree.top();
                ++ori;
                
            }
            // s.push(preorder[++prei]);
            // root->right = new TreeNode(s.top());
            // root = root->right;

        }
        
    }
    int dfs(TreeNode * root,vector<int>& preorder, vector<int>& inorder,int i){
        
    }
};