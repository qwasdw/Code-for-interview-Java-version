import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class min_k_num {

    public static void main(String[] args) {

        int[] nums = {3, 2, 6, 0, 1, 7};
        int[] result = minKNum(nums, 3);
        System.out.println(Arrays.toString(result));
        Integer[] result1 = minKNum1(nums, 3);
        System.out.println(Arrays.toString(result));
    }

    public static int[] minKNum(int[] nums, int k){

        if (nums == null || k < 1 || k > nums.length)
            return null;
        int start = 0;
        int end = nums.length - 1;
        int index = partition(nums, start, end);
        while (index != k - 1){
            if (index > k - 1){
                end = index - 1;
                index = partition(nums, start, end);
            }
            else {
                start = index + 1;
                index = partition(nums, start, end);
            }
        }
        int[] result = new int[k];
        for (int i = 0; i < k; i++)
            result[i] = nums[i];
        return result;
    }

    public static int partition(int[] nums, int start, int end){

        int i = start;
        int j = end;
        int x = nums[start];
        while (i < j){
            while (i < j && nums[j] >= x)
                j--;
            if (i < j){
                nums[i] = nums[j];
                i++;
            }
            while (i < j && nums[i] < x)
                i++;
            if (i < j){
                nums[j] = nums[i];
                j--;
            }
        }
        nums[i] = x;
        return i;
    }

    public static Integer[] minKNum1(int[] nums, int k){

        if (nums == null || k < 1 || k > nums.length)
            return null;
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
        for (int num : nums){
            queue.add(num);
            if (queue.size() > k)
                queue.remove();
        }
        Integer[] result = queue.toArray(new Integer[k]);
        return result;
    }
}
