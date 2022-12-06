import java.util.*;
public class Solution {
    public static int getTranslationCount(String s) {
        int n=s.length();
           int dp[]=new int[n+1];
           dp[0]=dp[1]=1;
           for(int i=2;i<=n;i++){
               if(s.charAt(i-2)=='1'||(s.charAt(i-2)=='2'&&s.charAt(i-1)<'6')) dp[i]=dp[i-1]+dp[i-2];
               else dp[i]=dp[i-1];
           }
           return dp[n];
    }

    //怎么用递归呢
    public static int getnum(String s,int start,int end){
        if(end >= s.length()) return 1;
        String tmp = s.substring(start,end);
        int x = Integer.valueOf(tmp);
        int res = 0 ;
        if(x>25 && x<10) return getnum(s, start+1, end+1);
        res += getnum(s, start+1, end+1);
        res += getnum(s, start+2, end+2);
        return  res;
    }
    public static void main(String[] args) {
        String s="77146620653";
        System.out.println(getTranslationCount(s));
        System.out.println(!(s.charAt(0)>'2'));
        
    }
}
