package oj.acw.offer.Date2022_12_24.acw_1_66;

import oj.acw.common.tree.ListNode;

/**
 * Definition for singly-linked list.
 *  class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode findFirstCommonNode(ListNode headA, ListNode headB) {
        ListNode res = null;
        ListNode pa  = headA ,pb = headB;
        int na =0,nb=0;
        while (pa!=null) {na++; pa = pa.next;}
        while (pb!=null) {nb++; pb = pb.next;}
        if(na > nb) {
            int tmp = na;
            na = nb;
            nb = tmp;
            pa = headB;
            pb = headA;
        }else {
            pa = headA;
            pb = headB;
        }
        while (nb>na){
            nb--;
            pb = pb.next;
        }

        while (pa!=null && pb!=null && pa!=pb) {
            pa = pa.next;
            pb = pb.next;
        }
        res = pa;

        return res;
    }
}
