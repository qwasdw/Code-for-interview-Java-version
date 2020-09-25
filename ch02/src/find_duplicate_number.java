public class find_duplicate_number
{
    public static void main(String[] args)
    {
        int[] nums = {100};
        int[] duplication = new int[1];
        boolean exist = findDuplicateNumber(nums, duplication);
        if (exist)
            System.out.println("重复数字为： " + duplication[0]);
    }

    public static boolean findDuplicateNumber(int[] nums, int[] duplication)
    {
        if (nums == null || nums.length <= 0) {
            System.out.println("数组不能为空");
            return false;
        }
        for (int i = 0; i < nums.length; i++)
        {
            if (nums[i] < 0 || nums[i] >= nums.length)
                System.out.println("数组格式错误");
                return false;
        }
        for (int i = 0; i < nums.length; i++)
        {
            while (nums[i] != i) {
                if (nums[i] == nums[nums[i]]) {
                    duplication[0] = nums[i];
                    return true;
                }
                else
                {
                    int temp = nums[i];
                    nums[i] = nums[temp];
                    nums[temp] = temp;
                }
            }
        }
        System.out.println("不存在重复数字");
        return false;
    }
}
