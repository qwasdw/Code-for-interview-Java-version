import javax.annotation.processing.RoundEnvironment;

public class path_in_matrix {

    public static void main(String[] args) {

        String[][] matrix = {
                {"a", "b", "t", "g"},
                {"c", "f", "c", "s"},
                {"j", "d", "e", "h"},
        };
        String[] path = {"b", "f", "c", "e"};
        boolean hasPath = findPath(matrix, path);
        if (hasPath) {
            System.out.print("存在路径：");
            for (int i = 0; i < path.length; i++) {
                System.out.print("->" + path[i]);
            }
        }
        else {
            System.out.print("不存在路径：");
            for (int i = 0; i < path.length; i++) {
                System.out.print("->" + path[i]);
            }

        }
    }

    public static boolean findPath(String[][] matrix, String[] path){
        if (matrix == null || matrix.length < 1 || matrix[0].length < 1 || path == null)
            return false;
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        int pathLength = 0;
        for (int row = 0; row < matrix.length; row++){
            for (int col = 0; col < matrix[0].length; col++){
                if (backtracking(matrix, row, col, path, visited, pathLength))
                    return true;
            }
        }
        return false;
    }

    public static boolean backtracking(String[][] matrix, int row, int col, String[] path,
                                       boolean[][] visited, int pathLength)
    {
        if (pathLength == path.length)
            return true;
        boolean hasPath = false;
        if (row >= 0 && row < matrix.length && col >= 0 && col < matrix[0].length
            && matrix[row][col] == path[pathLength] && !visited[row][col]){
            pathLength++;
            visited[row][col] = true;
            hasPath = backtracking(matrix, row - 1, col, path, visited, pathLength)
                    || backtracking(matrix, row + 1, col, path, visited, pathLength)
                    || backtracking(matrix, row, col - 1, path, visited, pathLength)
                    || backtracking(matrix, row, col + 1, path, visited, pathLength);
            if (!hasPath){
                pathLength--;
                visited[row][col] = false;
            }
        }
        return hasPath;
    }
}
