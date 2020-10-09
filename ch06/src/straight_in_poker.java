import java.util.Arrays;

public class straight_in_poker {

    public static void main(String[] args) {

        int[] nums = {1, 0, 4, 3, 2};
        System.out.println(isContinuous(nums));
    }

    public static boolean isContinuous(int[] nums){

        if (nums == null || nums.length < 5)
            return false;
        Arrays.sort(nums);
        int numOfZero = 0;
        int numOfGap = 0;
        for (int i = 0; i < nums.length && nums[i] == 0; i++)
            numOfZero++;
        int small = numOfZero;
        int big = small + 1;
        while (big < nums.length){
            if (nums[small] == nums[big])
                return false;
            numOfGap += nums[big] - nums[small] - 1;
            small = big;
            big++;
        }
        return numOfGap <= numOfZero;
    }
}
