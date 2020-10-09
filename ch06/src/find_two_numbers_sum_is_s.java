import java.util.Arrays;

public class find_two_numbers_sum_is_s {

    public static void main(String[] args) {

        int[] data = {1, 2, 4, 7, 11, 15};
        int[] result = findTwoNums(data, 15);
        System.out.println(Arrays.toString(result));

        findContinuousSequence(15);
    }

    public static int[] findTwoNums(int[] data, int s){

        if (data == null || data.length < 2)
            return null;
        int i = 0;
        int j = data.length - 1;
        int[] result = new int[2];
        while (i < j){
            if (data[i] + data[j] == s){
                result[0] = data[i];
                result[1] = data[j];
                break;
            }
            else if (data[i] + data[j] > s)
                j--;
            else
                i++;
        }
        return result;
    }

    public static void findContinuousSequence(int sum){

        if (sum < 3)
            return;
        int small = 1;
        int big = 2;
        int middle = (1 + sum) / 2;
        int curSum = small + big;
        while (small < middle){
            if (curSum == sum)
                printContinuousSequence(small, big);
            while (curSum > sum && small < middle){
                curSum -= small;
                small++;
                if (curSum == sum)
                    printContinuousSequence(small, big);
            }
            big++;
            curSum += big;
        }
    }

    public static void printContinuousSequence(int small, int big){

        for (int i = small; i <= big; i++)
            System.out.print("->" + i);
        System.out.println();
    }
}
