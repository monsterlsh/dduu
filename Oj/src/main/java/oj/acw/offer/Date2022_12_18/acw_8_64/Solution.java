package oj.acw.offer.Date2022_12_18.acw_8_64;

import java.util.*;

class Solution {

     HashMap<Character,Integer>s;
     ArrayDeque<Character> q;
     char res;
    //Insert one char from stringstream
    public Solution(){
        s = new HashMap<>();
        q = new ArrayDeque<>();
        res = '#';
    }
    public void insert(char ch){
        if (s.containsKey(ch)){
            s.put(ch,s.get(ch)+1);
        }

        else  {
            s.put(ch,0);
            q.add(ch);
        }

    }
    //return the first appearence once char in current stringstream
    public char firstAppearingOnce(){
        for(Character ch : q){
            if(s.get(ch)==0) return ch;
        }
        return  '#';
    }
}
class Main{
    public static void main(String[] args) {
        Solution s = new Solution();
        s.insert('g');
        System.out.println(s.firstAppearingOnce());
    }
}