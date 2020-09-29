public class print_matrix_clockwise {

    public static void main(String[] args) {

        int[][] matrix = {
                {1, 2, 3, 4},
                {12, 13, 14, 5},
                {11, 16, 15, 6},
                {10, 9, 8, 7},
        };
        printMatrix(matrix);
    }

    public static void printMatrix(int[][] matrix){

        if (matrix == null || matrix.length <= 0 || matrix[0].length <= 0)
            return;
        int start = 0;
        while (start * 2 < matrix.length
                && start * 2 < matrix[0].length){
            printInCircle(matrix, start);
            start++;
        }
    }

    public static void printInCircle(int[][] matrix, int start){

        int endX = matrix[0].length - 1 - start;
        int endY = matrix.length - 1 - start;

        for (int i = start; i <= endX; i++)
            System.out.println(matrix[start][i]);

        if (start < endY){
            for (int i = start + 1; i <= endY; i++)
                System.out.println(matrix[i][endX]);
        }

        if (start < endX && start < endY){
            for (int i = endX - 1; i >= start; i--)
                System.out.println(matrix[endY][i]);
        }

        if (start < endX && start < endY - 1){
            for (int i = endY - 1; i >= start + 1; i--)
                System.out.println(matrix[i][start]);
        }

    }
}
