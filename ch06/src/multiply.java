import java.util.Arrays;

public class multiply {

    public static void main(String[] args) {

        int[] nums = {1, 2, 3, 4, 5};
        System.out.println(Arrays.toString(multiply(nums)));
    }

    public static int[] multiply(int[] nums){

        if (nums == null || nums.length < 1)
            return nums;
        int[] result = new int[nums.length];
        result[0] = 1;
        for (int i = 1; i < nums.length; i++)
            result[i] = result[i - 1] * nums[i - 1];
        int temp = 1;
        for (int i = nums.length - 2; i >= 0; i--){
            temp *= nums[i + 1];
            result[i] *= temp;
        }
        return result;
    }
}
