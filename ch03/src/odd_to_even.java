import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.function.Function;

public class odd_to_even {

    public static void main(String[] args) {

        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8};
        reorder(nums, num -> (num & 1) == 0);
        System.out.println(Arrays.toString(nums));
    }

    public static void reorder(int[] nums, Function<Integer, Boolean> function){

        if (nums == null || nums.length <= 0)
            return;
        int start = 0;
        int end = nums.length - 1;
        while (start < end){
            if (function.apply(nums[start])){
                if (function.apply(nums[end]))
                    end--;
                else {
                    int temp = nums[start];
                    nums[start] = nums[end];
                    nums[end] = temp;
                    start++;
                    end--;
                }
            }
            else {
                start++;
                if (function.apply(nums[end]))
                    end--;
            }
        }
    }

}
