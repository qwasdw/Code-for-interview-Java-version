public class find_number_in_2D_array
{
    public static void main(String[] args) {
        int[][] nums = {
                {1, 2, 8, 9},
                {2, 4, 9, 12},
                {4, 7, 10, 13},
                {6, 8, 11, 15}
        };
        int target = 7;
        boolean found = findNumber(nums, target);
        if (found)
            System.out.println("数组中存在数字：" + target);
        else
            System.out.println("数组中不存在数字：" + target);
    }

    public static boolean findNumber(int[][] nums, int target)
    {
        if (nums == null || nums.length <= 0 || nums[0].length <= 0)
            return false;
        boolean found = false;
        int row = 0;
        int column = nums[0].length - 1;
        while (row < nums.length && column >= 0)
        {
            if (nums[row][column] == target) {
                found = true;
                break;
            }
            else if (nums[row][column] > target)
                --column;
            else
                ++row;
        }
        return found;
    }
}
