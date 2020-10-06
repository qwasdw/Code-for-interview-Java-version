import java.util.ArrayList;
import java.util.Arrays;

public class maximum_sum_of_continuous_subarray {

    public static void main(String[] args) {

        int[] nums = {1, -2, 3, 10, -4, 7, 2, -5};
        try {
            int max = maxSum(nums);
            System.out.println(max);
        }
        catch (Exception e){
            System.out.println("数组为空");
        }
    }

    public static int maxSum(int[] nums){

        if (nums == null)
            throw new RuntimeException();
        int[] sum = new int[nums.length];
        sum[0] = nums[0];
        int max = sum[0];
        for (int i = 1; i < nums.length; i++){
            if (sum[i-1] > 0)
                sum[i] = sum[i-1] + nums[i];
            else if (sum[i-1] <= 0)
                sum[i] = nums[i];
            if (max < sum[i])
                max = sum[i];
        }
        return max;
    }
}
