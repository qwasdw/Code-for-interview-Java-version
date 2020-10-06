public class maximum_value_of_gifts {

    public static void main(String[] args) {

        int[][] nums = {
                {1, 10, 3, 8},
                {12, 2, 9, 6},
                {5, 7, 4, 11},
                {3, 7, 16, 5}
        };
        int value = maxValue(nums);
        System.out.println(value);
    }

    public static int maxValue(int[][] nums){

        if (nums == null)
            return 0;
        int[][] values = new int[nums.length][nums[0].length];
        values[0][0] = nums[0][0];
        for (int i = 1; i < nums.length; i++) {
            values[i][0] = nums[i][0] + values[i - 1][0];
        }
        for (int i = 1; i < nums[0].length; i++) {
            values[0][i] = nums[0][i] + values[0][i - 1];
        }
        for (int i = 1; i < nums.length; i++)
            for (int j = 1; j < nums[0].length; j++){
                int temp1 = values[i -1][j] + nums[i][j];
                int temp2 = values[i][j - 1] + nums[i][j];
                if (temp1 < temp2)
                    values[i][j] = temp2;
                else
                    values[i][j] = temp1;
            }
        return values[nums.length - 1][nums[0].length - 1];
    }
}
