public class ugly_number {

    public static void main(String[] args) {

        int index = 15;
        int num = getUglyNumber(index);
        System.out.println(num);
    }

    public static int getUglyNumber(int index){

        if (index <= 0)
            return 0;
        int[] uglyNumbers = new int[index];
        uglyNumbers[0] = 1;
        int nextUglyIndex = 1;
        int index2 = 0;
        int index3 = 0;
        int index5 = 0;
        int multiply2 = uglyNumbers[0];
        int multiply3 = uglyNumbers[0];
        int multiply5 = uglyNumbers[0];
        while (nextUglyIndex < index){
            int min = min(multiply2 * 2, multiply3 * 3, multiply5 * 5);
            uglyNumbers[nextUglyIndex] = min;
            while (multiply2 * 2 <= min) {
                index2++;
                multiply2 = uglyNumbers[index2];
            }
            while (multiply3 * 3 <= min) {
                index3++;
                multiply3 = uglyNumbers[index3];
            }
            while (multiply5 * 5 <= min) {
                index5++;
                multiply5 = uglyNumbers[index5];
            }
            nextUglyIndex++;
        }
        return uglyNumbers[index - 1];
    }

    public static int min(int num1, int num2, int num3){

        int min = Math.min(num1, num2);
        min = Math.min(min, num3);
        return min;
    }
}
