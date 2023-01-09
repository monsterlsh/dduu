package books.AlgorithmIntorduction.part1.ch2;

public class Sort {
    public <T extends Comparable<T> >void insert_sort(T [] nums){
        for (int i = 1; i < nums.length; i++){
            T key = nums[i];
            int j = i-1;
            for (;j>=0;j--) if(key.compareTo(nums[j]) < 0) nums[j+1] = nums[j];
            nums[j+1] = key;
        }
    }
}
