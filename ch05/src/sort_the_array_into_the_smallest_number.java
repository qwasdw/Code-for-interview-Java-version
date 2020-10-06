import java.util.ArrayList;
import java.util.List;

public class sort_the_array_into_the_smallest_number {

    public static void main(String[] args) {

        int[] nums = {3, 32, 1};
        String string = sort(nums);
        System.out.println(string);
    }

    public static String sort(int[] nums){

        if (nums == null)
            return "";
        List<Integer> list = new ArrayList<>();
        for (int num : nums)
            list.add(num);
        list.sort((a, b) -> (a + "" + b).compareTo(b + "" + a));
        String string = "";
        for (int num : list)
            string += num;
        return string;
    }
}
