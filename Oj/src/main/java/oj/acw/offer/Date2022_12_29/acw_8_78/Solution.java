package oj.acw.offer.Date2022_12_29.acw_8_78;

public class Solution {
    public String reverseLeftWords(String s, int n) {
        return s.substring(n, s.length()) + s.substring(0, n);
    }

    public String reverseLeftWords2(String s, int n) {
        StringBuilder res = new StringBuilder();
        for(int i = n; i < n + s.length(); i++)
            res.append(s.charAt(i % s.length()));
        return res.toString();
    }
    //翻转
    public String reverseLeftWords3(String s, int n) {
        int len=s.length();
        StringBuilder sb=new StringBuilder(s);
        reverseString(sb,0,n-1);
        reverseString(sb,n,len-1);
        return sb.reverse().toString();
    }
    public void reverseString(StringBuilder sb, int start, int end) {
        while (start < end) {
            swap(sb,start,end);
            start++;
            end--;
        }
    }
    //原地复制
    //TODO
    public void swap(StringBuilder sb, int start, int end) {
        char temp = sb.charAt(start);
        sb.setCharAt(start, sb.charAt(end));
        sb.setCharAt(end, temp);
    }
    public String leftRotateString(String s, int n){
        n = n%s.length();
        StringBuilder sb = new StringBuilder(s);
        for(int i = n;i<s.length();i++){
            char c = sb.charAt(i);
            for(int j =0;j<n;j++) sb.setCharAt(i-j,sb.charAt(i-j-1));

            sb.setCharAt(i-n,c);
        }
        return sb.toString();
    }


}
