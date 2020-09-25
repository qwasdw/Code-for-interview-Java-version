import com.sun.xml.internal.ws.api.message.ExceptionHasMessage;

public class find_min_number_in_rotate_array {


    public static void main(String[] args) {

        int[] nums = {};
        int min = findMinNumber(nums);
        if (min != -1)
            System.out.println("最小数为：" + min);
    }

    public static int findMinNumber(int[] nums){

        if (nums == null || nums.length <= 0) {
                System.out.println("数组不能为空");
                return -1;
        }
        int start = 0;
        int end = nums.length - 1;
        int mid = (end + start) / 2 ;

        while (nums[start] >= nums[end]){

            if (end - start == 1){
                mid = end;
                break;
            }
            mid = (start + end) / 2;
            if (nums[start] == nums[end] && nums[mid] == nums[start]){
                int min = nums[0];
                for (int i = 1; i < nums.length; i++){
                    if (min > nums[i])
                        min = nums[i];
                }
                return min;
            }
            if (nums[mid] >= nums[start])
                start = mid;
            else if (nums[mid] <= nums[end])
                end = mid;
        }
        return nums[mid];
    }
}
