import java.util.Arrays;

public class inverse_pairs_in_array {

    public static void main(String[] args) {

        int[] data = {7, 5, 6, 4, 3};
//        int result = inversePairs(data);
        int result = inversePairs1(data);
        System.out.println(result);
        System.out.println(Arrays.toString(data));
    }

    public static int inversePairs(int[] data){

        if (data == null || data.length <= 0)
            return 0;
        int[] copy = new int[data.length];
        System.arraycopy(data, 0, copy, 0, data.length);
        int count = inversePairsCore(data, copy, 0, data.length - 1);
        return count;
    }

    public static int inversePairs1(int[] data){

        if (data == null || data.length <= 0)
            return 0;
        int[] copy = new int[data.length];
        int count = sort(data, copy, 0, data.length - 1);
        return count;
    }


    public static int inversePairsCore(int[] data, int[] copy, int start, int end){

        if (start == end){
            copy[start] = data[end];
            return 0;
        }
        int length = (end - start) / 2;
        int left = inversePairsCore(copy, data, start, start + length);
        int right = inversePairsCore(copy, data, start + length + 1, end);
        int i = start + length;
        int j = end;
        int indexCopy = end;
        int count = 0;
        while (i >= start && j >= start + length + 1){
            if (data[i] > data[j]){
                copy[indexCopy--] = data[i--];
                count += j - start - length;
            }
            else
                copy[indexCopy--] = data[j--];
        }
        for (; i >= start; i--)
            copy[indexCopy--] = data[i];
        for (; j >= start + length + 1; j--)
            copy[indexCopy--] = data[j];
        return left + right + count;
    }

    public static int sort(int[] data, int[] copy, int low, int high){

        if (low >= high)
            return 0;
        int mid = low + (high - low) / 2;
        int left = sort(data, copy, low, mid);
        int right = sort(data, copy, mid + 1, high);
        int count = merge(data, copy, low, mid, high);
        return left + right + count;
    }

    public static int merge(int[] data, int[] copy, int low, int mid, int high){

        int count = 0;
        int i = mid;
        int j = high;
        for (int k = low; k <= high; k++)
            copy[k] = data[k];
        for (int k = high; k >= low; k--){
            if (i < low)
                data[k] = copy[j--];
            else if (j < mid + 1)
                data[k] = copy[i--];
            else if (copy[i] > copy[j]){
                count += j - mid;
                data[k] = copy[i--];
            }
            else
                data[k] = copy[j--];
        }
        return count;
    }
}
