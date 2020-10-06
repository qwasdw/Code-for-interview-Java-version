public class numbers_occur_more_than_half_time_in_array {

    public static void main(String[] args) {

        int[] nums = {1, 2, 3, 2, 2, 2, 5, 4, 2};
        int num = findNum(nums);
        if (num != -1)
            System.out.println(num);
        else
            System.out.println("不存在");
    }

    public static int findNum(int[] nums) {

        if (nums == null)
            return -1;
        int target = nums[0];
        int times = 1;
        for (int i = 1; i < nums.length; i++) {
            if (times == 0) {
                target = nums[i];
                times = 1;
            } else if (nums[i] == target)
                times++;
            else
                times--;
        }
        times = 0;
        for (int num : nums) {
            if (num == target)
                times++;
        }
        if (times > nums.length / 2)
            return target;
        return -1;
    }
}
