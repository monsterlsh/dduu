
package oj.acw.offer.Date2022_11_27.acwing_8_53;
import java.util.*;

class Solution {
    public int[] getLeastNumbers(int[] arr, int k) {
        int[] vec = new int[k];
        // List<Integer> collect = Arrays.stream(vec).boxed().collect(Collectors.toList());;
        if (k == 0) { // 排除 0 的情况
            return vec;
        }
        
        // PriorityQueue<Integer> queue = new PriorityQueue<Integer>(new Comparator<Integer>() {
        //     public int compare(Integer num1, Integer num2) {
        //         return num2 - num1;
        //     }
        // });
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>((num1,num2)->{return num2 - num1;});
        for (int i = 0; i < k; ++i) {
            queue.offer(arr[i]);
        }
        for (int i = k; i < arr.length; ++i) {
            if (queue.peek() > arr[i]) {
                queue.poll();
                queue.offer(arr[i]);
            }
        }
        for (int i = 0; i < k; ++i) {
            vec[i] = queue.poll();
        }
        return vec;
    }
}

