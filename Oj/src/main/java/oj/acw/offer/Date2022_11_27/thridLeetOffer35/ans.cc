#include<iostream>
#include<unordered_map>
using namespace std;
class Solution {
public:
    ListNode *copyRandomList(ListNode *head) {
        unordered_map<ListNode*, ListNode*> hash;
        hash[nullptr] = nullptr;
        auto dup = new ListNode(-1), tail = dup;

        while(head)
        {
            if(!hash.count(head)) hash[head] = new ListNode(head->val);
            if(!hash.count(head->random)) hash[head->random] = new ListNode(head->random->val);

            tail->next = hash[head];
            tail->next->random = hash[head->random];

            tail = tail->next;
            head = head->next;
        }

        return dup->next;
    }

//leetcode
    unordered_map<Node*, Node*> cachedNode;

    Node* copyRandomList(Node* head) {
        if (head == nullptr) {
            return nullptr;
        }
        if (!cachedNode.count(head)) {
            Node* headNew = new Node(head->val);
            cachedNode[head] = headNew;
            headNew->next = copyRandomList(head->next);
            headNew->random = copyRandomList(head->random);
        }
        return cachedNode[head];
    }

};