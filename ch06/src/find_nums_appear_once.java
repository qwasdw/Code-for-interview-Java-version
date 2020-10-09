import java.util.Arrays;

public class find_nums_appear_once {

    public static void main(String[] args) {

        int[] data = {2, 4, 3, 6, 3, 2, 5, 5};
        int[] result = findNumsAppearOnce(data);
        System.out.println(Arrays.toString(result));

        int[] data1 = {2, 2, 3, 5, 2, 5, 5};
        int result1 = findNumberAppearOnce(data1);
        System.out.println(result1);
    }

    public static int[] findNumsAppearOnce(int[] data){

        if (data == null || data.length < 2)
            return null;
        int[] result = new int[2];
        int resultXOR = 0;
        for (int num : data)
            resultXOR ^= num;
        int indexOf1 = findFirstBitIs1(resultXOR);
        for (int i = 0; i < data.length; i++){
            if (isBit1(data[i], indexOf1))
                result[0] ^= data[i];
            else result[1] ^= data[i];
        }
        return result;
    }

    public static int findFirstBitIs1(int num){
        int indexBit = 0;
        while ((num & 1) == 0 && indexBit < 32){
            num = num >>> 1;
            indexBit++;
        }
        return indexBit;
    }

    public static boolean isBit1(int num, int indexBit){
        num = num >>> indexBit;
        return (num & 1) == 1;
    }

    public static int findNumberAppearOnce(int[] data){

        if (data == null || data.length < 1)
            throw new RuntimeException("数组为空");
        int[] bitSum = new int[32];
        for (int i = 0; i < data.length; i++){
            int m = data[i];
            for (int j = 31; j >= 0; j--){
                if ((m & 1) == 1)
                    bitSum[j]++;
                m = m >>> 1;
            }
        }
        int result = 0;
        for (int i = 0; i < 32; i++){
            result = result << 1;
            result += bitSum[i] % 3;
        }
        return result;
    }
}
