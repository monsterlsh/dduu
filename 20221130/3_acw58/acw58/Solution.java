package acw58;
import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class Solution {
    //wrong
    public String printMinNumber(int[] nums) {
        String str = Arrays.toString(nums);
        StringBuilder res  = new StringBuilder();
        List<String> asList = Arrays.asList(str.substring(1,str.length()-1).split(", "));
       
        asList.sort(( a, b)->{
            for(int i=0,j=0;i<a.length() && j<b.length();i++,j++){
                if (a.charAt(i) > b.charAt(j)) return 1; 
            }
            return  b.length()-a.length();
        });
        
        for (String e : asList) res.append(e);
        
        return res.toString();
    }
    public static void main(String[] args) {
        int [] nums = {597, 956, 31, 658, 771};
        StringBuilder res  = new StringBuilder();
        IntStream stream = Arrays.stream(nums);
        Stream<Integer> boxed = stream.boxed();
        List<Integer> collect = boxed.collect(Collectors.toList());
        /*
         * 注意compators
         */
        collect.sort((a,b)->{
            String ab = new StringBuilder().append(String.valueOf(a)).append(String.valueOf(b)).toString();
            String ba = new StringBuilder().append(String.valueOf(b)).append(String.valueOf(a)).toString();
            return ab.compareTo(ba);
        });
        System.out.println(collect);
        for(Integer e : collect){
            res.append(String.valueOf(e));
        }

        // String str = Arrays.toString(nums);
        
        // List<String> asList = Arrays.asList(str.substring(1,str.length()-1).split(", "));
        // System.out.println(asList.toString());
        // // for(String e : asList) System.out.println(e+"%");
        // asList.sort(( a, b)->{
        //     String ab = a+b;
        //     String ba = b+a;
        //     return ab.compareTo(ba);
        // });
        // System.out.println(asList.toString());
        // for (String e : asList) res.append(e);
        // System.out.println(res.toString());
    }
    
}