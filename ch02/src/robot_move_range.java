public class robot_move_range {

    public static void main(String[] args) {

        int rows = 3;
        int cols = 4;
        int threshold = 3;
        int range = range(rows, cols, threshold);
        System.out.println("机器人的运动范围为：" + range);
    }

    public static int range(int rows, int cols, int threshold){

        int row = 0;
        int col = 0;
        boolean[][] visited = new boolean[rows][cols];
        int count = count_range(rows, cols, row, col, visited, threshold);
        return count;
    }

    public static int count_range(int rows, int cols, int row, int col, boolean[][] visited, int threshold){

        int count = 0;
        if (check(rows, cols, row, col, visited, threshold)){
            count = 1 + count_range(rows, cols, row - 1, col, visited, threshold)
                    + count_range(rows, cols, row + 1, col, visited, threshold)
                    + count_range(rows, cols, row, col - 1, visited, threshold)
                    + count_range(rows, cols, row, col + 1, visited, threshold);
        }
        return count;
    }

    public static boolean check(int rows, int cols, int row, int col, boolean[][] visited, int threshold){

        if (row >= 0 && row < rows && col >= 0 && col < cols && !visited[row][col]) {
            if ((digitSum(row) + digitSum(col)) <= threshold) {
                visited[row][col] = true;
                return true;
            }
        }
        return false;
    }

    public static int digitSum(int num){

        int sum = 0;
        int temp = num;
        while (temp > 0){
            sum += temp % 10;
            temp = temp / 10;
        }
        return sum;
    }
}
