import java.util.ArrayList;
import java.util.Arrays;

public class n_dice_points {

    public static void main(String[] args) {

        int n = 3;
        System.out.println(probability(n));
    }

    public static ArrayList<Double> probability(int n){

        if (n < 1)
            return null;
        int maxValue = 6;
        int[][] probabilities = new int[2][maxValue * n + 1];
        int flag = 0;
        for (int i = 1; i <= maxValue; i++)
            probabilities[flag][i] = 1;
        for (int k = 2; k <= n; k++){
            for (int i = 0; i < k; i++)
                probabilities[1 - flag][i] = 0;
            for (int i = k; i <= maxValue * k; i++){
                probabilities[1 - flag][i] = 0;
                for (int j = 1; j <= i && j <= maxValue; j++)
                    probabilities[1 - flag][i] += probabilities[flag][i - j];
            }
            flag = 1 - flag;
        }
        double total = Math.pow((double)maxValue, n);
        ArrayList<Double> result = new ArrayList<>();
        for (int i = n; i <= maxValue * n; i++)
            result.add((double)probabilities[flag][i] / total);
        return result;
    }
}
