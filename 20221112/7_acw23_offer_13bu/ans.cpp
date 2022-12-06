#include<iostream>
#include<vector>
#include<cstring>
using namespace std;
class Solution {
public:
    bool vist[901][901];
    int row,col;
    int dir [4][4] = {{1,-1,0,0}
                    , {0,0,1,-1}};
    bool hasPath(vector<vector<char>>& matrix, string &str) {
        
        if((row=matrix.size())==0) return false;
        row=matrix.size() ,col = matrix[0].size();
        memset(vist,0,sizeof(vist));
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                //memset(vist,0,sizeof(vist));
                if(dfs(matrix,str,0,i,j)) return true;
            }
        }
        return false;
    }
    bool dfs(vector<vector<char>>& matrix,string &str,int idx,int i,int j){
        
        if(i<0 || i>=row || j<0 || j>=col ||  vist[i][j] || matrix[i][j]!=str[idx] ) return false;
        if(idx >= str.size()-1) return true;
        vist[i][j] = true;
        bool res = false;
        for (int d=0;d<4;d++){
            
            res =( res || dfs(matrix,str,idx+1,i+dir[0][d],j+dir[1][d]));
             
            if(res) {
                vist[i][j] = false;
                return res;
            }
        }
       vist[i][j] = false;
        return false;
    }
};
int main(){
    vector<vector<char>> matrix = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
    Solution s;
    string str = "A";
    s.hasPath(matrix ,str);
}