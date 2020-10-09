public class find_number_in_sorted_array {

    public static void main(String[] args) {

        int[] data = {1, 2, 3, 3, 3, 3, 4 ,5};
        int result = getNumberOfK(data, 1);
        System.out.println(result);

        int[] data1 = {1, 2, 3, 4, 5};
        int result1 = getMissingNumber(data1);
        System.out.println(result1);

        int[] data2 = {-3, -1, 1, 3, 5};
        int result2 = getNumberSameAsIndex(data2);
        System.out.println(result2);

    }

    public static int getNumberOfK(int[] data, int k){

        int number = 0;
        if (data != null && data.length > 0){
            int first = getFirstK(data, k, 0, data.length - 1);
            int last = getLastK(data, k, 0, data.length - 1);
            if (first > -1 && last > -1)
                number = last - first + 1;
        }
        return number;
    }

    public static int getFirstK(int[] data, int k, int start, int end){

        while (start <= end){
            int mid = (start + end) / 2;
            if (data[mid] == k){
                if (mid > 0){
                    if (data[mid - 1] == k)
                        end = mid - 1;
                    else
                        return mid;
                }
                else
                    return mid;
            }
            else if (data[mid] < k){
                start = mid + 1;
            }
            else {
                end = mid - 1;
            }
        }
        return -1;
    }

    public static int getLastK(int[] data, int k, int start, int end){

        while (start <= end){
            int mid = (start + end) / 2;
            if (data[mid] == k){
                if (mid < data.length - 1){
                    if (data[mid + 1] == k)
                        start = mid + 1;
                    else
                        return mid;
                }
                else
                    return mid;
            }
            else if (data[mid] < k){
                start = mid + 1;
            }
            else {
                end = mid - 1;
            }
        }
        return -1;
    }

    public static int getMissingNumber(int[] data){

        if (data == null || data.length <= 0)
            return -1;
        int start = 0;
        int end = data.length - 1;
        while (start <= end){
            int mid = (start + end) / 2;
            if (data[mid] != mid){
                if (mid > 0){
                    if (data[mid - 1] != mid - 1)
                        end = mid - 1;
                    else
                        return mid;
                }
                else
                    return mid;
            }
            else {
                start = mid + 1;
            }
        }
        return -1;
    }

    public static int getNumberSameAsIndex(int[] data){

        if (data == null || data.length <= 0)
            return -1;
        int start = 0;
        int end = data.length - 1;
        while (start <= end){
            int mid = (start + end) / 2;
            if (data[mid] < mid)
                start = mid + 1;
            else if (data[mid] > mid)
                end = mid - 1;
            else
                return mid;
        }
        return -1;
    }
}
