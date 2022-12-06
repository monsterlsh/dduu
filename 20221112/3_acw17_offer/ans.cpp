#include<iostream>
#include<string>
#include<vector>
using namespace std;
/* *
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
struct ListNode
{
    /* data */
    int val;
    ListNode * next;
    ListNode(int x):val(x),next(NULL){}
};

class Solution {
public:
    vector<int> printListReversingly(ListNode* head) {
      vector<int>res;
        dfs(res,head);
        return res;
    }
    void dfs(vector<int>& res,ListNode * head){
        if(head==NULL) {
            return ;
        }else {
            dfs(res,head->next);
            res.push_back(head->val);
        }
    }
};