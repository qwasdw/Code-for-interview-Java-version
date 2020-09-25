public class find_duplicate_number_2
{
    /**
     * 不交换位置找到重复数字
     */
    public static void main(String[] args)
    {
        int[] nums = {2, 3, 5, 4, 3, 2, 6, 7};
        int duplicateNum = getDuplication(nums);
        if ( duplicateNum != -1)
            System.out.println("重复数字为：" + duplicateNum);
        else
            System.out.println("不存在重复数字");
    }

    public static int getDuplication(int[] nums)
    {
        if (nums == null || nums.length <= 0)
            return -1;
        int start = 1;
        int end = nums.length - 1;
        while (end >= start)
        {
            int middle = (end - start) / 2 + start;
            int count = countRange(nums, start, middle);
            if (end == start)
            {
                if (count > 1)
                    return start;
                else
                    break;
            }
            if (count > (middle - start + 1))
                end = middle;
            else
                start = middle + 1;
        }
        return -1;
    }

    public static int countRange(int[] nums, int start, int end)
    {
        if (nums == null)
            return 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++)
        {
            if (nums[i] >= start && nums[i] <= end)
                ++count;
        }
        return count;
    }
}
