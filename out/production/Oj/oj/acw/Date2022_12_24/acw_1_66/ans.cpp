##include<iostream>
using namespace std;
  struct ListNode {
     int val;
     ListNode *next;
     ListNode(int x) : val(x), next(NULL) {}
 };
class Solution {
public:
    ListNode * reverse(ListNode * head){
        if(!head || !head->next)return head;
        ListNode * p = head->next , *r = p->next , *pp = head;
        while(!r){
            p->next = pp;
            pp = p;
            p = r;
            r = r->next;
        }
        p ->next = pp;
        head ->next = null;
        return p;
    }
    ListNode *findFirstCommonNode(ListNode *headA, ListNode *headB) {

    }
};
